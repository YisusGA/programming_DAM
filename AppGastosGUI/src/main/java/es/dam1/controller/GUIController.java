package es.dam1.controller;

import java.io.IOException;

import es.dam1.dataAccess.Datos;
import es.dam1.utils.MesesDias;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class GUIController {
	private MesesDias mesesDias = new MesesDias();

	@FXML
	private ComboBox<String> comboMes;
	@FXML
	private ComboBox<Integer> comboDia;
	@FXML
	private TextField gastoTxt;
	@FXML
	private Button add;
	@FXML
	private Label resultadoOperacion;

	@FXML
	public void initialize() {
		mesesDias.listaMeses.addAll(mesesDias.mapMesesDias.keySet());
		comboMes.setItems(mesesDias.listaMeses);
		comboDia.setItems(mesesDias.listaDias);
	}

	@FXML
	public void diasComboBox() {
		String mesSeleccionado = comboMes.getSelectionModel().getSelectedItem();
		if (mesSeleccionado != null) {
			Integer diasMesSeleccionado = mesesDias.mapMesesDias.get(mesSeleccionado);
			mesesDias.listaDias.clear();
			for (int i = 1; i < diasMesSeleccionado + 1; i++) {
				mesesDias.listaDias.add(i);
			}
			comboDia.setDisable(false);
		}
	}

	@FXML
	public void addGasto() {
		String mesSeleccionado = comboMes.getSelectionModel().getSelectedItem();
		if (mesSeleccionado != null) {
			Integer diaSeleccionado = comboDia.getSelectionModel().getSelectedItem();
			if (diaSeleccionado != null) {
				Double gasto = ServiceController.parsearGasto(gastoTxt.getText());
				if (gasto != null) {
					try {
						Datos.addGasto(mesSeleccionado, diaSeleccionado, gasto);
						gastoTxt.clear();
						resultadoOperacion.setText("Gasto añadido");
						resultadoOperacion.setTextFill(Paint.valueOf("black"));
						
					} catch (IOException e) {
						System.err.println("No se pudo añadir el gasto");
						e.printStackTrace();
						resultadoOperacion.setText("No se pudo añadir el gasto");
						resultadoOperacion.setTextFill(Paint.valueOf("red"));
					}
				}
			}
		}
	}

}
