package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.VentaDto;

public class GestorFicheros {
	
	public static String nombreFichero() 
	 {
	        LocalDate fechaActual = LocalDate.now();
	        String diasFecha = DateTimeFormatter.ofPattern("dd").format(fechaActual);
	        String mesFecha = DateTimeFormatter.ofPattern("MM").format(fechaActual);
	        String anioFecha = DateTimeFormatter.ofPattern("yy").format(fechaActual);
	        String fechaCompleta = diasFecha + mesFecha + anioFecha;
	        String rutaArchivo = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicio2ExamenJava\\log" + fechaCompleta + ".txt";
	        return rutaArchivo;
	    }

	public static void creaFichero()
    {
        try {
            FileWriter fw = new FileWriter(nombreFichero());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void sobreEscribir(String accion)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero(), true)))
        {
            writer.write(accion + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void accesoAFicheros(String rutaFicheroGeneral)
	{
        File archivo = new File(rutaFicheroGeneral);
        if (archivo.exists()) 
        {
            try {
                String[] contenidoFichero = Files.readAllLines(Paths.get(rutaFicheroGeneral)).toArray(new String[0]);

                for (String fichero : contenidoFichero) 
                {
                    String[] lineasContenido = fichero.split(";");
                    VentaDto venta = new VentaDto(Long.parseLong(lineasContenido[0]),Double.parseDouble(lineasContenido[1]),LocalDateTime.parse(lineasContenido[2]));
                    Inicio.listaVentas.add(venta);
                }

                System.out.println("Lista de ventas");
                for (String line : contenidoFichero)
                {
                    System.out.println(line);
                }
            } catch (IOException e) 
            {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else 
        {
            System.out.println("No existen ventas");
        }
}
}
