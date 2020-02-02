package model.data_structures;

import java.lang.reflect.Field;
import java.util.LinkedList;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class ListaComparendos extends Lista<Comparendo> {
	public ListaComparendos() {

	}

	public void agregarJsonObject(JsonObject jComparendo) {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingStrategy(new FieldNamingStrategy() {

			public String translateName(Field f) {
				return limpiar(f.getName());
			}
		});
		Gson gson = builder.create();
		Comparendo comparendo = gson.fromJson(jComparendo, Comparendo.class);
		agregarElemento(comparendo);
	}

	public void imprimirComparendoenPosicion(int i) {
		System.out.println(darElementoPosicion(i));
	}

	public String limpiar(String cadena) {
		String[] caja = cadena.split("_");
		String respuesta = caja[0].toLowerCase();
		for(int i = 1; i < caja.length; i++)
		{
			respuesta = respuesta + (caja[i].charAt(0)) + (caja[i].substring(1).toLowerCase());
			
		}
		return respuesta;
		
	}
}
