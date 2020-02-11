package test.logic;

import static org.junit.Assert.*;

import model.logic.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=10;

	@Before
	public void setUp1() {
		modelo= new Modelo();
		
	}
	public void setUp2() {
		Comparendo a = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo b = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo c = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo d = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo e = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo f = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo g = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C01","d","l");//Diferente Infraccion
		Comparendo h = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo i = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo j = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo k = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo l= new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo m = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");
		Comparendo n = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","v","S","C02","d","l");
		Comparendo o = new Comparendo ("Feature", "1", 0.0,0.0, 0.000,9,"f","m","V","S","C02","d","l");

		modelo.agregarPilaCola(a);
		modelo.agregarPilaCola(b);
		modelo.agregarPilaCola(c);
		modelo.agregarPilaCola(d);
		modelo.agregarPilaCola(e);
		modelo.agregarPilaCola(f);
		modelo.agregarPilaCola(g);
		modelo.agregarPilaCola(h);
		modelo.agregarPilaCola(i);
		modelo.agregarPilaCola(j);
		modelo.agregarPilaCola(k);
		modelo.agregarPilaCola(l);
		modelo.agregarPilaCola(m);
		modelo.agregarPilaCola(n);
		modelo.agregarPilaCola(o);
	}

	@Test
	public void req2() {
		// TODO
		try {
			modelo.responderRequerimiento2();
			fail("deberia haber ido a la exce´pcion");
			
		} catch (Exception e) {
		
		}
		
	}

	public void req22() {
		setUp2();
		try {
			//AsserE
			assertEquals("Error en el requerimiento 2", 8, modelo.responderRequerimiento2().darTamano());
			for( int i =0; i<modelo.darCola().darTamaño();i++) {
			assertEquals("Error en los objetos comparendos del requerimiento 2",modelo.darCola().darElementoPosicion(i), modelo.responderRequerimiento2().darElementoPosicion(i));//modelo.responderRequerimiento2();
		} 
		}catch (Exception e) {
			e.getMessage(); 
		}
	}
	@Test
	public void req3() {
		setUp2();
		try {
			assertEquals("Error en requerimiento 3", 1, modelo.responderRequerimiento3("C01", 5).darTamano());
			//assertEquals("Error en requerimiento 3", 1, modelo.responderRequerimiento3("C01", 1).darTamano());
			//assertEquals("Error en requerimiento 3", 5, modelo.responderRequerimiento3("C02", 5).darTamano());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void req3Caso2() {
		setUp2();
		try {
			assertEquals("Error en requerimiento 3", 1, modelo.responderRequerimiento3("C01", 1).darTamano());
			//assertEquals("Error en requerimiento 3", 5, modelo.responderRequerimiento3("C02", 5).darTamano());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void req3Caso3() {
		setUp2();
		try {
			assertEquals("Error en requerimiento 3", 5, modelo.responderRequerimiento3("C02", 5).darTamano());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}