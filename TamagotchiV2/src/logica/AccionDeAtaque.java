package logica;
import java.util.Random;


public class AccionDeAtaque extends AccionDosMascotas{
	private Random r = new Random();
	public AccionDeAtaque(double value, String desc) {
		super(value, desc);
	}
	@Override
	public boolean doAccion(Mascota m1, Mascota m2) {
		//false when died
		m1.resetContDesgaste();
		m1.resetContIndigestion();
		double c = r.nextDouble();
		if(c>getValue()){			
			c=r.nextDouble();
			if (m2.isValidEnergy(m2.getEnergy()-((double) Mascota.MAX_ENERGY * c))) {
				m2.setEnergy(m2.getEnergy() - ((double) Mascota.MAX_ENERGY * c));
				m2.setMood();
				return true;
			} else {
				m2.setEnergy(0);
				m2.setMood();
				return false;
			}
		}else{
			if (m1.isValidEnergy(m1.getEnergy()-((double) Mascota.MAX_ENERGY * c))) {
				m1.setEnergy(m1.getEnergy() - ((double) Mascota.MAX_ENERGY * c));
				m1.setMood();
				return true;
			} else {
				m1.setEnergy(0);
				m1.setMood();
				return false;
			}
		}
	}

}
