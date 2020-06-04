//QueMePongo 5

public class Guardarropa{
	private String criterio; //podria ser un Enum en un futuro
	private List<Usuarie> compartirCon;
	private List<Prenda> listaDePrendas;
	private List<Sugerencia> sugerenciasPendientes; 
	private List<Sugerencia> sugerenciasAceptadas;

	public void aceptarSugerencia (Sugerencia sugerencia) {
	//recibo la sugerencia por parametro luego de que el usuario la haya elegido de la lista de sugerenciasPendientes
		sugerenciasPendientes.remove(sugerencia);
		sugerenciasAceptadas.add (sugerencia);
		sugerencia.aceptar();
	}

	public void deshacerSugerenciaAceptada(Sugerencia sugerencia)) {
	//supongo que la recibo por parametro, desde la interfaz el usuario eligio deshacerla.
		sugerenciaAceptadas.remove(sugerenca);
		sugerencia.deshacer();
	}

	public void agregarSugerenciaNuevaPrenda(Guardarropa guardarropa, Prenda prenda){ 
		sugerenciasPendientes.add ( new AgregarPrenda (guardarropa, prenda));
	}
	public void agregarSugerenciaQuitarPrenda(Guardarropa guardarropa, Prenda prenda){
		sugerenciasPendientes.add ( new QuitarPrenda (guardarropa, prenda));
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
	private Guardarropa guardarropa; 
	private Prenda prenda;
	@Override
	aceptar(){
		Guardarropa.agregarPrenda(Prenda prenda);
	}
	@Override
	deshacer(){ //rechaza las sugerencias que se habian aceptado
		Guardarropa.quitarPrenda(Prenda prenda);
	}
}
public class QuitarPrenda implements Sugerencia {	
	private Guardarropa guardarropa; 
	private Prenda prenda;
	@Override
	aceptar(){
		Guardarropa.quitarPrenda(Prenda prenda);
	}
	@Override
	deshacer(){	//rechaza las sugerencias que se habian aceptado
		Guardarropa.agregarPrenda(Prenda prenda);
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
