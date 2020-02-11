package model.logic;

import java.awt.List;

public class Comparendo implements Comparable<Comparendo>
{		
	/**
	 * 
	 */
	private String type;
	/**
	 * Informacion leida del json
	 */
	private Informacion properties;
	/**
	 * coordenadas leidas de Json
	 */
	private Ubicacion geometry;

/**
 * 
 * @param typ 
 * @param tipo tipo de comparendo 
 * @param latitud coordenada obtenida del Json
 * @param longitud coordenada obtenida del Json
 * @param ceros 
 * @param OBJECTID Informacion obtenida del Json 
 * @param FECHA_HORA Infomacion obtenida del Json. hora y fecha en que se registró el comparendo
 * @param MEDIO_DETE 
 * @param CLASE_VEHI
 * @param TIPO_SERVI
 * @param INFRACCION
 * @param DES_INFRACCION
 * @param LOCALIDAD
 */

	public Comparendo(String typ, String tipo, double latitud, double longitud, double ceros,
			int OBJECTID, String FECHA_HORA, String MEDIO_DETE, String CLASE_VEHI, String TIPO_SERVI, 
			String  INFRACCION, String DES_INFRACCION, String LOCALIDAD	)
	{
		properties = new Informacion(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, DES_INFRACCION, LOCALIDAD);
		geometry = new Ubicacion(tipo, latitud, longitud, ceros);
		type = typ;
		
	}
	/**
	 * Retorna la informacion del comparendo. No incluye coordenadas
	 * @return properties leidas
	 */
	public Informacion darDetalles()
	{
		return properties;
	}
	/**
	 * Retorna las coordenadas obtenida del Json
	 * @return coordenadas
	 */
	public Ubicacion darUbicacion()
	{
		return geometry;
	}
	public String toString()
	{
		String string = properties.toString() + "\n" ;
		String string2 = geometry.toString();
		return string + string2;
	}
	@Override
	public int compareTo(Comparendo o) {
		if(this.darDetalles().darInfraccion().equals(o.darDetalles().darInfraccion()))
		return 0;
		return 1;
	}

}
