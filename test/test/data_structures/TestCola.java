package test.data_structures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;

import model.data_structures.Cola;

public class TestCola {

	private Cola<Comparable> cola;
	private static int TAMANOPRUEBA=200;
	
	@Before
	public void setUp1() {
		cola= new Cola(); 
	}
	public void setUp2() {
		for(int i =0; i< TAMANOPRUEBA;i++){
			cola.agregarElemento(""+i);
		}
	}
	/**
	 * agrega un elemento al final de la cola
	 */
	public void TestAgregarElemento() {
		
		cola.agregarElemento("Prueba");
		assertNotNull("No agreg� correctamente", cola.darPrimero());
	}
	
	/**
	 * elimina el primer elemento de la cola
	 * @return el elemento eliminado
	 * @throws Exception 
	 */
	public void TestEliminarElemento() throws Exception{
		setUp2();
		assertEquals("No elimin� correctamente", "0",cola.eliminarElemento());
		assertEquals("No actualiza el tama�o cuando se elimina", TAMANOPRUEBA-1, cola.darTama�o());
		assertEquals("No elimin� correctamente", "1",cola.eliminarElemento());
		assertEquals("No actualiza el tama�o cuando se elimina", TAMANOPRUEBA-2, cola.darTama�o());
	}

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 * @throws Exception 
	 */
	public void TestDarElementoPosicion(int pos) throws Exception{
		setUp2();
		assertEquals("El elemento en esa posici�n no es el correcto", "6", cola.darElementoPosicion(6));
		assertEquals("El elemento en esa posici�n no es el correcto", "15", cola.darElementoPosicion(15));
		assertEquals("El elemento en esa posici�n no es el correcto", "50", cola.darElementoPosicion(50));
		assertEquals("El elemento en esa posici�n no es el correcto", "200", cola.darElementoPosicion(200));
		assertEquals("El elemento en esa posici�n no es el correcto", "150", cola.darElementoPosicion(150));
	}
	
	/**
	 * retorna el total de elementos en la cola
	 * @return cantidad de elementos en cola 
	 */
	public void TestDarTama�o() {
		setUp2();
		assertEquals("El tamano no es correcto", TAMANOPRUEBA, cola.darTama�o());
	}

	
}
