package es.esi.cr.iso.gestionmesas.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GestorMesasTest {

	
	private GestorMesas gestorMesas;
	
	@Before
	public void setUp() {
		gestorMesas = new GestorMesas();
	}
	
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void testReload() {
		gestorMesas.reload();
		
		assertEquals(gestorMesas.getTurnoServicio(), 0);
		
	}

}
