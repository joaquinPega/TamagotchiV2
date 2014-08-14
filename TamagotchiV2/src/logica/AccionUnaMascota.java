package logica;

public abstract class AccionUnaMascota extends Accion{

	public AccionUnaMascota(double value, String desc) {
		super(value, desc);
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean doAction(Mascota m);

}
