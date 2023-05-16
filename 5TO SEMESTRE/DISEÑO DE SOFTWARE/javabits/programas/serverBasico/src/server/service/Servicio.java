package server.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.stat.MensajeTipo;
import server.stat.MensajeTipo.Tipo;

public abstract class Servicio extends Observable implements Runnable {

	private static final Logger log = LogManager.getLogger();

	private static int proximoId = 1;
	protected Socket cliente;
	protected BufferedReader clienteInput;
	protected PrintWriter clienteOutput;
	protected BufferedOutputStream clienteDataOutput;
	protected int id;

	public static synchronized Servicio construirServicio(String nombre)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Servicio resultado = (Servicio) (Class.forName("server.service.Servicio" + nombre).newInstance());
		resultado.setId(proximoId);
		proximoId++;
		return resultado;
	}

	public void configurar(Socket clt) throws IOException {
		this.cliente = clt;
		this.clienteInput = new BufferedReader(new InputStreamReader(clt.getInputStream()));
	}

	public void run() {
		servir();
	}

	public abstract void servir();

	protected void cerrar() {
		
		try {
			if (clienteDataOutput != null)
				clienteDataOutput.close();
			if (clienteOutput != null)
				clienteOutput.close();			
		} catch (IOException e) {
			log.error("No se pudo cerrar el stream cliente de salida " + id);
		}
		
		try {
			clienteInput.close();
		} catch (IOException e) {
			log.error("No se pudo cerrar el stream cliente de entrada " + id);
		}
		
		try {
			cliente.close();
			cliente = null;
			log.info("Se cierra el socket y la comunicaci�n con el cliente " + id);
		} catch (IOException e) {
			log.error("No se pudo cerrar el socket cliente");
		}
	}

	protected String leer() throws IOException {
		String linea = clienteInput.readLine();
		if (linea == null) {
			log.debug("Ya llegamos al final del stream, return null");
			return null;
		}
		this.setChanged();
		this.notifyObservers(new MensajeTipo(linea, Tipo.ENTRADA));
		log.info("-CLIENTE- " + linea);
		return linea;
	}

	protected void escribir(String msg) {
		escribir(msg, false);
	}

	protected void escribir(String msg, boolean doFlush) {
		if (msg == null)
			clienteOutput.println();
		else
			clienteOutput.println(msg);
		if (doFlush)
			clienteOutput.flush();

		if (msg == null) {
			log.info("-SERVER-");
			return;
		}
		this.setChanged();
		this.notifyObservers(new MensajeTipo(msg, Tipo.SALIDA));
		log.info("-SERVER- " + msg);
	}

	protected void escribirData(byte[] data) throws IOException {
		clienteDataOutput.write(data);
		clienteDataOutput.flush();
		this.setChanged();
		this.notifyObservers(new MensajeTipo(data, Tipo.SALIDA));
		log.info("-SERVER- data(" + data.length + " bytes)");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
