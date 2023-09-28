package Palasaca;

public class principal {

	public static void main(String[] args) {
		
		Clientes c = new Clientes("20066001L","jesus","guijarro","villegas","620210919","ardijesus@gmail.com","calle_jose_manuel","alcala_de_guadaira",41500,"sevilla","28-3-93","el_tio","desempleado");
		Cuentas cuenta=new Cuentas("ahorro", 2.0, "28-3-2020", "ffinal", c, 1234, TiposCuenta.Ahorro, "ES20492248248293", 200000.0);
		Debito d= new Debito("debito", 2.0, "29-3-2020", "ffinal", c, 1234, cuenta, "12345678", 2131, "4444", "28-3-2030",200.0);
		Empleados e = new Empleados("20066001L","jesus","guijarro","villegas","620210919","ardijesus@gmail.com","calle_jose_manuel","alcala_de_guadaira",41500,"sevilla","28-3-93","el_tio","28-3-2015","gerente",2000.0, 2.0);
		Credito credito=new Credito("tarjetaso", 1.0,"20-5-1999", "20-4-2021", c, 1234, cuenta, "2049 2094 2049",2131,"awok","28-4-2020",1000.0,"28-5-2022");
		Monedero m= new Monedero("tarjetita", 3.0,"20-5-1999", "20-4-2021", c, 1234, cuenta, "2049 2094 2049",2131,"awok","28-4-2020");
		System.out.println("");
		
		
		/*hice los metodos de cuentas y tarjetas de manera que tras usar cualquiera de ellos el acceso vuelva a estar cerrado,
		asi no me arriesgo a que se quede una cuenta o tarjeta accesible.
		la contraparte es que hay que meter el ping cada vez que se quiera hacer algo.*/
		
		System.out.println("----------CLIENTE----------");
		//aqui probamos el menu de modificar datos de cliente
		c.ModificarDatos(c);
		System.out.println("");
		
		
		System.out.println("----------EMPLEADO----------");
		//aqui probamos el menu de modificar datos de empleado
		e.ModificarDatos(e);
		e.Ascenso("director",3000.0);
		e.AumentoSalarial(3.0);
		System.out.println(e.toString());
		System.out.println("");
		
		
		 
		System.out.println("----------CUENTA(clave incorrecta)----------");
		/*aqui verificamos que sin meter la clave correcta no deja actuar:*/
		System.out.println(cuenta.DatosCuenta());
		cuenta.Acceso(0020);
		cuenta.SacarDinero(200);
		System.out.println(cuenta.DatosCuenta());
		System.out.println("");
		System.out.println("----------CUENTA(clave correcta)----------");
		//aqui usamos la clave correcta y probamos los metodos
		cuenta.Acceso(1234);
		cuenta.SacarDinero(200);
		System.out.println(cuenta.VisualizarCuenta());
		cuenta.Acceso(1234);
		cuenta.IngresarDinero(200);
		cuenta.Acceso(1234);
		System.out.println(cuenta.VisualizarCuenta());
		cuenta.Acceso(1234);
		System.out.println(cuenta.DatosCuenta());
		System.out.println(cuenta.TipoCuenta());
		System.out.println("el interes es de : "+cuenta.DevolverIntereses());
		System.out.println("");
		
		
		
		
		System.out.println("----------DEBITO(ping incorrecto)----------");
		//aqui verificamos que sin meter el ping correcto no deja actuar
		d.acceso(1234);
		d.sacaDinero(100);
		System.out.println("");
		System.out.println("----------DEBITO(ping correcto)----------");
		//aqui metemos el ping y probamos metodos de debito
		d.acceso(2131);
		d.sacaDinero(100);
		d.acceso(2131);
		System.out.println(d.saldoDisponible());
		d.acceso(2131);
		System.out.println(d.datosTarjeta());
		d.finDia();//este metodo hace que al final del dia su saldo diario se restablezca.
		d.acceso(2131);
		System.out.println(d.datosTarjeta());
		System.out.println("");
		
		
		
		System.out.println("----------CREDITO(ping incorrecto)----------");
		//aqui verificamos que sin meter el ping correcto no deja actuar
		credito.acceso(1234);
		credito.sacaDinero(100);
		System.out.println("");
		System.out.println("----------CREDITO(ping correcto)----------");
		//aqui metemos el ping y probamos metodos de credito
		credito.acceso(2131);
		credito.sacaDinero(100);
		credito.acceso(2131);
		System.out.println(credito.saldoDisponible());
		System.out.println(credito.datosTarjeta());
		credito.findemes();//este metodo hace que al final del mes su presupuesto mensual se restablezca y se cobre la factura a la cuenta.
		credito.acceso(2131);
		System.out.println(credito.datosTarjeta());
		System.out.println(credito.saldoDisponible());
		System.out.println("");
		
		
		
		System.out.println("----------MONEDERO(ping incorrecto)----------");
		//aqui verificamos que sin meter el ping correcto no deja actuar
		m.acceso(1234);
		m.sacaDinero(100);
		System.out.println("");
		System.out.println("----------MONEDERO(ping correcto)----------");
		//aqui metemos el ping y probamos metodos de monedero
		m.acceso(2131);
		System.out.println(m.saldoDisponible());
		m.acceso(2131);
		m.cargarMonedero(500);
		m.acceso(2131);
		m.sacaDinero(100);
		m.acceso(2131);
		System.out.println(m.saldoDisponible());
		m.acceso(2131);
		System.out.println(m.datosTarjeta());
	}

}
