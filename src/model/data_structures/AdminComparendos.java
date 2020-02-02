package model.data_structures;

import java.util.ArrayList;

public class AdminComparendos
{
	private String type;
	private String nombre;
	private Crs crs;
	private Lista comparendos;
	
	public AdminComparendos(String typ, String name, String typ2, String properties, String name2)
	{
		type = typ;
		nombre = name;
		crs = new Crs(typ2, properties, name2);
	}

}
