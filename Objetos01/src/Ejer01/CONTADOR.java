package Ejer01;

public class CONTADOR {
	//ATRIBUTOS
private int cont;
	//GETTER AND SETTER
public int getCont() {
	return cont;
}

public void setCont(int cont) {
	this.cont = cont;
}

//CONSTRUCTORES

public  CONTADOR() {
	this.setCont(0);
}
public  CONTADOR(int cont) {
	if (cont>0) {
		this.setCont(cont);
	}
	if (cont<=0) {
		this.setCont(0);
	}
}
public  CONTADOR(CONTADOR cont) {
	this.setCont(cont.getCont());
}
public void incrementar() {
	this.setCont(this.getCont()+1);
}
public void decrementar() {
	this.setCont(this.getCont()-1);
	if (this.getCont()<0) {
		this.setCont(0);
	}
}
}
