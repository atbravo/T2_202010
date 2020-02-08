package model.logic;

public class Ubicacion 
{
	private String type;
	private double[] coordinates;
	
	public Ubicacion(String tipo, double latitud, double longitud, double ceros)
	{
		type = tipo;
		coordinates = new double[3];
		coordinates[0] = latitud;
		coordinates[1] = longitud;
		coordinates[2] = ceros;
		
	}
	/**
	 * Da las coordenadas de latitud 
	 * @return coordenadas en la posicion 0 
	 */
	public double darLatitud()
	{
		return coordinates[0];
	}
	/**
	 * Da la longitud de las coordenadas del comparendo 		
	 * @return coordenadas en la posicion 1 
	 */
	public double darLongitud()
	{
		return coordinates[1];
	}

	public String toString()
	{
		return "Latitud: " + darLatitud() + "\n" + "Longitud:" + darLongitud();
	}
}
