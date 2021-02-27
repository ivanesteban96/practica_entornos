package practica_JUnit;
import java.util.Vector;

public class Cuenta
{
	protected String numero;
	protected String titular;
	protected Vector<Movimiento> movimientos;
	public Cuenta(String _numero, String _titular)
	{
		numero=_numero;
		titular=_titular;
		movimientos=new Vector<Movimiento>();
	}
	public void ingresar(double x) throws Exception
	{
		if (x<=0)
		throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento movimientos=new Movimiento();
		movimientos.setConcepto("Ingreso en efectivo");
		movimientos.setImporte(x);
		this.movimientos.addElement(movimientos);
		
		
	}
	public void retirar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	public void ingresar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		this.movimientos.addElement(m);
	}
	public void retirar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	public double getSaldo()
	{
		double r=0.0;
		for (int i=0; i<this.movimientos.size(); i++)
		{
			Movimiento m=movimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	public void addMovimiento(Movimiento m)
	{
		movimientos.addElement(m);
	}
}