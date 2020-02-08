package model.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import model.data_structures.ArregloDinamico;
import model.data_structures.Cola;
import model.data_structures.IArregloDinamico;
import model.data_structures.Pila;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private Cola<Comparendo> cola;
	private Pila<Comparendo> pila;

	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	/**
	 * Crea una nueva pila y una nueva lista
	 */
	public Modelo() {

		cola = new Cola<Comparendo>();
		pila = new Pila<Comparendo>();
		cargar();
		responderRequerimientos();

	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * 
	 * @param tamano
	 */
	public Modelo(int capacidad) {
		datos = new ArregloDinamico(capacidad);

	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano() {
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * 
	 * @param dato
	 */
	public void agregar(String dato) {
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * 
	 * @param dato
	 *            Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato) {
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * 
	 * @param dato
	 *            Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato) {
		return datos.eliminar(dato);
	}
	/**
	 * Lee el Json y crea el objeto de comparendos
	 */
	public void cargar() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("./data/comparendos_dei_2018_small.geojson"));
			JsonElement element = JsonParser.parseReader(bf);
			if (element.isJsonObject()) {
				JsonObject admin = element.getAsJsonObject();
				JsonArray listaComparendos = admin.getAsJsonArray("features");
				Gson gson = new Gson();
				for (int i = 0; i < listaComparendos.size(); i++) {
					JsonObject comparendo = listaComparendos.get(i).getAsJsonObject();
					agregarJsonObject(comparendo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Crea un comparendo a partir del JsonObject para agregarlo a la pila y cola
	 * @param jComparendo
	 */
	public void agregarJsonObject(JsonObject jComparendo) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Comparendo comparendo = gson.fromJson(jComparendo, Comparendo.class);
		agregarPilaCola(comparendo);
	}

	/**
	 * Agrega el comparendo que entra por parametro a la pila y a la cola
	 * @param comparendo
	 */
	public void agregarPilaCola(Comparendo comparendo) {

		pila.agregarElemento(comparendo);
		cola.agregarElemento(comparendo);
	}
	/**
	 * imprime los compparendos de cada estructura en la posicion dada
	 * @param i la posicion dada
	 */
	public void ImprimirenPosicion(int i) {
		Comparendo cPila;
		Comparendo cCola;
		try {
			cPila = pila.darElementoPosicion(i);
			cCola = cola.darElementoPosicion(i);
			System.out.println(cPila);
			System.out.println(cCola);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
	/**
	 * Permite al usuario escoger el proceso a realizar
	 * Si el usuario ingresa una opcion no listada se reinicia el programa
	 */
	public void responderRequerimientos()
	{

		try
		{
			System.out.println("Ingrese un numero del uno al tres:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String opcion = in.readLine();
			int op = Integer.parseInt(opcion);
			if(op == 1)
				responderRequerimiento1();
			else if(op == 2 )
				responderRequerimiento2();
			else if(op == 3)
			{
				try
				{
					System.out.println("Ingrese tipo de infraccion a buscar:");
					String infraccion = in.readLine();
					System.out.println("¿Cuantas infracciones desea buscar?");
					int n = Integer.parseInt(in.readLine());
					responderRequerimiento3(infraccion, n);
				}
				catch(Exception e)
				{
					System.out.println("Ocurrio un error, se reiniciara el programa");
					responderRequerimientos();
				}
			}
			else
				responderRequerimientos();
		}
		catch(Exception e)
		{
			responderRequerimientos();
		}
	}
	/**
	 * Metodo que responde al primer requerimiento, imprime la informacion del primer comparendo en cada estructura
	 */
	public void responderRequerimiento1()
	{
		System.out.println("Total comparendos leidos en pila:" + pila.darTamaño());
		System.out.println("Total comparendos leidos en cola:" + cola.darTamaño());
		System.out.println("Primer comparendo de pila y cola (respectivamente):");
		ImprimirenPosicion(0);
	}
	/**
	 * Busca el tipo de infraccion que aparece en mas comparendos consecutivos y los imprime
	 */
	public void responderRequerimiento2()
	{
		ArrayList<Comparendo> listaMax = new ArrayList<>();
		ArrayList<Comparendo> listaSegundo = new ArrayList<>();
		int maximo = 0;
		try
		{
			Comparendo actual = cola.eliminarElemento();
			String maxTipo = actual.darDetalles().darInfraccion();
			maximo = 1;
			int rachaMaximo = 1;
			int rachaSegundo = 0;
			String tipoSegundo = "";
			listaMax.add(actual);
			while(cola.darTamaño() > 0)
			{

				actual = cola.eliminarElemento();
				if(maxTipo.equals(actual.darDetalles().darInfraccion()) && rachaMaximo > 0)
				{
					rachaMaximo++;
					if(rachaMaximo >= maximo)
					{
						maximo = rachaMaximo;
						listaMax.add(actual);
					}

				}
				else
				{ 
					rachaMaximo = 0;
					if(rachaSegundo < 1)
					{
						tipoSegundo = actual.darDetalles().darInfraccion();
						listaSegundo.removeAll(listaMax);
						rachaSegundo = 0;
					}

					if(tipoSegundo.equals(actual.darDetalles().darInfraccion()))
					{
						rachaSegundo++;
						listaSegundo.add(actual);
						if(rachaSegundo >= maximo)
						{
							rachaMaximo = rachaSegundo;
							maximo = rachaSegundo;
							rachaSegundo = 0;
							maxTipo = tipoSegundo;
							tipoSegundo = "";
							listaMax.removeAll(listaMax);
							listaMax.addAll(listaSegundo);
							listaSegundo.removeAll(listaSegundo);
						}
					}
					else
					{
						listaSegundo.removeAll(listaSegundo);
						tipoSegundo = actual.darDetalles().darInfraccion();
						rachaSegundo = 1;
						listaSegundo.add(actual);
					}
				}
			}
			System.out.println("Tipo Maximo: "  + maxTipo);
			System.out.println("Cantidad: " + maximo);
			for (Comparendo comparendo : listaMax)
			{
				System.out.println(comparendo);
				System.out.println();
			}


		}
		catch (Exception e) {

			System.out.println(e.getMessage()); 
		}
	}
	/**
	 * Busca los primeros n registros que tienen el tipo de infraccion solicitado
	 * En caso de que la cantidad de registros encontrados sea menor que los solicitados imprime los que encuentre
	 * @param infraccion el tipo de infraccion buscado
	 * @param n la cantidad de registros solicitados
	 */
	public void responderRequerimiento3(String infraccion, int n)
	{
		try
		{
			int encontrados = 0;
			ArrayList<Comparendo> lista = new ArrayList<>();
			while(n>0 && pila.darTamaño() > 0)
			{
				Comparendo actual = pila.eliminarElemento();
				if(actual.darDetalles().darInfraccion().equals(infraccion))
				{
					encontrados++;
					n--;
					lista.add(actual);
				}
			}
			System.out.println("Se encontraron " + encontrados + " registros");
			System.out.println();
			for (Comparendo comparendo : lista) 
			{
				System.out.println(comparendo);
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}
