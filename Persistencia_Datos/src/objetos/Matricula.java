package objetos;

import java.io.Serializable;
import java.util.List;

public class Matricula implements Serializable {
	private int codigo;
	private List<String> modulos;

	public Matricula() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<String> getModulos() {
		return modulos;
	}

	public void setModulos(List<String> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Matricula [codigo=" + codigo + ", modulos=" + modulos + "]";
	}

}
