package view;

import java.util.ArrayList;

import model.data_structures.ArregloDinamico;
import model.data_structures.Pila;
import model.logic.Comparendo;
import model.logic.Modelo;

public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Cargar comprendos a pila y cola");
		System.out.println("2. Consultar grupo de comparendos consecutivos por infracción");
		System.out.println("3. Consultar los ultimos N comparendos dada su infracción");
		System.out.println("4. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		

	public void printModelo(Modelo modelo)
	{
		// TODO implementar
	}

	/**
	 * Responde el requierimiento 1 para cada una de las estructuras
	 * @param tamPila tamaño pila
	 * @param tamCola tamaño cola
	 */
	public void responderReq1(int tamPila, int tamCola, Comparendo cola1, Comparendo pila1 )
	{
		System.out.println("El tamaño de la pila es: "+ tamPila);
		System.out.println("El tamaño de la cola es: "+ tamCola);
		System.out.println("El primer comparendo de la cola es: "+cola1);
		System.out.println("----------------------------------------");
		System.out.println("El primer comparendo de la pila es: "+pila1);
		System.out.println("----------------------------------------");
	}
	public void responderReq2(Pila<Comparendo> listaMax) {
		System.out.println("La cantidad de infracciones consecutivas es"+ listaMax.darTamano());
		while(listaMax.darTamano()>0){
			try {
				System.out.println("Comparendo:"+ listaMax.eliminarElemento());
				System.out.println("----------------------------------------");
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void responderReq3(ArregloDinamico<Comparendo> listaMax) {
		System.out.println("El número de comparendos encontrados son: "+ listaMax.darTamano());
		for(int i=0; i<listaMax.darTamano();i++)
		{
			System.out.println("Comparendo: "+ listaMax.darElemento(i));
			System.out.println("----------------------------------------");
		}
		
	}

}