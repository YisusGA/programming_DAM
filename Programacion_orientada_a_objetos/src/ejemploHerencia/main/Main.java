package ejemploHerencia;

public class Main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		c1.setNif("1111");
		c1.setNombre("Yisus");
		
		ClienteVIP c2 = new ClienteVIP();
		c2.setNif("2222");
		c2.setNombre("Pedro");
		c2.setDireccion("Madrid");
		
		//Hasta aquí, funcionaríamos como hemos hecho hasta ahora, y la herencia no nos aportaría nada
		
		//Declaramos un cliente, pero aún no sabemos qué tipo de cliente va a ser, así que lo declaramos como Cliente normal
		Cliente c3;
		
		//La herencia nos permite que en c3 pueda guardar un objeto de la clase Cliente o de cualquiera de sus subclases
		c3 = new ClienteVIP();
		c3.nombre = "Pepe";
		c3.nif = "3333";
//		c3.direccion = "Oslo"; //El compilador no deja hacer esto porque c3 está declarado como Cliente, que no tiene dirección
		((ClienteVIP)c3).setDireccion("Oslo"); //Para que nos deje usar el setter de direccion de ClienteVIP, tenemos que hacer un casting
		//¿Por qué directamente no declaramos c3 como Cliente VIP? Podríamos hacerlo, pero lo potente viene a la hora de trabajar con arrays, como se ve debajo
		
		//Lo realmente potente viene con que podemos crear un array de objetos de la superclase y llenarlo con objetos tanto de la superclase
		//como se sus subclases
		Cliente[] clientes = new Cliente[100];
		clientes[0] = new Cliente();
		clientes[0].setNif("4444");
		clientes[0].setNombre("Pascual");
		clientes[1] = new ClienteVIP();
		clientes[1].setNif("5555");
		clientes[1].setNombre("Javi");
		((ClienteVIP)clientes[1]).setDireccion("Barcelona");
		
		//Con un mismo método, podemos mostrar los datos de diferentes tipos de Cliente
		mostrarDatosCliente(c1);
		mostrarDatosCliente(c2);
		mostrarDatosCliente(c3);
		mostrarDatosCliente(clientes[1]); //Como el casting ya lo hace el método para mostrar la dirección, no hace falta hacerlo aquí

	}
	
	//Puedo hacer un método que me sirva tanto para Cliente como para ClienteVIP, y así ahorrarme hacer 2 métodos. Y cuando sea necesario almacenar un ClienteVIP,
	//pues se hace el casting en concreto de ese objeto
	private static void mostrarDatosCliente(Cliente c) {
		System.out.println(c.getNif());
		System.out.println(c.getNombre());
		//¿Cómo saber cómo se ha instanciado el cliente que entra como parámetro para saber si mostrar o no su dirección? Con un condicional que use instanceof
		if (c instanceof ClienteVIP) {
			System.out.println(((ClienteVIP)c).getDireccion());
		}
	}

}
