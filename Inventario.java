import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Inventario {
	
	private static ConcurrentLinkedQueue<Integer> inventario = new ConcurrentLinkedQueue<Integer>();
	public final static int Inventario_Size = Integer.MAX_VALUE;
	private static Semaphore Reserva = new Semaphore(0, true);
	private static Semaphore Libera = new Semaphore(Inventario_Size, true);
	
	public static ConcurrentLinkedQueue<Integer> getinventario() {
		return inventario;
	}
	public static Semaphore getReserva() {
		return Reserva;
	}
	public static Semaphore getLibera() {
		return Libera;
	}

}
