package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;

import model.data_structures.Cola;
import model.data_structures.Pila;

public class TestPila {
	
	private Pila pila; 
	public static int PRUEBAT=150;
	
	@Before
	public void setUp1() {
		pila= new Pila(); 
	}
	public void setUp2() {
		for(int i =0; i< PRUEBAT;i++){
			pila.agregarElemento(""+i);
		}
	}

	/**
	 * agrega un elemento al final de la pila
	 */
	public void agregarElemento( ) {
		pila.agregarElemento("Prueba");
		assertNotNull("No agreg� correctamente", pila.darUltimo());
		pila.agregarElemento("Prueba2.0");
		assertEquals("No agreg� correctamente", "Prueba 2.0", pila.darUltimo());
	}
	
	/**
	 * elimina el ultimo elemento de la pila
	 * @return el elemento eliminado
	 * @throws Exception 
	 */
	public void eliminarElemento() throws Exception{
		setUp2();
		assertEquals("No elimin� correctamente", "150",pila.eliminarElemento());
		assertEquals("No actualiza el tama�o cuando se elimina", PRUEBAT-1, pila.darTama�o());
		assertEquals("No elimin� correctamente", "149",pila.eliminarElemento());
		assertEquals("No actualiza el tama�o cuando se elimina", PRUEBAT-2, pila.darTama�o());
	};

	/**
	 * Retorna el elemento en la posicion i
	 * @param pos la posicion, inicia desde 0
	 * @return elemento en posicion dada
	 * @throws Exception 
	 */
	public void darElementoPosicion(int pos) throws Exception{
		
	}
	
	/**
	 * retorna el total de elementos en la pila
	 * @return cantidad de elementos en pila
	 */
	public void darTama�o() {
	setUp2();
	assertEquals("El tamano no es correcto", PRUEBAT, pila.darTama�o());
	}
}
