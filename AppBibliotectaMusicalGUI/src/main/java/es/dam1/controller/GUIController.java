package es.dam1.controller;

import java.util.Optional;

import es.dam1.model.Album;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIController {

	@FXML
	ComboBox<String> comboGenero;
	@FXML
	ListView<Album> listaAlbumes;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtArtista;
	@FXML
	private TextArea areaNotas;
	@FXML
	private Label resultadoOperacion;
	@FXML
	private Button btnAdd;
	@FXML
	private MenuBar menuBar;
	
	@FXML
	public void initialize() {
		cargaGeneros();
		cargaAlbumes();
	}

	@FXML
	public void addAlbum() {
		resultadoOperacion.setText("");
		boolean added = false;
		String nombre = txtNombre.getText().trim();
		String artista = txtArtista.getText().trim();
		String genero = comboGenero.getValue();
		String notas = areaNotas.getText().trim();
		if (genero != null) {
			genero.trim();
			added = ServiceController.addAlbum(nombre, artista, genero, notas);
		}
		if (added) {
			resultadoOperacion.setText("Álbum añadido");
			resultadoOperacion.setTextFill(Paint.valueOf("black"));
			limpiarFormulario();
		} else {
			resultadoOperacion.setText("No se pudo añadir el álbum");
			resultadoOperacion.setTextFill(Paint.valueOf("red"));
		}
	}

	@FXML
	public void mostrarDatosAlbum(MouseEvent event) {
		int numeroClicks = event.getClickCount();
		if (numeroClicks == 2) {
			Album albumSeleccionado = listaAlbumes.getSelectionModel().getSelectedItem();
			if (albumSeleccionado != null) {
				txtNombre.setText(albumSeleccionado.getNombre());
				txtArtista.setText(albumSeleccionado.getArtista());
				comboGenero.setValue(albumSeleccionado.getGenero());
				String notasYCanciones = String.format("""
						Notas:

						%s

						Canciones(%d):

						%s
						""", albumSeleccionado.getNotas(), albumSeleccionado.getCanciones().size(),
						albumSeleccionado.obtenerStringListaCanciones());
				areaNotas.setText(notasYCanciones);
				resultadoOperacion.setText("Archivo>Limpiar formulario para añadir nuevo álbum");
				btnAdd.setDisable(true);
			}
		}
	}

	@FXML
	public void addSong() {
		resultadoOperacion.setText("");
		Album albumSeleccionado = listaAlbumes.getSelectionModel().getSelectedItem();
		if (albumSeleccionado != null) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Datos de la canción");
			dialog.setHeaderText("");
			dialog.setContentText("Introduce el nombre de la canción");
			Optional<String> nombre = dialog.showAndWait();
			dialog.getEditor().clear();
			dialog.setContentText("Introduce duración de la canción");
			Optional<String> duracion = dialog.showAndWait();
			if (nombre.isPresent() && duracion.isPresent()) {
				ServiceController.addSongToAlbum(albumSeleccionado, nombre.get(), duracion.get());
				limpiarFormulario();
				resultadoOperacion.setText("Canción añadida");
				resultadoOperacion.setTextFill(Paint.valueOf("black"));
			}
		}
	}

	@FXML
	public void eliminarAlbum() {
		Album albumSeleccionado = listaAlbumes.getSelectionModel().getSelectedItem();
		if (albumSeleccionado != null) {
			ServiceController.eliminarAlbum(albumSeleccionado);
			limpiarFormulario();
		}
	}
	
	@FXML
	public void limpiarFormulario() {
		comboGenero.setValue("");
		txtNombre.setText("");
		txtArtista.setText("");
		areaNotas.setText("");
		resultadoOperacion.setText("");
		btnAdd.setDisable(false);
		listaAlbumes.getSelectionModel().clearSelection();
	}
	
	@FXML
	public void cerrarPrograma() {
		Stage stage = (Stage) menuBar.getScene().getWindow();
		stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	@FXML
	public void mostrarInfoApp() {
		resultadoOperacion.setText("Yisus Music Services S.L.");
		resultadoOperacion.setTextFill(Paint.valueOf("black"));
	}

	public void cargaGeneros() {
		ServiceController.getListaGeneros().add("Rock");
		ServiceController.getListaGeneros().add("Pop");
		comboGenero.setItems(ServiceController.getListaGeneros());
	}

	public void cargaAlbumes() {
		listaAlbumes.setItems(ServiceController.getListaAlbumes());
	}

}
