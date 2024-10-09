package servicios;

import java.io.IOException;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {
	EmpleadoInterfaz ei = new EmpleadoImplementacion();
		
	public int mostrarMenuYSeleccion() {
		
		int seleccionUsuario;
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Acceder como Empleado");
		System.out.println("2. Acceder como gerente");
		System.out.println("Sleccione una opcion");
		seleccionUsuario=Inicio.sc.nextInt();
		return seleccionUsuario;
	}
	
	private int mostrarMenuEmpleado() {
		
		int seleccionEmpleado;
		System.out.println("0. Volver al inicio");
		System.out.println("1. Aniadir una venta");
		System.out.println("2. Calcular total de ventas");
		System.out.println("Seleccione una opcion");
		seleccionEmpleado=Inicio.sc.nextInt();
		return seleccionEmpleado;
	}
	
	public void seleccionMenuEmpleado() throws IOException
	{
		
		int opcionEmpleado;
		boolean cerrarMenuEmpleado=false;
		
		while(!cerrarMenuEmpleado) {
			
			opcionEmpleado = mostrarMenuEmpleado();
			switch(opcionEmpleado) {
			case 0:
				util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "0  Acceso a menu principal de empleados");
				cerrarMenuEmpleado=true;
				break;
			case 1:
				util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "1  Añadir una venta");
				ei.aniadirVenta();
				break;
			case 2:
				util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "2  Calculo total de ventas diarias");
				ei.ventaTotalDiaria();
				break;
			default:
				util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " Seleccione una opcion valida");
				break;
			}
		}
	}
	
	private int mostrarMenuGerencia() {
		
		int seleccionGerencia;
		System.out.println("0. Volver al menu inicial");
		System.out.println("1. Mostrar ventas del dia");
		System.out.println("2. Crear nuevo pedido");
		System.out.println("Seleccione una opcion");
		seleccionGerencia=Inicio.sc.nextInt();
		return seleccionGerencia;
	}
	
	
	public void seleccionMenuGerencia() {
		
		int opcionGerencia;
		boolean cerrarMenuGerencia=false;
		
		while(!cerrarMenuGerencia) {
			opcionGerencia=mostrarMenuGerencia();
			switch(opcionGerencia) {
			case 0:
				cerrarMenuGerencia=true;
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}
	
}
