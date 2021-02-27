package practica_JUnit;

public interface interfaz {

	void retirar(double x) throws Exception //hola colita
	;

	void ingresar(double x) throws Exception;

	void pagoEnEstablecimiento(String datos, double x) throws Exception;

	double getSaldo();

	double getCreditoDisponible();

	void liquidar(int mes, int a“o);

}