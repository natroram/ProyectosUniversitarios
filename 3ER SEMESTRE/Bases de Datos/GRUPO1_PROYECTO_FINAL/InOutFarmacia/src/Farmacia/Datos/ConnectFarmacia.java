
package Farmacia.Datos;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectFarmacia {
   private static Connection cnx = null;
   
   public static Connection obtener(String claveUser) throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:8889/g1_proyecto", "root", claveUser);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
         cnx = null;
      }
   }
}
