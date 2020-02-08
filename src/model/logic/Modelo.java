package model.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;

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
		responderRequerimiento1();

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

	public void cargar() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("./data/comparendos_dei_2018.geojson"));
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

	public void responderRequerimiento1()
	{
		System.out.println("Total comparendos leidos en pila:" + pila.darTamaño());
		System.out.println("Total comparendos leidos en cola:" + cola.darTamaño());
		System.out.println("Primer comparendo de pila y cola (respectivamente):");
		ImprimirenPosicion(0);
	}
}
