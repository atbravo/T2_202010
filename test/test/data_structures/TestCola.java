package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Cola;

public class TestCola {

	private Cola<String> cola;
	private static int TAMANOPRUEBA=200;
	
	@Before
	public void setUp1() {
		cola= new Cola<String>(); 
	}
	public void setUp2() {
		for(int i =0; i< TAMANOPRUEBA;i++){
			cola.agregarElemento(""+i);
		}
	}
	
	/**
	 * agrega un elemento al final de la cola
	 */
	@Test
	public void TestAgregarElemento() {
		
		cola.agregarElemento("Prueba");
		assertNotNull("No agregó correctamente", cola.darPrimero());
	}
	
	/**
	 * elimina el primer elemento de la cola
	 * @return el elemento eliminado
	 * @throws Exception 
	 */
	@Test
	public void TestEliminarElemento() throws Exception{
		setUp2();
		assertEquals("No eliminó correctamente", "0",cola.eliminarElemento());
		assertEquals("No actualiza el tamaño cuando se elimina", TAMANOPRUEBA-1, cola.darTamaño());
		assertEquals("No eliminó correctamente", "1",cola.eliminarElemento());
		assertEquals("No actualiza el tamaño cuando se elimina", TAMANOPRUEBA-2, cola.darTamaño());
	}

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 * @throws Exception 
	 */
	@Test
	public void TestDarElementoPosicion() throws Exception{
		setUp2();
		assertEquals("El elemento en esa posición no es el correcto", "6", cola.darElementoPosicion(6));
		assertEquals("El elemento en esa posición no es el correcto", "15", cola.darElementoPosicion(15));
		assertEquals("El elemento en esa posición no es el correcto", "50", cola.darElementoPosicion(50));
		assertEquals("El elemento en esa posición no es el correcto", "199", cola.darElementoPosicion(199));
		assertEquals("El elemento en esa posición no es el correcto", "150", cola.darElementoPosicion(150));
	}
	
	/**
	 * retorna el total de elementos en la cola
	 * @return cantidad de elementos en cola 
	 */
	@Test
	public void TestDarTamaño() {
		setUp2();
		assertEquals("El tamano no es correcto", TAMANOPRUEBA, cola.darTamaño());
	}

	
}