package es.dam1.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MesesDias {
	
	public Map<String, Integer> mapMesesDias = new LinkedHashMap<>();
	public ObservableList<String> listaMeses = FXCollections.observableArrayList();
	public ObservableList<Integer> listaDias = FXCollections.observableArrayList();
	
	public MesesDias() {
		mapMesesDias.put("Enero", 31);
		mapMesesDias.put("Febrero", 28);
		mapMesesDias.put("Marzo", 31);
		mapMesesDias.put("Abril", 30);
		mapMesesDias.put("Mayo", 31);
		mapMesesDias.put("Junio", 30);
		mapMesesDias.put("Julio", 31);
		mapMesesDias.put("Agosto", 31);
		mapMesesDias.put("Septiembre", 30);
		mapMesesDias.put("Octubre", 31);
		mapMesesDias.put("Noviembre", 30);
		mapMesesDias.put("Diciembre", 31);
	}
	
	public void anyoBisiesto() {
		mapMesesDias.replace("Febrero", 29);
	}
	
	
}
