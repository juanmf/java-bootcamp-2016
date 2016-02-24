package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Operaciones;

public class OperacionesTest {

	
	
	@Test
	public void testMultiplicacion(){
		Operaciones test = new Operaciones();
		
		int result = test.multiplicacion(2, 5);
		
		assertEquals(10,result);
	}
	
	@Test
	public void testSuma(){
		Operaciones test = new Operaciones();
		
		int result = test.suma(2, 2);
		
		assertEquals(4,result);
	}
	
	@Test
	public void testResta(){
		Operaciones test = new Operaciones();
		
		int result = test.resta(5, 2);
		
		assertEquals(3,result);
	}
	
	@Test
	public void testDivision(){
		Operaciones test = new Operaciones();
		
		int result = test.division(10, 2);
		
		assertEquals(5,result);
	}

}
