package es.dam1.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;

public class GUIController {
	private ObservableList<File> listaFicheros;

	@FXML
	private Label result;
	@FXML
	private TextArea text;
	@FXML
	private ComboBox<File> comboFicheros;

	@FXML
	public void initialize() {
		listaFicheros = FXCollections.observableArrayList();
		comboFicheros.setItems(listaFicheros);
	}

	@FXML
	public void openDir() {
		DirectoryChooser dc = new DirectoryChooser();
		dc.setTitle("Elige archivo para abrir");
		dc.setInitialDirectory(null);
		// A .showDialog le podemos pasar un Stage (obteniendo el Stage a partir de un
		// evento o un elemento de la GUI. Pero si lo dejamos en null, nos pilla el
		// Stage por defecto, que en este caso, es el único que hay, el actual
		Optional<File> input = Optional.of(dc.showDialog(null));
		if (input.isPresent()) {
			listaFicheros.clear();
			File directorio = input.get();
			// listFiles es un método sobrecargado. En una de sus versiones, admite un
			// filtro. Y ese filtro da lugar a esto que vemos debajo: una expresión lambda
			// que comprueba, para cada elemento, si es true o false para la expresión
			// boolean que le pasamos. Si es true, lo lista, si no, no lo lista. Y como esa
			// lista se la estamos pasando a un addAll de la ObservableList, sólo se
			// añadirán a la ObservableList aquellos files que cumplan el filtro
			listaFicheros.addAll(directorio.listFiles(x -> x.getName().contains(".txt")));
			// Aquí lo que estamos haciendo es crear una clase anónima de StringConverter
			// para sobreescribir su método toString por uno que nos convenga más. Y lo que
			// hacemos en concreto es que el método toString devuelva el nombre del File. Y
			// ese StringConverter se lo asignamos a un Converter que le pasamos al
			// ComboBox. En definitiva, esto nos permite que el ComboBox se cargue con
			// elementos File, pero que muestre los nombres de los File, en lugar de la ruta
			// completa de cada File, que es lo que hace el método toString por defecto de
			// la clase Fille
			comboFicheros.setConverter(new StringConverter<File>() {

				@Override
				public String toString(File object) {
					// Este es el método que nos interesa implementar con lo que queremos
					return object.getName();
				}

				@Override
				public File fromString(String string) {
					// Nos obliga a implementar este método, pero lo dejamos vacío, porque no nos
					// sirve para este caso
					return null;
				}

			});
		}
	}

	@FXML
	public void cargarContenido() {
		Optional<File> input = Optional.of(comboFicheros.getSelectionModel().getSelectedItem());
		if (input.isPresent()) {
			File file = input.get();
			List<String> lineas;
			try {
				lineas = Files.readAllLines(file.toPath());
				String contenido = "";
				for (String s : lineas) {
					contenido += s + "\n";
				}
				text.setText(contenido);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@FXML
	public void saveAs() {
		String contenido = text.getText();
		FileChooser fc = new FileChooser();
		fc.setTitle("Ruta de guardado");
		fc.getExtensionFilters().add(new ExtensionFilter("Archivo de texto", "*.txt"));
		Optional<File> input = Optional.of(fc.showSaveDialog(null));
		if (input.isPresent()) {
			try {
				Files.writeString(input.get().toPath(), contenido);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
