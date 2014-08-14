package logica;

public abstract class Accion {
	private double value;
	private String desc;
	public static int index=0;
	private int i;
	public Accion(double value, String desc) {
		super();
		this.value = value;
		this.desc = desc;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
