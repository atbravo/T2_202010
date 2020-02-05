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
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaComparendos;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	private ListaComparendos comparendos;

	public Modelo()
	{
		comparendos = new ListaComparendos();
		cargar();
		responderRequerimiento1();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);

	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}

	public void cargar() 
	{
		try
		{
			BufferedReader bf = new BufferedReader(new FileReader(new File("./data/comparendos_dei_2018.geojson")));
			JsonElement element = JsonParser.parseReader(bf);
			if (element.isJsonObject()) 
			{
				JsonObject admin = element.getAsJsonObject();
				JsonArray listaComparendos = admin.getAsJsonArray("features");
				Gson gson = new Gson();
				for (int i = 0; i < listaComparendos.size(); i++) 
				{
					JsonObject comparendo = listaComparendos.get(i).getAsJsonObject();
					comparendos.agregarJsonObject(comparendo);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void responderRequerimiento1()
	{
		System.out.println("Total Comparendos: " + comparendos.darTamaño());
		System.out.println("Informacion comparendo 1:\n");
		comparendos.imprimirComparendoenPosicion(0);
		System.out.println("Informacion ultimo comparendo:\n");
		comparendos.imprimirComparendoenPosicion(comparendos.darTamaño()-1);
	}
}

