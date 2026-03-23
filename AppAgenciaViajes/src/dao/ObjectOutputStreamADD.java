package dao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamADD extends ObjectOutputStream {

	public ObjectOutputStreamADD(OutputStream os) throws IOException {
		// El error que nos sale aquí debajo en el super(os) sólo nos permite hacer un
		// throws, no un try-catch
		super(os);
	}

	@Override
	public void writeStreamHeader() {
		// Lo sobreescribimos y lo dejamos vacío, porque lo que queremos es que no
		// escriba cabecera alguna
	}
}
