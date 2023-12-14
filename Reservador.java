import java.util.Random;

public class Reservador extends Thread {
	
	private static int Conteoreservadores = 0;
	private int IDReservador;
	
	public Reservador() {
		IDReservador = ++Conteoreservadores;
		start();
	}
	
	private void reservar() {
		Random num = new Random();
		int r = num.nextInt(99) + 1;
		int TiempoDormido = 1500;
		
		try {
			sleep(TiempoDormido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El Reservador " + IDReservador + " solicitó la concesión de " + r + " productos.");
		
		Inventario.getinventario().add(r);
	}
	
	
	@Override
	public void run() {
		
		while (true) {
			
			if (Inventario.getinventario().size() == Inventario.Inventario_Size) {
				System.out.println("El inventario está completo, tendrá que esperar a que algún liberador venga.");
			}
			
			try {
				Inventario.getLibera().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			reservar();
			Inventario.getReserva().release();
		}
	}
}
