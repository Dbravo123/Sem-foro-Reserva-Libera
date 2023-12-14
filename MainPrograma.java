
public class MainPrograma {
	
	public final static int Conteo_Reservadores = 100;
	public final static int Conteo_Liberadores = 300;

	public static void main(String[] args) {
		
		for (int i = 0; i < Conteo_Reservadores; i ++) {
			new Reservador();
		}
		
		for (int j = 0; j < Conteo_Liberadores; j ++) {
			new Liberador();
		}
		
		new Reservador();
		new Liberador();
	}

}
