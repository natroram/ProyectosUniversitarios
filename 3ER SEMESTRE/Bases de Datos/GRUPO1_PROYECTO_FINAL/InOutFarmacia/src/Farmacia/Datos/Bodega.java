
package Farmacia.Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Bodega {

    private String _id;
    private String _descripcion;
    private String _direccion;
    
    public Bodega()
    {
        
    }
    
    public static ArrayList<Bodega> ConsularTodasBodegas(String clave)
    {
        ArrayList<Bodega> bodegas = null;
        Connection cn = null;
        try
        {
            ResultSet rs = null;
            cn = ConnectFarmacia.obtener(clave);
            CallableStatement cst = cn.prepareCall("{call ConsultaBodegas()}");
            rs = cst.executeQuery();
            while(rs.next())
            {
                if(bodegas==null)
                    bodegas = new ArrayList<>();
                Bodega bod = new Bodega();
                bod._id = rs.getString("Id_Bodega");
                bod._descripcion = rs.getString("descripcion");
                bod._direccion = rs.getString("direccion");
                bodegas.add(bod);
            }
        }
        catch(Exception ex)
        {
            bodegas = null;
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
        
        return bodegas;
    }
    
    @Override
    public String toString()
    {
        return this._descripcion;
    }
    
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }
}
