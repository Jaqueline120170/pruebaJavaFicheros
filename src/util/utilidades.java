package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import controladores.Inicio;
import dtos.ProductoDto;

public class utilidades {

public static long calcularIdProducto() {
		
		long nuevoId = 0;
		int tamanio = Inicio.listaProductos.size();

		if(tamanio > 0) {
			
			nuevoId = Inicio.listaProductos.get(tamanio-1).getIdProducto()+1;
			
		}else {
			
			nuevoId = 0;
			
		}
		
		return nuevoId;
		
	}

public static long calcularIdVenta() {
	
	long nuevoId = 0;
	int tamanio = Inicio.listaVentas.size();

	if(tamanio > 0) {
		
		nuevoId = Inicio.listaVentas.get(tamanio-1).getIdVenta()+1;
		
	}else {
		
		nuevoId = 0;
		
	}
	
	return nuevoId;
	
}

public static LocalDate SolicitarFecha() {

	LocalDate fechaDate = null;
	boolean esValido = false;
	do {
		try {
			System.out.println("Ingrese fecha (dd-mm-yyyy):");
			String fecha = Inicio.sc.nextLine();

			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			fechaDate = LocalDate.parse(fecha, formato);
			esValido = true;
		} catch (DateTimeParseException e) {
			System.out.println("Formato de fecha inválido. Intente de nuevo.");
		}
	} while (!esValido);
	return fechaDate;
}
}
