package ejercicio14_profe;

public class Punto {
	
	private double x,y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double distancia(Punto p) {
		
		//coordenadas del punto que llama al método: x , y
		//coordenadas del punto parámetro p.getX() , p.getY()
		 double dif = (x-p.getX())*(x-p.getX()) +
				 (y-p.getY())*(y-p.getY());
		 return Math.sqrt(dif);
	}
	
	public static double distancia(Punto p1, Punto p2) {
		 double dif = (p1.getX()-p2.getX())*(p1.getX()-p2.getX()) +
				 (p1.getY()-p2.getY())*(p1.getY()-p2.getY());
		 return Math.sqrt(dif);
	}
	
	

}
