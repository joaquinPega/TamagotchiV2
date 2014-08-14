package logica;
//deberia estar
public class AccionDesgaste extends AccionUnaMascota {

	public AccionDesgaste(double value, String desc) {
		super(value, desc);
	}

	@Override
	public boolean doAction(Mascota m) {
		// false sleep or died
		if (!m.isSleep()) {
			m.resetContIndigestion();
			m.addContDesgaste();
			if (m.getContDesgaste() < 4) {
				if (m.isValidEnergy(m.getEnergy()
						- ((double) Mascota.MAX_ENERGY * getValue()))) {
					m.setEnergy(m.getEnergy()
							- ((double) Mascota.MAX_ENERGY * getValue()));
					m.setMood();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
