package ejercicios.herencia.geometria.profe;

import ejemploEnum.DiaSemana;
import teclado.Teclado2;

public enum TipoFigura {
	
	TRIANGULO,CIRCULO,CUADRADO;
	
	public static TipoFigura leerTeclado() {
		
		String input = Teclado2.leerCadena();
		TipoFigura[] figs = values();
		for(TipoFigura fig : figs) {
			if(fig.name().equalsIgnoreCase(input))
				return fig;
		}
		return null;
	}
}
