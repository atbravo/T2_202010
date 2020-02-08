package model.logic;

public class Informacion
{
	/**
	 * ID del comparendo
	 */
	private int OBJECTID;
	/**
	 * Fecha y hora registradas del comparendo
	 */
	private String FECHA_HORA; 
	/**
	 * Tipo de detencion
	 */
	private String MEDIO_DETE;
	/**
	 * Vehículo registrado
	 */
	private String CLASE_VEHI;
	/**
	 * Tipo de servicio 
	 */
	private String TIPO_SERVI;
	/**
	 * Infraccion registrada
	 */
	private String INFRACCION;
	/**
	 * Descripcion de la infraccion
	 */
	private String DES_INFRACCION;
	/**
	 * Lugar, localidad del registro del comparendo 
	 */
	private String LOCALIDAD;

	/**
	 * @param ID objectif del comparendo
	 * @param fecha fecha y hora del comparendo
	 * @param detencion tipo de detencion
	 * @param claseVehiculo tipo de vehículo registrado 
	 * @param servicio tipo de servicio del comparendo 
	 * @param infrac infraccion registrada
	 * @param descInfraccion da la descripcion de la infraccion 
	 * @param localidad lugar, localidad del registro del comparendo
	 */
	public Informacion(int ID, String fecha, String detencion, String claseVehiculo, String servicio, 
						String  infrac, String descInfraccion, String localidad)
	{
		OBJECTID = ID;
		FECHA_HORA = fecha;
		MEDIO_DETE = detencion;
		CLASE_VEHI = claseVehiculo;
		TIPO_SERVI = servicio;
		INFRACCION = infrac;
		DES_INFRACCION = descInfraccion;
		LOCALIDAD = localidad;
	}
	/**
	 * Retorna el ID del comparendo
	 * @return OBJECTID
	 */
	public int darID()
	{
		return OBJECTID;
	}
	/**
	 * Retorna la fecha del comparendo
	 * @return FECHA_HORA
	 */
	public String darfecha()
	{
		return FECHA_HORA;
	}
	/**
	 * Retorna el tipo de detencion del comparendo
	 * @return MEDIO_DETE
	 */
	public String darTipoDetencion()
	{
		return MEDIO_DETE;
	}
	/**
	 * la clase de vehículo del comparendo
	 * @return CLASE_VEHI
	 */
	public String darclaseVehiculo()
	{
		return CLASE_VEHI;
	}
	/**
	 * retorna el tipo de servicio 
	 * @return TIPO_SERVI
	 */
	public String darTipoServicio()
	{
		return TIPO_SERVI;
	}
	/**
	 * retorna la Infraccion registrada
	 * @return INFRACCION
	 */
	public String darInfraccion()
	{
		return INFRACCION;
	}
	/**
	 * Retorna el la localidad en la que se registró la infraccion 
	 * @return LOCALIDAD
	 */
	public String darLocalidad()
	{
		return LOCALIDAD;
	}
	public String toString()
	{
		return "Id: " + darID() + "\n" + "Fecha:" + darfecha() + "\n" + "Detencion: " + MEDIO_DETE
				+ "\n" + "Vehiculo: " + CLASE_VEHI + "\n" + "Servicio: " + TIPO_SERVI + "\n" +
				"Infraccion: " + INFRACCION + "\n" + "Localidad:" + LOCALIDAD;
	}
		

}
