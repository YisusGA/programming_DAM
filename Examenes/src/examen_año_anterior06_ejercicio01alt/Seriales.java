package examen_año_anterior06_ejercicio01alt;

import java.util.Objects;

public class Seriales {
	private int serial;

	public Seriales(int serial) {
		this.serial = serial;
	}

	public int getSerial() {
		return serial;
	}

	private void setSerial(int serial) {
		this.serial = serial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seriales other = (Seriales) obj;
		return serial == other.serial;
	}

}
