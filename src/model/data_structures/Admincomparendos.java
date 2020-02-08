package model.data_structures;

import java.lang.reflect.Field;
import java.util.LinkedList;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

import model.logic.Comparendo;

public class Admincomparendos {
	public Admincomparendos() {

	}

	public void agregarJsonObject(JsonObject jComparendo)
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Comparendo comparendo = gson.fromJson(jComparendo, Comparendo.class);
		agregarPilaCola(comparendo);
	}
	public void agregarPilaCola(Comparendo comparendo)
	{
		
	}

}
