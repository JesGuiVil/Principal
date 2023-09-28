package AccesoDatos;

public class Main {

	public static void main(String[] args) {
		AccesoSakila accSakila=new AccesoSakila();
		accSakila.conexionBBDD();// nos conectamos a la base de datos sakila usuario root
		accSakila.getActor();// leemos la tabla "actor" por comprobar que funciona.
	}

}
