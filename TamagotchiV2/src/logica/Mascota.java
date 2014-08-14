package logica;
import java.util.ArrayList;


public class Mascota {
	private String name;
	private double energy;
	private byte mood;
	private boolean sleep;
	private boolean casado;
	private Mascota pareja;
	private ArrayList<Mascota> hijos = new ArrayList<Mascota>();
	public final static double MAX_ENERGY = 100;
	private int contDesgaste;
	private int contIndigestion;
	
	public Mascota(String name){
		this.name = name;
		this.energy=100;
		this.mood=5;
		this.sleep = false;
		this.contDesgaste=0;
		this.contIndigestion=0;
	}
	public void addContDesgaste(){
		contDesgaste++;
	}
	public void addContIndigestion(){
		contIndigestion++;
	}
	public void resetContDesgaste(){
		this.contDesgaste=0;
	}
	public void resetContIndigestion(){
		this.contIndigestion=0;
	}
	public int getContDesgaste(){
		return this.contDesgaste;
	}
	public int getContIndigestion(){
		return this.contIndigestion;
	}
	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public Mascota getPareja() {
		return pareja;
	}

	public void setPareja(Mascota pareja) {
		this.pareja = pareja;
	}
	public void addHijos(Mascota m){
		hijos.add(m);
	}
	public ArrayList<Mascota> getHijos() {
		return hijos;
	}

	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}

	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	public byte getMood() {
		return mood;
	}
	public void setMood(){
		this.mood = (byte)(this.energy/((double)MAX_ENERGY/5));
	}
	public void setMood(byte mood) {
		this.mood = mood;
	}
	public String getName() {
		return name;
	}

	public boolean isSleep() {
		return sleep;
	}

	public boolean isValidEnergy(double energy){
		return energy>=0 && energy <=100;
	}

	public boolean isAlive(double energy) {
		return energy >0;
	}

}
