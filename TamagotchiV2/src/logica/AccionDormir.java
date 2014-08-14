package logica;
//deberia estar
public class AccionDormir extends AccionUnaMascota {
	private boolean despertar;

	public AccionDormir(double value, String desc) {
		super(value, desc);
		despertar = false;
	}

	public AccionDormir(String desc) {
		super(0, desc);
		despertar = true;
	}

	@Override
	public boolean doAction(Mascota m) {
		//false oposite
		if (despertar) {
			if (m.isSleep()) {
				m.resetContDesgaste();
				m.resetContIndigestion();
				m.setSleep(false);
				return true;
			} else {
				return false;
			}
		} else {
			if (m.isSleep()) {
				return false;
			} else {
				m.resetContDesgaste();
				m.resetContIndigestion();
				m.setSleep(true);
				if (m.isValidEnergy(m.getEnergy()
						+ ((double) Mascota.MAX_ENERGY * getValue()))) {
					m.setEnergy(m.getEnergy() + ((double) Mascota.MAX_ENERGY * getValue()));
					m.setMood();
				} else {
					m.setEnergy(100);
					m.setMood();
				}
				return true;
			}
		}
	}

}
