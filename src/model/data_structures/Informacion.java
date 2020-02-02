package model.data_structures;

public class Informacion
{
	private int objectID;
	private String fechaHora;
	private String tipoDetencion;
	private String claseVehiculo;
	private String tipoServicio;
	private String infraccion;
	private String descpicion;
	private String localidad;

	
	public Informacion(int OBJECTID, String FECHA_HORA, String MEDIO_DETE, String CLASE_VEHI, String TIPO_SERVI, 
						String  INFRACCION, String DES_INFRACCION, String LOCALIDAD)
	{
		objectID = objectID;
		fechaHora = FECHA_HORA;
		tipoDetencion = TIPO_SERVI;
		claseVehiculo = CLASE_VEHI;
		tipoServicio = TIPO_SERVI;
		infraccion = INFRACCION;
		descpicion = DES_INFRACCION;
		localidad = LOCALIDAD;
	}
		

}
