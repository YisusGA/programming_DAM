package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class GUIController {
	private ObservableList<Integer> descuentos = FXCollections.observableArrayList();
	
	@FXML
	private TextField precioBaseTxt;
	@FXML
	private ComboBox<Integer> descuentoInt;
	@FXML
	Label precioFinalTxt;
	
	@FXML
	public void initialize() {
		descuentos.add(10);
		descuentos.add(20);
		descuentos.add(50);
		descuentoInt.setItems(descuentos);
	}
	
	@FXML
	public void mostrarPrecioFinal() {
		String precioBase = precioBaseTxt.getText();
		Integer descuento = descuentoInt.getSelectionModel().getSelectedItem();
		Double precioFinal = ServiceController.calcularPrecioFinal(precioBase, descuento);
		if (precioFinal != null) {
			precioFinalTxt.setText("" + precioFinal);
			precioFinalTxt.setTextFill(Paint.valueOf("black"));
		} else {
			precioFinalTxt.setText("NaN");
			precioFinalTxt.setTextFill(Paint.valueOf("red"));
		}
	}
	
}
