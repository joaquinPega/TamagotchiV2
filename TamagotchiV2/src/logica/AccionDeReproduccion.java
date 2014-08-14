package logica;
public class AccionDeReproduccion extends AccionUnaMascota {

	public AccionDeReproduccion(double value, String desc) {
		super(value, desc);
	}

	public boolean doAction(Mascota m) {
		if (m.isCasado()) {
			if (m.getEnergy() > Mascota.MAX_ENERGY * 0.8 && m.getMood() == 5
					&& m.getPareja().getEnergy() > Mascota.MAX_ENERGY * 0.8
					&& m.getPareja().getMood() == 5) {
				Mascota j;
				j = new Mascota("Hd" + m.getName() + m.getPareja().getName()+m.getHijos().size());
				m.addHijos(j);
				m.getPareja().addHijos(j);
				m.resetContDesgaste();
				m.resetContIndigestion();
				return true;
			}else{
				return false;
			}
		} else {
			return false;
		}

	}

}
