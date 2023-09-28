package Vehiculo;

public class Parking {
	    private String nombre;
	    private int capacidad;
	    private int[] horasApertura = {6, 12, 18, 24};
	    private int plazasOcupadas = 0;

	    
	    public Parking() {
	    this.nombre="";
	    this.capacidad=0;
	    this.plazasOcupadas=0;
	    }

	    public Parking(String nombre, int capacidad) {
	        this.nombre = nombre;
	        this.capacidad = capacidad;
	    }

	    public boolean libre() {
	    	if( plazasOcupadas < capacidad) {
	    		System.out.println("hay sitio en "+this.nombre);
	    		return true;
	    	}else {
	    		System.out.println(this.nombre+" esta completo");
	    		return false;
	    	}
	    }

	    
	    public int disponibles() {
	    	int libres=capacidad - plazasOcupadas;
	    	if(libres==0) {
	    		System.out.println("no hay plazas libres en "+this.nombre);
	    	}else {
	    	System.out.println("hay "+libres+" plazas libres en "+this.nombre);
	    	}
	        return libres;
	    }

	   
	    public void ocuparPlaza() {
	        plazasOcupadas++;
	        System.out.println("vehiculo aparcado");
	    }

}

