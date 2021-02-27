package practica_JUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class TestCuenta //creamos nuestros objetos de diferentes clases
{
	Cuenta objCuenta; //hola que ase
	Date today;
	Debito objDebito;
	Credito objCredito;
	
public TestCuenta(Cuenta objCuenta, Date today, Debito objDebito, Credito objCredito) {
		this.objCuenta = objCuenta;
		this.today = today;
		this.objDebito = objDebito;
		this.objCredito = objCredito;
	}

	@Before public void before() //inicializamos los objetos con sus atributos
	{
		objCuenta=new Cuenta("1234","Pepe");
	    today=new Date();
		objDebito=new Debito("12345", "ivan", today);
		objCredito=new Credito("12345", "ivan", today, 2000);
	}
	
	//EJ1: Comprobar si tras hacer un ingreso inicial a una cuenta, por ejemplo de 500€, la cuenta tiene ese saldo

	@Test public void testIngreso() throws Exception 
	{
		objCuenta.ingresar(500);
		assertEquals(500, objCuenta.getSaldo());
	}
	
	/*EJ2: Comprobar si una cuenta con un saldo, por ejemplo de 500€, tras retirar ese saldo, la cuenta se
	encuentra con un saldo 0*/
	
	@Test public void testRetirada() throws Exception 
	{
		objCuenta.ingresar(500);
		objCuenta.retirar(objCuenta.getSaldo());
		assertTrue(objCuenta.getSaldo()==0);
	}
	
	//EJ3: Comprobar que al ingresar un saldo de 500€ y retirar 300€, la cuenta tiene un saldo de 200€
	
	@Test public void testResta() throws Exception {
		objCuenta.ingresar(500);
		objCuenta.retirar(300);
		assertEquals(200, objCuenta.getSaldo());
	}
	
	/*EJ4: Comprobar si una cuenta con un saldo, por ejemplo de 500€, tras retirar ese saldo con la tarjeta, el
	saldo de la tarjeta debe ser igual al de la cuenta que será 0*/

	@Test public void testTarjeta() throws Exception {
		
		objCuenta.ingresar(500);
		
		objDebito.setCuenta(objCuenta); //vinculo a objDebito la cantidad que tiene objCuenta
		
		objDebito.retirar(500);	
		
		assertTrue(objDebito.getSaldo()==0 && objCuenta.getSaldo()==objDebito.getSaldo());
	}
	
	/*EJ5: Comprobar que al ingresar (por ejemplo de 500€) en una cuenta (con un saldo por ejemplo de
	500€) con una tarjeta de crédito, el salgo es igual al anterior de la cuenta más lo ingresado con la
	tarjeta (por ejemplo de 1000€). El saldo de la tarjeta y el crédito de la misma, no debe haber
	variado con esta operación.*/
	
    @Test public void testSaldo() throws Exception 
    {
		
    	objCuenta.ingresar(500);
    	
		objCredito.setCuenta(objCuenta);
		
		objCredito.ingresar(500);

		assertTrue(objCuenta.getSaldo()==1000);
		assertTrue(objCredito.getSaldo()==500);
			
	}
    
    
    /*Ej6 Comprobar que al retirar dinero con la tarjeta me cobra un 5% del importe y como minimo 3€.
    (Retirar 500€ → 25€ (Son 25) y 50€ → 3€)*/
	
  @Test public void testComision() throws Exception {
	
	  objCuenta.ingresar(1000);
	  
	  objCredito.setCuenta(objCuenta);

	  objCredito.retirar(50);
	  
	  assertTrue(objCredito.getSaldo()==3);  // ¿No se tendría que llamar getIntereses?
	  
	  objCredito.retirar(500);
	  
	  assertTrue(objCredito.getSaldo()==28);
	}
  
  /*Ej7 Comprobar que al liquidar una tarjeta sobre han hecho varios pagos, el saldo de la cuenta baja la
  suma de esos pagos. (Cuenta con 500€. Pagos con tarjeta 100€ y 200€. Saldo después de liquidar
  200€)*/
	
  @SuppressWarnings({ "deprecation", "deprecation", "deprecation", "deprecation" })
@Test public void testLiquidar() throws Exception {
		
	  objCuenta.ingresar(500);
	  
	  objCredito.setCuenta(objCuenta);
	  //objCredito.ingresar(500);
	  objCredito.pagoEnEstablecimiento("compra1", 100);
	  objCredito.pagoEnEstablecimiento("compra2", 200);
	  
	  objCredito.liquidar(today.getMonth()+2, today.getYear());
	  
	  assertTrue(objCuenta.getSaldo()==500);
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
