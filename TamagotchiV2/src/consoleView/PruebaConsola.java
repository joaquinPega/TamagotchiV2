package consoleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;








import logica.Accion;
import logica.AccionDosMascotas;
import logica.AccionUnaMascota;
import logica.Mascota;
import logica.PetManager;

public class PruebaConsola {
	public static void main(String[] args) {
		Map<String, Mascota> mascotas = new HashMap<String, Mascota>();
		ArrayList<Accion> acciones;
		Accion a=null;
 		PetManager manager=new PetManager();
		Mascota current=null,enemy=null;
		String s;
		int i=Integer.MAX_VALUE;
		boolean running=true,inMenu=true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al simulador Tamagotchi");
		while(running){
			System.out.println("Menu principal:");
			System.out.println("1: Crear mascota| 2: Borrar mascota| 3: Seleccionar mascota| 4: Casar dos mascotas| 5: mostrar mascotas| 6: salir");
			try{
				i = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				i= Integer.MAX_VALUE;
			}
			switch(i){
			case 1:
				System.out.println("Ingrese el nombre de la mascota a crear");
				s = sc.nextLine();
				mascotas.put(s, new Mascota(s));
				break;
			case 2:
				System.out.println("Ingrese el nombre de la mascota a borrar");
				s = sc.nextLine();
				if(mascotas.remove(s)==null){
					System.out.println("No se encontro la mascota");
				}else{
					System.out.println("Mascota borrada");
				}
				break;
			case 3:
				System.out.println("Ingrese el nombre de la mascota a seleccionar");
				s = sc.nextLine();
				current = mascotas.get(s);
				if(current != null){
					while(inMenu){
						//menu copado
						System.out.println("Menu mascota");
						System.out.println("Ingrese [exit] para salir| enter muestra acciones");
						if(sc.nextLine().equalsIgnoreCase("exit")){
							inMenu=false;
							break;
						}
						acciones =manager.getAcciones();
						for(Accion o : acciones){
							System.out.println("Opcion: "+o.getI()+ " descripcion: " + o.getDesc());
						}
						System.out.println("Ingrese opcion seleccionada");
						try{
							i = Integer.parseInt(sc.nextLine());
						}catch(NumberFormatException e){
							System.out.println("OPCION INCORRECTA (SAQUE AL MONO DEL TECLADO)");
							i = Integer.MAX_VALUE;
						}
						if(i<=acciones.size()){
							a= acciones.get(i);
						}else{
							a = null;
						}
						
						if(a instanceof AccionDosMascotas){
							//implementar sysos
							System.out.println("Ingrese el nombre de la segunda mascota:");
							s = sc.nextLine();
							enemy = mascotas.get(s);
							if(enemy==null){
								System.out.println("No se encontro la mascota");
							}else{
								if(manager.performAction(i, current,enemy )){
									System.out.println("La mascota realizo la accion:" + a.getDesc());
									System.out.println("Nombre: "+ current.getName()+"Humor: "+ current.getMood()+ " energia: "+ ((int)current.getEnergy()));
									System.out.println("Nombre: "+ enemy.getName()+"Humor: "+ enemy.getMood()+ " energia: "+ ((int)enemy.getEnergy()));
								}else{
									if(!current.isAlive(current.getEnergy())){
										System.out.println("La mascota: "+current.getName()+ " murio");
										mascotas.remove(current.getName());
									}else if(!enemy.isAlive(enemy.getEnergy())){
										System.out.println("La mascota: "+enemy.getName()+ " murio");
										mascotas.remove(enemy.getName());
									}else{
										System.out.println("No pudo realizar la accion "+ a.getDesc());
									}
								}
								
							}
							
						}else if(a instanceof AccionUnaMascota){
							if(manager.performAction(i, current)){
								System.out.println("La mascota: "+current.getName()+ " realizo: "+ a.getDesc());
								System.out.println("Humor: "+ current.getMood()+ " energia: "+ ((int)current.getEnergy()));
							}else{
								if(!current.isAlive(current.getEnergy())){
									System.out.println("Su mascota a partido al plano etereo");
									mascotas.remove(current.getName());
									inMenu=false;
								}else{
									System.out.println("No pudo realizar la accion: "+a.getDesc());
									
								}
							}
						}else{
							System.out.println("OPCION INCORRECTA");
						}
						
					}
				}else{
					System.out.println("No se encontro la mascota");
				}
				break;
			case 4:
				break;
			case 5: 
				for(Mascota m : mascotas.values()){
					System.out.println("Nombre: "+m.getName()+ " humor: "+ m.getMood()+ " casado: "+ m.isCasado());
				}
				break;
			case 6:
				System.out.println("Saliendo...");
				running=false;
				break;
				
			default:
				System.out.println("Opcion incorrecta");
				break;
			}			
		}
				
	}
}
