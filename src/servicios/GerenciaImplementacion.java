package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controladores.Inicio;
import dtos.ProductoDto;
import dtos.VentaDto;

public class GerenciaImplementacion implements GerenciaInterfaz {

	@Override
	public void crearPedido()throws IOException  {
		List<ProductoDto> pedido = new ArrayList<ProductoDto>();
		String controlador = "";
		
		do {
			
			System.out.println("Nombre producto: ");
			String nombre = Inicio.sc.next();
			System.out.println("Cantidad producto: ");
			int cantidad = Inicio.sc.nextInt();
			System.out.println("Fecha entrega (dd-MM-yyyy): ");
			String fecha = Inicio.sc.next();
			
			ProductoDto producto = new ProductoDto(nombre,cantidad,fecha,pedido);
			pedido.add(producto);
			System.out.println("Otro producto (si/no): ");
			controlador = Inicio.sc.next();
			
		}while(controlador.equals("si"));
		
		for(ProductoDto producto : pedido) {
			System.out.println(producto.toString());
		}
	}
	
	@Override
	public void mostrarVentasDia() throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate fechaFormateada = util.utilidades.SolicitarFecha();

		for (VentaDto v : Inicio.listaVentas) {

			if (v.getFechaVenta().equals(fechaFormateada)) {

				System.out.print("Venta numero:" + v.getIdVenta() + "\n"+
							 	 "Euros:" + v.getImporteVenta() + " euros\n"
							   + "Instante compra: " + v.getFechaVenta().format(formatter)+"\n");
			}

		}

	}
}
