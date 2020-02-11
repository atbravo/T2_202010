package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
		try{
		run();
		}
		catch (Exception e) {
		e.getMessage();
		}
	}
		
	public void run() throws Exception 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		//String dato = "";
		//String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					modelo.cargar();
					view.printMessage("Datos cargados");
					view.responderReq1(modelo.darTamanoPila(), modelo.darTamanoPila(), modelo.imprimirenPosCola(0), modelo.ImprimirenPosPila(0));
					break;
				case 2:
					view.responderReq2(modelo.responderRequerimiento2());
					break;
				case 3:
					view.printMessage("Digite  la infracción que desea buscar");
					String infraccion= lector.next();
					view.printMessage("Digite el númmero de comparendos" );
					int n= lector.nextInt();
					view.responderReq3(
							modelo.responderRequerimiento3(infraccion, n));
					break;
				case 4:
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}