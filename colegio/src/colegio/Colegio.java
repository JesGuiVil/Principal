package colegio;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Colegio {

	Scanner sc=new Scanner(System.in);
	protected ArrayList<Aula> aulas=new ArrayList<>();
	protected String nombre;
	protected ArrayList<Profesor> profesores=new ArrayList<>();;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}


	public Colegio(ArrayList<Aula> aulas, String nombre) {
		super();
		this.aulas = aulas;
		this.nombre = nombre;
	}


	public Colegio() {
		super();
	}


	public void menu() {
		int opcion=1;
		do {
			System.out.println("OPCIONES DEL COLEGIO");
			System.out.println("----------------");
			System.out.println("1.Insertar Alumno en un aula");
			System.out.println("2.Eliminar Alumno de un aula");
			System.out.println("3.Mostrar Alumnos que han aprobado una determinada asignatura");
			System.out.println("4.Ordenar Alumnos de un aula en orden creciente por sus apellidos");
			System.out.println("5.Mostrar la nota del alumno en una determinada asignatura");
			System.out.println("6.Cambiar el Profesor de un aula");
			System.out.println("7.Aumentar sueldo de todo el profesorado");
			System.out.println("8.Reducir sueldo de todo el profesorado");
			System.out.println("0.SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {insertaAlumno();}
			if (opcion==2) {eliminaAlumno();}
			if (opcion==3) {muestraAlumno();}
			/*if (opcion==4) {ordenaAula();}*/
			if (opcion==5) {muestraNota();}
			if (opcion==6) {cambiaProfesor();}
			if (opcion==7) {aumentaSueldo();}
			if (opcion==8) {reduceSueldo();}

		}while (opcion!=0);
	}

	public void creaColegio() {
		ArrayList<Alumno> alumnos1A=new ArrayList<>();
		ArrayList<Alumno> alumnos1B=new ArrayList<>();
		Asignatura programacion=new Asignatura("programacion");
		Asignatura basedatos=new Asignatura("basedatos");
		Asignatura lenguaje=new Asignatura("lenguaje");
		Asignatura entornos=new Asignatura("entornos");
		Asignatura sistemas=new Asignatura("sistemas");
		Asignatura fol=new Asignatura("fol");
		Profesor JuanCa = new Profesor("JuanCa", "Nose", "Nomeacuerdo","12345678L",40,programacion,basedatos,lenguaje,1500);
		Profesor Galis = new Profesor("Antonio", "Galisteo", "Nomeacuerdo","87654321L",50,entornos,sistemas,fol,1500);
		profesores.add(JuanCa);
		profesores.add(Galis);
		aulas.add(new Aula("1A",JuanCa,alumnos1A));
		aulas.add(new Aula("1B",Galis,alumnos1B));

	}

	public void eliminaAlumno(){
		System.out.println("introduce el dni del alumno que desea eliminar");
		String dni=sc.next();
		Iterator <Alumno> ite= aulas.get(0).getAlumnos().iterator();
		Iterator <Alumno> ite2= aulas.get(1).getAlumnos().iterator();
		boolean existe=false;
		while(ite.hasNext()) {
			Alumno x =ite.next();
			if(x.getDni().equals(dni)) {
				ite.remove();
				System.out.println("alumno eliminado");
				System.out.println(""); 
				existe=true;
			}

		}
		while(ite2.hasNext()) {
			Alumno x =ite2.next();
			if(x.getDni().equals(dni)) {
				ite2.remove();
				System.out.println("alumno eliminado");
				System.out.println(""); 
				existe=true;
			}

		}
		if(!existe) {
			System.out.println("ese alumno no existe");
			System.out.println("");	 
		}
	}

	public void insertaAlumno() {

		Alumno AluAux= new Alumno();
		System.out.println("introduce nombre del alumno");
		AluAux.setNombre(sc.next());
		System.out.println("introduce primer apellido");
		AluAux.setApellido1(sc.next());
		System.out.println("introduce segundo apellido");
		AluAux.setApellido2(sc.next());
		System.out.println("introduce DNI");
		AluAux.setDni(sc.next());
		System.out.println("introduce nota de programacion");
		AluAux.setNotaprogramacion(sc.nextInt());
		System.out.println("introduce nota de basedatos");
		AluAux.setNotabasedatos(sc.nextInt());
		System.out.println("introduce nota de lenguaje");
		AluAux.setNotalenguaje(sc.nextInt());
		System.out.println("introduce nota de sistemas");
		AluAux.setNotasistemas(sc.nextInt());
		System.out.println("introduce nota de entornos");
		AluAux.setNotaentornos(sc.nextInt());
		System.out.println("introduce nota de fol");
		AluAux.setNotafol(sc.nextInt());
		System.out.println("elige el grupo");
		String respuesta=sc.next();
		boolean existe=false;
		for(Aula a: aulas) {
			if(a!=null) {
				if(a.getGrupo().equals(respuesta)){
					a.getAlumnos().add(AluAux);
					existe=true;
				}
			}
		}
		if(!existe) {
			System.out.println("ese grupo no se encuentra, introduzca 1A o 1B");
		}
	}
	public void cambiaProfesor() {
		System.out.println("introduce el grupo al que desea cambiar el profesor");
		String grupo=sc.next();
		System.out.println("introduce el dni del profesor que le quiere asignar");
		String dni=sc.next();
		int posicion=-1;
		String grupoaux;
		boolean profeexiste=false;
		boolean grupoexiste=false;
		for (Profesor p: profesores) {
			if(p!=null) {
				if(p.getDni().equals(dni)){
					profeexiste=true;
					posicion=profesores.indexOf(p);
				}
			}
		}
		if(!profeexiste) {
			System.out.println("ese profesor no existe");
		}
		for(Aula a: aulas) {
			if(a!=null) {
				if(a.getGrupo().equals(grupo) && profeexiste){
					a.setProfesor(profesores.get(posicion));
					System.out.println("profesor asignado");
					grupoexiste=true;					
				}
			}
		}
		if(!grupoexiste && profeexiste) {
			System.out.println("ese grupo no se encuentra, introduzca 1A o 1B");
		}
	}

	public void aumentaSueldo() {
		System.out.println("introduzca el % de incremento que desea");
		int incremento=sc.nextInt();
		for (Profesor p: profesores) {
			if(p!=null) {
				p.setSueldo(p.getSueldo()+(p.getSueldo()*incremento/100));
				System.out.println(" el sueldo de "+p.getNombre()+" "+p.getApellido1()+" ahora es de: "+p.getSueldo());
			}
		}
	}
	public void reduceSueldo() {
		System.out.println("introduzca el % de incremento que desea");
		int incremento=sc.nextInt();
		for (Profesor p: profesores) {
			if(p!=null) {
				p.setSueldo(p.getSueldo()-(p.getSueldo()*incremento/100));
				System.out.println(" el sueldo de "+p.getNombre()+" "+p.getApellido1()+" ahora es de: "+p.getSueldo());
			}
		}
	}
	public void muestraAlumno() {
		System.out.println("que asignatura quieres consultar?");
		String nombre=sc.next();
		if (nombre.equals("programacion")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotaprogramacion()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotaprogramacion()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
		if (nombre.equals("sistemas")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotasistemas()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotasistemas()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
		if (nombre.equals("basedatos")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotabasedatos()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotabasedatos()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
		if (nombre.equals("entornos")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotaentornos()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotaentornos()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
		if (nombre.equals("lenguaje")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotalenguaje()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotalenguaje()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
		if (nombre.equals("fol")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getNotafol()>=5) {
						System.out.println(a.toString());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getNotafol()>=5) {
						System.out.println(a.toString());
					}
				}
			}
		}
	}
	public void muestraNota() {
		System.out.println("que asignatura quieres consultar?");
		String nombre=sc.next();
		System.out.println("introduce el dni del alumno del que quiere saber la nota");
		String dni=sc.next();
		if (nombre.equals("programacion")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotaprogramacion());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotaprogramacion());
					}
				}
			}
		}
		if (nombre.equals("sistemas")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotasistemas());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotasistemas());
					}
				}
			}
		}
		if (nombre.equals("basedatos")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotabasedatos());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotabasedatos());
					}
				}
			}
		}
		if (nombre.equals("entornos")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotaentornos());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotaentornos());
					}
				}
			}
		}
		if (nombre.equals("lenguaje")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotalenguaje());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotalenguaje());
					}
				}
			}
		}
		if (nombre.equals("fol")){
			for(Alumno a: aulas.get(0).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotafol());
					}
				}
			}
			for(Alumno a: aulas.get(1).getAlumnos()) {
				if(a!=null) {
					if (a.getDni().equals(dni)) {
						System.out.println(a.getNotafol());
					}
				}
			}
		}
	}
	public void ordenaAula() {
		System.out.println("introduce el grupo que desea ordenar");
		String grupo=sc.next();
		if (aulas.get(0).getGrupo().equals(grupo)) {
			
		}
	}
}