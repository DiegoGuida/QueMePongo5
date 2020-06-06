//QueMePongo 5

public class Guardarropa{
	private String criterio; //podria ser un Enum en un futuro
	private List<Usuarie> compartirCon; //genera una doble relacion que a veces es compleja
	private List<Prenda> listaDePrendas;
	private List<Sugerencia> sugerenciasPendientes; 
//	private List<Sugerencia> sugerenciasAceptadas; //CLASE: tener la lista aca esta mal, ya que en el test ya tengo la referencia a la sugerencia

	public void aceptarSugerencia (Sugerencia sugerencia) {
	//recibo la sugerencia por parametro luego de que el usuario la haya elegido de la lista de sugerenciasPendientes
		sugerenciasPendientes.remove(sugerencia);
//		sugerenciasAceptadas.add (sugerencia);
		sugerencia.aceptar(this);
	}

	public void deshacerSugerenciaAceptada(Sugerencia sugerencia)) {
	//supongo que la recibo por parametro, desde la interfaz el usuario eligio deshacerla.
//		sugerenciaAceptadas.remove(sugerenca);
		sugerencia.deshacer(this);
	}

	public void agregarSugerenciaNuevaPrenda( Prenda prenda){ 
		sugerenciasPendientes.add ( new AgregarPrenda (prenda));
	}
	public void agregarSugerenciaQuitarPrenda( Prenda prenda){
		sugerenciasPendientes.add ( new QuitarPrenda ( prenda));
	}

	public void rechazarSugerencia(Sugerencia sugerencia){
		sugerenciasPendientes.remove (sugerencia);
	}
	public void	agregarPrenda(Prenda prenda) {
		listaDePrendas.add (prenda);
	}
	public void quitarPrenda(Prenda prenda, Sugerencia sugerencia){
		listaDePrendas.remove(prenda);
	}

}

public interface Sugerencia{
	aceptar();
	deshacer();//rechaza las sugerencias que se habian aceptado
}

public class AgregarPrenda implements Sugerencia {
	//private Guardarropa guardarropa; 	//no tiene sentido tener un Guardarropas como atributo
	private Prenda prenda;
	@Override
	aceptar(Guardarropa guardarropa){
		guardarropa.agregarPrenda(Prenda prenda);
	}
	@Override
	deshacer(Guardarropa guardarropa){ //rechaza las sugerencias que se habian aceptado
		guardarropa.quitarPrenda(Prenda prenda);
	}
}
public class QuitarPrenda implements Sugerencia {	
	//private Guardarropa guardarropa; 	//no tiene sentido tener un Guardarropas como atributo
	private Prenda prenda;
	@Override
	aceptar(Guardarropa guardarropa){
		guardarropa.quitarPrenda(Prenda prenda);
	}
	@Override
	deshacer(Guardarropa guardarropa){	//rechaza las sugerencias que se habian aceptado
		guardarropa.agregarPrenda(Prenda prenda);
	}
}


public class Usuarie{
	private String nombre;
	private List<Guardarropa> guardarropas;
	
}

public class Prenda{
	private TipoDePrenda tipoDePrenda;
	private Int temperaturaAdecuada;
	
}
