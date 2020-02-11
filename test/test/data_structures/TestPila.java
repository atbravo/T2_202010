 package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Cola;
import model.data_structures.Pila;

public class TestPila {
	
	private Pila<String> pila; 
	public static int PRUEBAT=150;
	
	@Before
	public void setUp1() {
		pila= new Pila<String>(); 
	}
	public void setUp2() {
		for(int i =0; i< PRUEBAT;i++){
			pila.agregarElemento(""+i);
		}
	}

	/**
	 * agrega un elemento al final de la pila
	 */
	@Test
	public void agregarElemento( ) {
		pila.agregarElemento("Prueba");
		assertNotNull("No agregó correctamente", pila.darUltimo());
		pila.agregarElemento("Prueba2.0");
		assertEquals("No agregó correctamente", "Prueba 2.0", pila.darUltimo());
	}
	
	/**
	 * elimina el ultimo elemento de la pila
	 * @return el elemento eliminado
	 * @throws Exception 
	 */
	@Test
	public void eliminarElemento() throws Exception{
		setUp2();
		assertEquals("No eliminó correctamente", "150",pila.eliminarElemento());
		assertEquals("No actualiza el tamaño cuando se elimina", PRUEBAT-1, pila.darTamano());
		assertEquals("No eliminó correctamente", "149",pila.eliminarElemento());
		assertEquals("No actualiza el tamaño cuando se elimina", PRUEBAT-2, pila.darTamano());
	};

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 * @throws Exception 
	 */
	@Test
	public void darElementoPosicion(int pos) throws Exception{
		setUp2();
		assertEquals("El elemento en esa posición no es el correcto", "6", pila.darElementoPosicion(6));
		assertEquals("El elemento en esa posición no es el correcto", "15", pila.darElementoPosicion(15));
		assertEquals("El elemento en esa posición no es el correcto", "50", pila.darElementoPosicion(50));
		assertEquals("El elemento en esa posición no es el correcto", "199", pila.darElementoPosicion(199));
		assertEquals("El elemento en esa posición no es el correcto", "150", pila.darElementoPosicion(150));
	}
	
	/**
	 * retorna el total de elementos en la pila
	 * @return cantidad de elementos en pila
	 */
	@Test
	public void darTamaño() {
	setUp2();
	assertEquals("El tamano no es correcto", PRUEBAT, pila.darTamano());
	}
}