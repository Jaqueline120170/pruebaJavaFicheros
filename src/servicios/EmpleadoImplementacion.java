package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controladores.Inicio;
import dtos.VentaDto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {
	
	@Override
	public void aniadirVenta() throws IOException
	{
		
		VentaDto crearVenta = new VentaDto();
		long idVenta= util.utilidades.calcularIdVenta();
		System.out.println("Agrege el importe de la venta");
		double importeVenta=Inicio.sc.nextDouble();	
		crearVenta.setImporteVenta(importeVenta);
		crearVenta.setIdVenta(idVenta);
		Inicio.listaVentas.add(crearVenta);
		System.out.println("Venta ingresada");
	}
	
public void ventaTotalDiaria() throws IOException{
		
		LocalDate fechaFormateada = util.utilidades.SolicitarFecha();
		double importeTotal = 0.0;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		List<LocalDateTime> fechasVentas = new ArrayList<LocalDateTime>();
		
		for (VentaDto venta : Inicio.listaVentas) {
			 
				if (venta.getFechaVenta().format(formato).equals(fechaFormateada)) {
					
					importeTotal = importeTotal + venta.getImporteVenta();
					fechasVentas.add(venta.getFechaVenta());
					
				}
		}
		 LocalDate primeraFechaCompra = Inicio.VentaLista.get(0).getFechaDate();
		    LocalDate ultimaFechaCompra = Inicio.VentaLista.get(Inicio.VentaLista.size() - 1).getFechaDate();
		    
		    long diferenciaDias = ChronoUnit.DAYS.between(primeraFechaCompra, ultimaFechaCompra);
		    
		    // Mostrar resultados
		    System.out.println("Diferencia entre la primera y la última compra: " + diferenciaDias + " días");
		    System.out.println("Total del día: " + banca + "euros");
		    System.out.println("Fecha: " + fechaFormateada);

}
}
