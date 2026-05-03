package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class GUIController implements Initializable {
	private GestorAlumno g; // Atributo que inicializaremos dentro del método initialize
	private static int posicionAlumno = -1; // Contador usado para el método siguienteAlumno()

	// Es necesario poner esta anotación para indicarle que no son variables que yo
	// creo mediante código, sino que vienen del fichero fmxl. Es importante que
	// tengan el mismo nombre que le asignamos en el fx:id en ese campo, pues
	// buscará eso en el fxml
	@FXML
	TextField nif;
	@FXML
	TextField nombre;
	@FXML
	TextField nota;
	@FXML
	Label resTxt;
	@FXML
	TextArea txtAlumno;
	@FXML
	TextField fichero;
	@FXML
	Label saveTxt;

	@FXML
	private void guardar() {
		if (fichero.getText().length() > 0) {
			File file = new File(fichero.getText());
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
				oos.writeObject(g); // Serializamos el gestor, que tiene dentro la lista de Alumnos
				saveTxt.setText("Alumnos guardados correctamente");
			} catch (FileNotFoundException e1) {
				saveTxt.setText("El fichero no existe");
				saveTxt.setTextFill(Paint.valueOf("red"));
				e1.printStackTrace();
			} catch (IOException e2) {
				saveTxt.setText("Error IO");
				saveTxt.setTextFill(Paint.valueOf("red"));
				e2.printStackTrace();
			}
		}
	}

	@FXML
	private void add() {
		double notaTemp = -1;
		try {
			do {
				notaTemp = Double.parseDouble(nota.getText());
			} while (notaTemp < 0 || notaTemp > 10);
		} catch (NumberFormatException e) {
			resTxt.setText("Formato de nota no válido");
			resTxt.setTextFill(Paint.valueOf("red"));
			// e.printStackTrace();
		}
		if (notaTemp != -1) {
			Alumno a = new Alumno(nif.getText(), nombre.getText(), notaTemp);
			if (g.add(a)) {
				resTxt.setText(
						"Alumno añadido:\n" + a + "\n-------\n" + "Tamaño lista: " + g.devolverListaAlumnos().size());
				resTxt.setTextFill(Paint.valueOf("black"));
			} else {
				resTxt.setText("Ya existe un alumno con ese nif");
				resTxt.setTextFill(Paint.valueOf("red"));
			}
		} else {

		}
	}

	private void printAreaTxt() {
		Alumno actual = g.getAlumno(posicionAlumno);
		txtAlumno.setText(actual.toString());
	}

	@FXML
	public void anteriorAlumno() {
		if (g.size() > 0) {
			posicionAlumno--;
			if (posicionAlumno == -1) {
				posicionAlumno = g.size() - 1;
			}
			printAreaTxt();
		}
	}

	@FXML
	public void siguienteAlumno() {
		if (g.size() > 0) {
			posicionAlumno++;
			if (posicionAlumno == g.size()) {
				posicionAlumno = 0;
			}
			printAreaTxt();
		}
	}

	// Este método se implementa desde la interfaz Initializable que hemos
	// implementado en la clase, y se ejecutará cada vez que se inicialize la clase
	// GUIController, que será cada vez que iniciemos la app
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		File file = new File("alumnos.dat");
		if (file.exists()) { // Si existe el archivo, intento cargar el GestorAlumno
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				g = (GestorAlumno) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				g = new GestorAlumno(); // Si no se ha podido cargar el GestorAlumno, genero uno nuevo
				//e.printStackTrace();
			}
		} else {
			g = new GestorAlumno(); // Si no existe el fichero, genero un nuevo GestorAlumno
		}

	}

}
