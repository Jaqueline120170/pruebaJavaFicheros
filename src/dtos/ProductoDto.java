package dtos;

import java.util.List;

import controladores.Inicio;
import util.utilidades;

public class ProductoDto {
	
	long idProducto;
	String nombreProdcuto;
	int cantidadProducto;
	String fechaDeseadaProducto= "31-12-1999";
	
	
	
	public ProductoDto(String nombreProdcuto, int cantidadProducto, String fechaDeseadaProducto, List<ProductoDto>listaProductos) {
		super();
		this.nombreProdcuto = nombreProdcuto;
		this.cantidadProducto = cantidadProducto;
		this.fechaDeseadaProducto = fechaDeseadaProducto;
		this.idProducto = utilidades.calcularIdProducto();
	}


	public ProductoDto() {
		super();
	}
	
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProdcuto() {
		return nombreProdcuto;
	}
	public void setNombreProdcuto(String nombreProdcuto) {
		this.nombreProdcuto = nombreProdcuto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public String getFechaDeseadaProducto() {
		return fechaDeseadaProducto;
	}
	public void setFechaDeseadaProducto(String fechaDeseadaProducto) {
		this.fechaDeseadaProducto = fechaDeseadaProducto;
	}
	
	@Override
	public String toString() {
		
		String texto = "Producto: " + this.nombreProdcuto + "\n";
		
		return texto;
	}	
	
}
