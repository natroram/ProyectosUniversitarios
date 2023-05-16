package exampledao.dao.common;

import java.sql.*;

/**
 * Representa un objeto conexi�n cokpletamente abstracto. Se han inclu�do los campos
 * necesarios para conexiones con bases de datos t�picas como Oracle, MySql, SqlServer,
 * etc.
 * Esta clase no se puede utilizar directamente, se la utiliza a trav�s de instancias
 * de subclases de esta clase. Las instancias implementan los accesos y la forma de
 * los queries en cada caso.
 * 
 * @author Vladimir Calder�n
 *
 */
public abstract class Conexion implements IConexion {

    /**
     * El host/servidor de la base de datos
     */
    protected String host;

    /**
     * El nombre de la base de datos.
     */
    protected String database;

    /**
     * El nombre de la instancia de la base de datos (caso MIcrosoft)
     */
    protected String instance;

    /**
     * El puerto de acceso a la base de datos.
     */
    protected int port;

    /**
     * El usuario con el cual se accede a la base de datos.
     */
    protected String username;

    /**
     * La contrase�a utilizada
     */
    protected String password;

    /**
     * El objeto de tipo conexi�n que es de tipo de la interfase JDBC. Entonces,
     * cualquier implementaci�n de Driver de Java de acceso a datos debe respetar
     * esta interfase.
     */
    protected Connection con;

    /**
     * Se maneja la conexi�n con el patr�n de dise�o Singleton. Esto para que haya 
     * solo una instancia de la conexi�n y no se abran innecesariamente otras.
     */
    protected static Conexion singleton;

    /**
     * Implementaci�n del patr�n singleton. Este m�todo permit obtener o crear
     * la �nica instancia de tipo Conexion que est� permitida existir.
     * 
     * @return Ul �nico objeto de tipo conexi�n que existe en la aplicaci�n.
     */
    public static Conexion getOrCreate() {
        if (singleton == null) {
            singleton = ConexionMySql.getOrCreate();
        }
        singleton.conectar();
        return singleton;
    }

    /**
     * @return Returns the database.
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @return Returns the host.
     */
    public String getHost() {
        return host;
    }

    /**
     * @return Returns the instance.
     */
    public String getInstance() {
        return instance;
    }

    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return Returns the port.
     */
    public int getPort() {
        return port;
    }

    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return username;
    }
}
