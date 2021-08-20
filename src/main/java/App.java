import util.JDBCUtilities;

import java.io.IOException;
//Librerías para el manejo de la base de datos
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle.Control;

import view.VistaRequerimientosReto4;
import controller.ControladorRequerimientosReto4;


 //SW Proyectos de Construcción 

 
public class App {
    public static void main( String[] args ){

        //Instanciar controlador e iniciarlo
        ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
        controlador.inicio();

        

    }
}
