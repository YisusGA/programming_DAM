package edad_mayor_menor;

public class Edad_mayot_menor_ternario {

	public static void main(String[] args) {
		int edadYisus;
		edadYisus = 31;
		int edadDani;
		edadDani = 27;
		String mayor = (edadYisus == edadDani) ? "Ambos tienen la misma edad" : (edadYisus > edadDani) ? "Yisus es mayor" : "Dani es mayor"; 
		System.out.println(mayor);

	}

}
