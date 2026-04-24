package es.dam1.logica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GestorFicheros {

	private boolean opened;
	private File file;

	public GestorFicheros() {

	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String read() {
		String result = null;
		try {
			result = Files.readString(file.toPath());
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
			e.printStackTrace();
		}
		return result;
	}

	public boolean write(String text) {
		boolean result = false;
		try {
			Files.writeString(file.toPath(), text);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
