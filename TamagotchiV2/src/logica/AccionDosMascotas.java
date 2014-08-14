package logica;

public abstract class AccionDosMascotas extends Accion{

	public AccionDosMascotas(double value, String desc) {
		super(value, desc);
		// TODO Auto-generated constructor stub
	}
	public abstract boolean doAccion(Mascota m1, Mascota m2);
}
