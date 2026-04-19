package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import dao.DestinoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Paint;
import modelo.Destino;

public class GeneralController {

	@FXML
	Label labelDestinos;
	@FXML
	Label labelReservas;
	

	DestinoDAO destinodao = new DestinoDAO(new File("datos//destinos.dat"));

	public void insertarDestino() {
		boolean valid = false;
		String nombre = "";
		double precio = -1;
		TextInputDialog dialog = new TextInputDialog();
		while (!valid) {
			dialog.setTitle("Destino");
			dialog.setHeaderText(" ");
			dialog.setContentText("Por favor, introduce nombre destino:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				nombre = result.get().trim();
				if (!nombre.isBlank()) {
					valid = true;
				} else {
					System.err.println("Destino no valido");
				}
			}
		}
		valid = false;
		while (!valid) {
			dialog.setHeaderText(" ");
			dialog.setContentText("Por favor, introduce precio destino:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				try {
					precio = Double.parseDouble(result.get());
					valid = true;
				} catch (NumberFormatException e) {
					System.err.println("Precio no valido");
				}
			}
		}
		try {
			if (destinodao.insert(new Destino(nombre, precio))) {
				labelDestinos.setText("Destino añadido");
				labelDestinos.setTextFill(Paint.valueOf("black"));
			} else {
				labelDestinos.setText("El destino no pudo añadirse");
				labelDestinos.setTextFill(Paint.valueOf("red"));
			}
		} catch (ClassNotFoundException | IOException e) {
			labelDestinos.setText("Error en la operación");
			labelDestinos.setTextFill(Paint.valueOf("red"));
			e.printStackTrace();
		}

	}

}
