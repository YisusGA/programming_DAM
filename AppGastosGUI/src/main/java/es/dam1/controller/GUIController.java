package es.dam1.controller;

import java.io.IOException;
import java.util.List;

import es.dam1.dataAccess.Datos;
import es.dam1.utils.Calendario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;

public class GUIController {
	private Calendario mesesDias = new Calendario();

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
	private ToggleGroup meses;
	@FXML
	private ListView<String> listViewGastos;

	@FXML
	public void initialize() {
		mesesDias.listaMeses.addAll(mesesDias.mapMesesDias.keySet());
		comboMes.setItems(mesesDias.listaMeses);
		comboDia.setItems(mesesDias.listaDias);
		listViewGastos.setItems(ServiceController.listaGastos);
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
				Double gasto = ServiceController.parsearDouble(gastoTxt.getText());
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
	
	@FXML
	public void mostrarGastos() {
		ServiceController.listaGastos.clear();
		RadioButton mesSeleccionado = (RadioButton)meses.getSelectedToggle();
		if (mesSeleccionado != null) {
			try {
				List<String> lista = Datos.listadoGastosMes(mesSeleccionado.getText());
				if (lista != null) {
					ServiceController.listaGastos.addAll(lista);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
