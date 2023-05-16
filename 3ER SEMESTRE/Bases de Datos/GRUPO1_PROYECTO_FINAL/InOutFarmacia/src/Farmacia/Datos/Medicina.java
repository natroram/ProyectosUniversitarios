
package Farmacia.Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicina {

    private String _codigo;
    private String _nombre;
    private String _descripcion;
    
    
    public static Medicina ConsularxCodigo(String clave,String codigo)
    {
        Medicina med=null;
        Connection cn =null;
        try
        {
            ResultSet rs = null;
            cn = ConnectFarmacia.obtener(clave);
            CallableStatement cst = cn.prepareCall("{call ConsultaMedicinaxCodigo(?)}");
            cst.setString(1, codigo);
            rs = cst.executeQuery();
            if(rs.next())
            {
                med = new Medicina();
                med._codigo = rs.getString("codigo");
                med._nombre = rs.getString("nombre");
                med._descripcion = rs.getString("descripcion");
            }
        }
        catch(Exception ex)
        {
            med = null;
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
        
        return med;
    }
    
    @Override
    public String toString()
    {
        return this._nombre;
    }
    
    public String getCodigo() {
        return _codigo;
    }

    public void setCodigo(String _codigo) {
        this._codigo = _codigo;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
}
