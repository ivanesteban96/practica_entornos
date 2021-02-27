package practica_JUnit;

public class CreditoNuevo {
	private CreditoData data;

	public CreditoNuevo(CreditoData data) {
		this.data = data;
	}

	public CreditoData getData() {
		return data;
	}

	public void setData(CreditoData data) {
		this.data = data;
	}
}