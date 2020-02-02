package model.data_structures;

public class Ubicacion 
{
	private String type;
	private double[] coordenadas;
	
	public Ubicacion(String tipo, double latitud, double longitud, double ceros)
	{
		type = tipo;
		coordenadas = new double[3];
		coordenadas[0] = latitud;
		coordenadas[1] = longitud;
		coordenadas[2] = ceros;
		
	}
}
