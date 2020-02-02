package model.data_structures;

public class Informacion
{
	private int objectId;
	private String fechaHora;
	private String medioDete;
	private String claseVehi;
	private String tipoServi;
	private String infraccion;
	private String desInfraccion;
	private String localidad;

	
	public Informacion(int OBJECTID, String FECHA_HORA, String MEDIO_DETE, String CLASE_VEHI, String TIPO_SERVI, 
						String  INFRACCION, String DES_INFRACCION, String LOCALIDAD)
	{
		objectId = OBJECTID;
		fechaHora = FECHA_HORA;
		medioDete = MEDIO_DETE;
		claseVehi = CLASE_VEHI;
		tipoServi = TIPO_SERVI;
		infraccion = INFRACCION;
		desInfraccion = DES_INFRACCION;
		localidad = LOCALIDAD;
	}
	public int darID()
	{
		return objectId;
	}
	public String darfecha()
	{
		return fechaHora;
	}
	public String darTipoDetencion()
	{
		return medioDete;
	}
	public String darclaseVehiculo()
	{
		return claseVehi;
	}
	public String darTipoServicio()
	{
		return tipoServi;
	}
	public String darInfraccion()
	{
		return infraccion;
	}
	public String darLocalidad()
	{
		return localidad;
	}
	public String toString()
	{
		return "Id: " + objectId + "\n" + "Fecha:" + fechaHora + "\n" + "Detencion: " + medioDete
				+ "\n" + "Vehiculo: " + claseVehi + "\n" + "Servicio: " + tipoServi + "\n" +
				"Infraccion: " + infraccion + "\n" + "Localidad:" + localidad;
	}
		

}
