package proyecto.k;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorTime {

    static Date FechaSystem = new Date();
    static SimpleDateFormat fechaformato = new SimpleDateFormat("dd/MM/YYYY   -   HH:mm:ss");
    public static String FfechaSystem = fechaformato.format(FechaSystem);

    public static void setFfechaSystem(String ffechaSystem) {
        FfechaSystem = ffechaSystem;
    }

    public static String getFfechaSystem() {
        return FfechaSystem;
    }

}
