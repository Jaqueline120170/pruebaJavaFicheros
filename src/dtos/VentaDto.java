package dtos;

import java.time.LocalDateTime;

public class VentaDto {
	
	long idVenta;
	double importeVenta;
	LocalDateTime fechaVenta = LocalDateTime.now();
	
	
	public VentaDto() {
		super();
	}
	public VentaDto(long idVenta, double importeVenta, LocalDateTime fechaVenta) {
		super();
		this.idVenta = idVenta;
		this.importeVenta = importeVenta;
		this.fechaVenta = fechaVenta;
	}
	public long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	public double getImporteVenta() {
		return importeVenta;
	}
	public void setImporteVenta(double importeVenta) {
		this.importeVenta = importeVenta;
	}
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	@Override
	public String toString() {
		return "VentaDto [idVenta=" + idVenta + ", importeVenta=" + importeVenta + ", fechaVenta=" + fechaVenta + "]";
	}
	
	
}
