package logica;
public class AccionMatrimonial extends AccionDosMascotas {
	private boolean divorcio;

	public AccionMatrimonial(double value, String desc) {
		super(value, desc);
	}

	public AccionMatrimonial(String desc) {
		super(0, desc);
		divorcio = true;
	}

	@Override
	public boolean doAccion(Mascota m1, Mascota m2) {
		// false already married
		if (divorcio) {
			if(m1.isCasado()|| m2.isCasado()){
				if(m1.isCasado()){
					m1.setCasado(false);
					m1.getPareja().setCasado(false);
					return true;
				}else{
					m2.setCasado(false);
					m2.getPareja().setCasado(false);
					return true;
				}
			}else{
				return false;
			}
		}else{
			if (m1.isCasado() || m2.isCasado()) {
				return false;
			} else {
				m1.setCasado(true);
				m1.setPareja(m2);
				m2.setCasado(true);
				m2.setPareja(m1);
				return true;
			}
		}
	}

}
