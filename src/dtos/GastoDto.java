package dtos;

import java.time.LocalDate;

public class GastoDto {
	
	long id;
	double importeGasto= 0.0;
	LocalDate fechaImporte = LocalDate.of(1999, 12, 31);
	
	
	
	public GastoDto() {
		super();
	}
	public GastoDto(long id, double importeGasto, LocalDate fechaImporte) {
		super();
		this.id = id;
		this.importeGasto = importeGasto;
		this.fechaImporte = fechaImporte;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getImporteGasto() {
		return importeGasto;
	}
	public void setImporteGasto(double importeGasto) {
		this.importeGasto = importeGasto;
	}
	public LocalDate getFechaImporte() {
		return fechaImporte;
	}
	public void setFechaImporte(LocalDate fechaImporte) {
		this.fechaImporte = fechaImporte;
	}
	@Override
	public String toString() {
		return "GastoDto [id=" + id + ", importeGasto=" + importeGasto + ", fechaImporte=" + fechaImporte + "]";
	}
	
	
}
