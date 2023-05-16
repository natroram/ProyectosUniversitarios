package exampledao.dao.common;

import java.sql.ResultSet;

/**
 * Interfase que representa a una conexi�n con una base de datos.
 * Esta conexi�n debe ser llamada solamente desde la capa de acceso a datos
 * La capa de negocios no tiene que estar ligada a esta capa.
 * @author Vladimir Calder�n
 *
 */
public interface IConexion {

    /**
     * Conecta a la base de datos. La manera de trabajo es tener un pool de 
     * conexiones abiertas y solamente se utiliza una de ellas
     * y se la libera. Entonces, cada vez que se pide una conexi�n,
     * en realidad se saca una y existente del pool de conexiones.
     * (Oracle, MySql, SqlServer,...) todos trabajan as� en los drivers tanto
     * para Java como para .NET
     *
     */
    public void conectar();

    /**
     * Una marca que se env�a a la conexi�n propiamente dicha para que no realice
     * el commit cuando se realiza un query.
     *
     */
    public void comenzarTransaccion();


    /**
     * Marca que se le env�a a la conexi�n real para confirmar una transacci�n.
     * Pensar por ejemplo en una transacci�n de tipo maestro detalle.
     *
     */
    public void terminarTransaccion();

    /**
     * Libera la conexi�n de la base de datos y la devuelve al pool de conexiones
     * de la misma.
     *
     */
    public void desconectar();

    /**
     * Ejecuta el query pasado en par�metro. EL resultado es un objeto de tipo 
     * ResultSet. Este objeto representa un resultado de varias columnas con 
     * varios registros donde cada uno indica el tipo de registro que 
     * representa.
     * 
     * @param query La ocnsulta en sql est�ndar, exclusivamente de tipo Select
     * @return El resultado en forma de objeto.
     */
    public ResultSet ejecutar(String query);

    /**
     * La ejecuci�n de un query de tipo Update, insert o delete.
     * 
     * @param query El query en par�metro
     * @return El n�mero de filas que han sido afectadas.
     */
    public int ejecutarSimple(String query);

    /**
     * Ejecuta un query de tipo insert para cuando se desea recuperar el id
     * del registro que se ha insertado.
     * 
     * @param query La consulta de tipo insert
     * @return El id (llave primaria) del registro
     */
    public int ejecutarInsert(String query);

    /**
     * Indica si la conexi�n se encuentra abierta. Si no, se la abre.
     * 
     * @return true o false
     */
    public boolean estaConectado();
}
