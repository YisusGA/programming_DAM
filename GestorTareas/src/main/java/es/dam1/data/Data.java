package es.dam1.data;

import es.dam1.model.Tarea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {

	// Una ObservableList es una List a todos los efectos, con la particularidad de
	// que queda vinculada al elemento al que se fije (a la tabla en este caso
	public static ObservableList<Tarea> tareas = FXCollections.observableArrayList();;

}
