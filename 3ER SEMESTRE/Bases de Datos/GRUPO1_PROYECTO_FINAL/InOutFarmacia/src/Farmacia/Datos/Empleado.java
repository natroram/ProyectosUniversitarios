
package Farmacia.Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Empleado {
    private String _id;
    private String _cedula;
    private String _nombre;
    private String _apellido;
    private String _sueldo;
    
    public Empleado()
    {
        
    }
    
    public static ArrayList<Empleado> ConsularTodosEmpleados(String clave)
    {
        ArrayList<Empleado> empleados = null;
        Connection cn = null;
        try
        {
            ResultSet rs = null;
            cn = ConnectFarmacia.obtener(clave);
            CallableStatement cst = cn.prepareCall("{call ConsultaEmpleados()}");
            rs = cst.executeQuery();
            while(rs.next())
            {
                if(empleados==null)
                    empleados = new ArrayList<>();
                Empleado emp = new Empleado();
                emp._id = rs.getString("id");
                emp._cedula = rs.getString("cedula");
                emp._nombre = rs.getString("nombre");
                emp._apellido = rs.getString("apellido");
                empleados.add(emp);
            }
        }
        catch(Exception ex)
        {
            empleados = null;
        }
        finally{
            try
            {
                ConnectFarmacia.cerrar();
            }
            catch(SQLException sql)
            {
            }
        }
        
        return empleados;
    }
    
    @Override
    public String toString()
    {
        return (this._nombre + " " + this._apellido);
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCedula() {
        return _cedula;
    }

    public void setCedula(String _cedula) {
        this._cedula = _cedula;
    }

    public String getSueldo() {
        return _sueldo;
    }

    public void setSueldo(String _sueldo) {
        this._sueldo = _sueldo;
    }
}
