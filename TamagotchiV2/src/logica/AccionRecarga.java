package logica;
//deberia estar
public class AccionRecarga extends AccionUnaMascota {

	public AccionRecarga(double value, String desc) {
		super(value, desc);
	}

	@Override
	public boolean doAction(Mascota m) {
		// false sleep or died
		if (!m.isSleep()) {
			m.resetContDesgaste();
			m.addContIndigestion();
			if (m.getContIndigestion() > 6) {
				if (m.isValidEnergy(m.getEnergy()
						+ ((double) Mascota.MAX_ENERGY * getValue()))) {
					m.setEnergy(m.getEnergy()
							+ ((double) Mascota.MAX_ENERGY * getValue()));
					m.setMood();
					return true;
				} else {
					m.setEnergy(100);
					m.setMood();
					return true;
				}
			} else {
				m.setEnergy(0);
				m.setMood();
				return false;
			}
		} else {
			return false;
		}
	}

}
