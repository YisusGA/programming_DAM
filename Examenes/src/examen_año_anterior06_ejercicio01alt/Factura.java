package examen_año_anterior06_ejercicio01alt;

public class Factura extends ApunteEconomico {
	int idFactura;
	String emisor;

	public Factura(int year, double importe, String concepto, int idFactura, String emisor) {
		super(year, importe, concepto);
		this.idFactura = idFactura;
		this.emisor = emisor;
	}

	public Factura() {
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Override
	public String toString() {
		return "Factura [code=" + code + ", importe=" + importe + ", concepto=" + concepto + ", idFactura=" + idFactura
				+ ", emisor=" + emisor + "]";
	}

	@Override
	public void describe() {
		System.out.println("Factura [code=" + code + ", importe=" + importe + ", concepto=" + concepto + ", idFactura="
				+ idFactura + ", emisor=" + emisor + "]");
	}

}
