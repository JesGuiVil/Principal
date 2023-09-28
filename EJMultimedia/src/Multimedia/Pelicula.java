package Multimedia;

public class Pelicula extends Multimedia{

	private String actorPrincipal;
	private String actrizPrincipal;
	
	public Pelicula(String tit, String aut, Formato f, double d, String actor, String actriz) {
		super(tit,aut,f,d);
		if (actor==null && actriz == null) {
			throw new IllegalArgumentException("Debe haber al menos un protagonista");
		}
		this.actorPrincipal=actor;
		this.actrizPrincipal=actriz;
	}
	public String getActorPrincipal() {
		return actorPrincipal;
	}
	public String getActrizPrincipal() {
		return actrizPrincipal;
	}
	
	@Override
	public String toString() {
		String s = "Protagonizado por ";
		if (actrizPrincipal != null) {
			s+= actrizPrincipal;
			if (actorPrincipal != null) {
				s+= " y " + actorPrincipal;
			}
		}else {
			assert actorPrincipal !=null;
			s += actorPrincipal;
		}
		return super.toString() + "\n" + s;
	}
}
