
package Farmacia.Datos;

import Farmacia.Utilitario.Utilitarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class NotaBodega 
{   
    public static final int INGRESO=1;
    public static final int EGRESO=2;
    
    private int _tipoIE;
    private String _numero;
    private Date _fechaMov;
    private String _idBodega;
    private Date _fechaSolicitud;
    private String _solicitante;
    private String _codBodeguero;
    private String _justificativo;
    
    private ArrayList<NotaBodegaItem> detalle;

    
    public NotaBodega()
    {
        this.detalle= new ArrayList<>();
    }
    public NotaBodega(int tipoInEg, String numero,Date fechaMovimiento)
    {
        this._tipoIE = tipoInEg;
        this._numero = numero;
        this._fechaMov = fechaMovimiento;
    }
    
    public String GetStringDetalle()
    {
        String detalles = "";
        for(int i=0;i<detalle.size();i++)
        {
            NotaBodegaItem item = detalle.get(i);
            detalles+= item.codigoMed + "|$" + item.descripcionMed + "|$" + item.cantidad + "|$" + 
                        item.noLote + "|$" + Utilitarios.DateToStringDataBase(item.fechaCaduca) + "@#";
        }
        
        return detalles;
    }
    
    public String ingresar(String claveUser)
    {
        Connection cn =null;
        String msgOut = "";
        try
        {
            ResultSet rs = null;
            cn = ConnectFarmacia.obtener(claveUser);
            CallableStatement cst = cn.prepareCall("{call GuardarNotaIngEgr(?,?,?,?,?,?,?,?,?,?)}");
            /*PARAMETROS*/
            cst.setInt(1,this._tipoIE);
            cst.setString(2,this._idBodega);
            cst.setString(3,this._codBodeguero);
            cst.setString(4,this._solicitante);
            cst.setString(5,Utilitarios.DateToStringDataBase(this._fechaMov));
            cst.setString(6,Utilitarios.DateToStringDataBase(this._fechaSolicitud));
            cst.setString(7,this._numero);
            cst.setString(8,this._justificativo);
            cst.setString(9,GetStringDetalle());
            cst.registerOutParameter(10, Types.VARCHAR);
            
            cst.executeUpdate();
            msgOut = cst.getString(10);
        }
        catch(Exception ex)
        {
            msgOut = "Error de conexion base datos";
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
        return msgOut;
    }
    
    public int getTipoIE() {
        return _tipoIE;
    }

    public void setTipoIE(int _tipoIE) {
        this._tipoIE = _tipoIE;
    }

    public String getNumero() {
        return _numero;
    }

    public void setNumero(String _numero) {
        this._numero = _numero;
    }

    public Date getFechaMov() {
        return _fechaMov;
    }

    public void setFechaMov(Date _fechaMov) {
        this._fechaMov = _fechaMov;
    }

    public Date getFechaSolicitud() {
        return _fechaSolicitud;
    }

    public void setFechaSolicitud(Date _fechaSolicitud) {
        this._fechaSolicitud = _fechaSolicitud;
    }

    public String getSolicitante() {
        return _solicitante;
    }

    public void setSolicitante(String _solicitante) {
        this._solicitante = _solicitante;
    }

    public String getCodBodeguero() {
        return _codBodeguero;
    }

    public void setCodBodeguero(String _codBodeguero) {
        this._codBodeguero = _codBodeguero;
    }
    
    public ArrayList<NotaBodegaItem> getDetalle() {
        return detalle;
    }

    public String getIdBodega() {
        return _idBodega;
    }

    public void setIdBodega(String idBodega) {
        this._idBodega = idBodega;
    }

    public String getJustificativo() {
        return _justificativo;
    }

    public void setJustificativo(String justificativo) {
        this._justificativo = justificativo;
    }
    
    public class NotaBodegaItem
    {
        private String codigoMed;
        private String descripcionMed;
        private int cantidad;
        private String noLote;
        private Date fechaCaduca;
        
        public NotaBodegaItem()
        {
            
        }
        public NotaBodegaItem(String codigoMed, String descripcion, int cantidad,
                        String noLote, Date fechaCaduca)
        {
            this.codigoMed = codigoMed;
            this.descripcionMed = descripcion;
            this.cantidad = cantidad;
            this.noLote = noLote;
            this.fechaCaduca = fechaCaduca;
        }
                    
         public String getCodigoMed() {
            return codigoMed;
        }

        public void setCodigoMed(String codigoMed) {
            this.codigoMed = codigoMed;
        }

        public String getDescripcionMed() {
            return descripcionMed;
        }

        public void setDescripcionMed(String descripcionMed) {
            this.descripcionMed = descripcionMed;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getNoLote() {
            return noLote;
        }

        public void setNoLote(String noLote) {
            this.noLote = noLote;
        }

        public Date getFechaCaduca() {
            return fechaCaduca;
        }

        public void setFechaCaduca(Date fechaCaduca) {
            this.fechaCaduca = fechaCaduca;
        }
    }
}
