package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.Image;


//GUI
public class MenuRequerimientosGUI extends JFrame {

    //Controlador
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;
    private JButton btnCRUD_Materiales;

    public void iniciarGUI(){

        //Título
        setTitle("Menú de Requerimientos Empresa Constructora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Icono botón
        ImageIcon icono1 = new ImageIcon("img/trabajador.png");
        Image img1 = icono1.getImage();
        icono1 = new ImageIcon( img1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH) );
        //Crear (instanciar) los componentes 
        btnRequerimiento1 = new JButton(icono1);
        btnRequerimiento1.setFont(new Font("Dialog", Font.PLAIN, 24));       
        btnRequerimiento1.setText("Materiales de Producción Nacional Más Comprados");
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento1.setActionCommand("requerimiento1"); 
        
        //Icono botón
        ImageIcon icono3 = new ImageIcon("img/ranking.png");
        Image img3 = icono3.getImage();
        icono3 = new ImageIcon( img3.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH) );

        btnRequerimiento2 = new JButton(icono3);
        btnRequerimiento2.setFont(new Font("Dialog", Font.PLAIN, 24));
        btnRequerimiento2.setText("Proyectos con Mayor Compra de Granito");
        btnRequerimiento2.addActionListener(controlador);
        btnRequerimiento2.setActionCommand("requerimiento2");

        //Icono botón
        ImageIcon icono = new ImageIcon("img/asignacionCargo.png");
        Image img = icono.getImage();
        icono = new ImageIcon( img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH) );

        btnRequerimiento3 = new JButton(icono);
        btnRequerimiento3.setFont(new Font("Dialog", Font.PLAIN, 24));
        btnRequerimiento3.setText("Estadística Cargos Menos Asignados");
        btnRequerimiento3.addActionListener(controlador);
        btnRequerimiento3.setActionCommand("requerimiento3");

        ImageIcon icono2 = new ImageIcon("img/editar.png");
        Image img2 = icono2.getImage();
        icono2 = new ImageIcon( img2.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH) );
        
        btnCRUD_Materiales = new JButton(icono2);
        btnCRUD_Materiales.setFont(new Font("Dialog", Font.PLAIN, 24));
        btnCRUD_Materiales.setText("CRUD Materiales");
        btnCRUD_Materiales.addActionListener(controlador);
        btnCRUD_Materiales.setActionCommand("crudMateriales");

        //Añadir los componentes a contenedores o contenendores intermedios
        
        //Contenedor intermedio
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);
        panel.add(btnCRUD_Materiales);

        //Contenedor intermedio a la ventana
        getContentPane().add(panel);      

        //Establecer últimas propiedades del frame
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    } 



    public static void requerimiento3(){

        System.out.println("Materiales de Producción Nacional Más Comprados");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n",
                    materialNacional.getNombreMaterial(),
                    materialNacional.getImportado(),
                    materialNacional.getNoCompras()
                );                
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    } 
    
    public static void requerimiento4(){

        System.out.println("Proyectos Mayor Compra de Granito");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosGranito) {
                System.out.printf("%d %s %d %d %n",
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getAreaMaxima(),
                    proyecto.getNoComprasGranito()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("Cargos Menos Asignados");       

        try{

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            //Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");
            
            for (CargoAsignacion cargo : cargosMenosAsignados) {
                System.out.printf("%s %d %n",
                    cargo.getCargo(),
                    cargo.getNoProyectos()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    
}


