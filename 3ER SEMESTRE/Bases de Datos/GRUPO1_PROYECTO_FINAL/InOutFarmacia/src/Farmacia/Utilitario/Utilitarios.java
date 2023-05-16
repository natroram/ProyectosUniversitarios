
package Farmacia.Utilitario;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilitarios {
    
    public static String DateToString(Date fecha)
    {
        String strFecha= "";
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        strFecha = formateador.format(fecha);
        return strFecha;
    }
    public static String DateToStringDataBase(Date fecha)
    {
        String strFecha= "";
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        strFecha = formateador.format(fecha);
        return strFecha;
    }
    public static Date StringToDate(String fecha)
    {
        Date fechaObj = null;
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            formateador.setLenient(false);
            fechaObj = formateador.parse(fecha);
        }
        catch(Exception ex)
        {
            fechaObj = null;
        }
        return fechaObj;
    }
}
