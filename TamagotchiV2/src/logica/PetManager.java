package logica;
import java.util.ArrayList;


public class PetManager{
	private ArrayList<AccionUnaMascota> accionesUnaMascota = new ArrayList<AccionUnaMascota>();
	private ArrayList<AccionDosMascotas> accionesDosMascotas = new ArrayList<AccionDosMascotas>();
	private ArrayList<Accion> acciones = new ArrayList<Accion>();	
	
	public PetManager(){
		accionesUnaMascota.add(new AccionDesgaste(0.10,"Caminar"));		
		accionesUnaMascota.add(new AccionDesgaste(0.15,"Correr"));
		accionesUnaMascota.add(new AccionDesgaste(0.20,"Saltar"));
		accionesUnaMascota.add(new AccionRecarga(0.10,"Beber"));
		accionesUnaMascota.add(new AccionRecarga(0.15,"Comer"));
		accionesUnaMascota.add(new AccionDormir(0.25,"Dormir"));
		accionesUnaMascota.add(new AccionDormir("Despertar"));
		accionesDosMascotas.add(new AccionDeAtaque(0.25,"Atacar"));
		accionesDosMascotas.add(new AccionMatrimonial(1,"Casarse"));
		accionesDosMascotas.add(new AccionMatrimonial("Divorcio"));
		createMap();
	}
	
	private void createMap(){
		for(AccionUnaMascota a: accionesUnaMascota){
			acciones.add(a);
			a.setI(Accion.index++);
		}
		for(AccionDosMascotas a : accionesDosMascotas){
			acciones.add(a);
			a.setI(Accion.index++);
		}
	}
	public boolean performAction(int index, Mascota m1){
		return accionesUnaMascota.get(index).doAction(m1);
			
	}
	public boolean performAction(int index,Mascota m1, Mascota m2){
		return accionesDosMascotas.get(index-accionesUnaMascota.size()).doAccion(m1, m2);	
	}
	public ArrayList<Accion> getAcciones(){
		return acciones;
	}
}
