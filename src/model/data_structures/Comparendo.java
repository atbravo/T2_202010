package model.data_structures;

public class Comparendo
{
	private Ubicacion ubicacion;
	private Informacion informacion;
	private String type;

	public Comparendo(String typ, String tipo, double latitud, double longitud, double ceros,
			int OBJECTID, String FECHA_HORA, String MEDIO_DETE, String CLASE_VEHI, String TIPO_SERVI, 
			String  INFRACCION, String DES_INFRACCION, String LOCALIDAD	)
	{
		informacion = new Informacion(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, DES_INFRACCION, LOCALIDAD);
		ubicacion = new Ubicacion(tipo, latitud, longitud, ceros);
		type = typ;
	}

}
