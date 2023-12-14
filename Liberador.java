
public class Liberador extends Thread {
	
	private static int ConteoLiberadores = 0;
	private int IDLiberador;
	
	public Liberador() {
		
		IDLiberador = ++ConteoLiberadores;
		start();
	}
	
	private void liberar() {
		
		int TiempoDormido = 1500;
		
		try {
			sleep(TiempoDormido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int l = Inventario.getinventario().poll();
		System.out.println("El liberador " + IDLiberador + " ha liberado " + l + " productos.");
	}
	
	
	@Override
	public void run() {
		
		while (true) {
			
			if (Inventario.getinventario().size() == 0) {
				System.out.println("El inventario se encuentra vacío en este momento, tendrá que esperar a que un Reservador reserve");
			}
			
			try {
				Inventario.getReserva().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			liberar();
			Inventario.getLibera().release();
		}
	}
}
