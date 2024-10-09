package controladores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.GastoDto;
import dtos.ProductoDto;
import dtos.VentaDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import util.utilidades;
import servicios.EmpleadoImplementacion;
import servicios.EmpleadoInterfaz;
import servicios.GerenciaImplementacion;
import servicios.GerenciaInterfaz;

public class Inicio {
	
	//Listas estaticas para poder llamarlas desde cualquier aprte del codigocuando se necesiten
	//como referencia para otras funcionalidades.
	public static Scanner sc = new Scanner (System.in);
	public static List<GastoDto> listaGastos = new ArrayList<GastoDto>();
	public static List<ProductoDto> listaProductos = new ArrayList<ProductoDto>();
	public static List<VentaDto> listaVentas = new ArrayList<VentaDto>();
	static LocalDateTime fechaActual = LocalDateTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static String fechaYhora = fechaActual.format(formatter);
	
	//Método principal de acceso a la aplicacion
	public static void main(String[] args) {
		
		//Contructores de clases e interfaces, nuevas instancias
		MenuInterfaz mi = new MenuImplementacion();
		EmpleadoInterfaz ei = new EmpleadoImplementacion();
		
		//creacion de ficheros
		util.GestorFicheros.creaFichero();
		String rutaArchivo ="C:\\Users\\Usuario\\eclipse-workspace\\ejercicio2ExamenJava\\ficheroGeneral.txt";
		
		//Métodos estaticos que muestran el estado actual d elos ficheros al momento de abrir app y contenido
		util.GestorFicheros.accesoAFicheros(rutaArchivo);
		
		try {
		
		int opcionUsuario;
		boolean cerrarMenu=false;
		
		while(!cerrarMenu) {
			
				opcionUsuario=mi.mostrarMenuYSeleccion();
				switch(opcionUsuario) {
				case 0:
					util.GestorFicheros.sobreEscribir(fechaYhora +  "0  Acceso a menu principal");
					
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
			            for (VentaDto venta1 : listaVentas) {
			                if (venta1.getIdVenta() != 0) {
			                    bw.write(venta1.getIdVenta() + ";" + venta1.getImporteVenta()
			                            + ";" + venta1.getFechaVenta());
			                    bw.newLine();
			                }
			            }
					}catch (Exception e) {
                        System.out.println("Error al escribir en el archivo: " + e.getMessage());
                    }
					
					cerrarMenu=true;
					break;
				case 1:
					util.GestorFicheros.sobreEscribir(fechaYhora +  "1  Acceso a menu empleados");
					mi.seleccionMenuEmpleado();
					break;
				case 2:
					util.GestorFicheros.sobreEscribir(fechaYhora +  "2  Acceso a menu Gerencia");
					break;
				default:
					util.GestorFicheros.sobreEscribir(fechaYhora +  " Opcion invalida");
					System.out.println("Introduzca una opcion valida");
					break;
				}
				
			}
		}catch(Exception e) {
			String mensajeError = "Error general en la aplicación: " + e.getMessage();
			util.GestorFicheros.sobreEscribir(fechaYhora + " " + mensajeError);
			 System.out.println("Error al escribir en el archivo: " + e.getMessage());
      	 }

	}

}
