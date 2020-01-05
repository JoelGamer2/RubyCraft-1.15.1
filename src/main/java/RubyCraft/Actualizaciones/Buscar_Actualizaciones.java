package RubyCraft.Actualizaciones;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import RubyCraft.RubyCraft;

public class Buscar_Actualizaciones {

	private static final String Actualizacion_Url = "https://www.dropbox.com/s/fan0ya9zg5m10y9/RubyCraft-Updates.txt?raw=1";

	private static boolean NuevaVersion = false;
	public static boolean URLNOVALIDAERROR = false;
	
	public static void MirarActualizaciones(){
		new Thread("Actualizaciones"){
			
			public void run(){
				try {
					URL url = new URL(Actualizacion_Url);
					Scanner scanner = new Scanner(url.openStream());
					String Mensaje1 = scanner.nextLine();
					String Mensaje2 = scanner.nextLine();
					String Mensaje3 = scanner.nextLine();
					String Mensaje4 = scanner.nextLine();
					String Mensaje5 = scanner.nextLine();
					String Mensaje6 = scanner.nextLine();
					String Mensaje7 = scanner.nextLine();
					String Mensaje8 = scanner.nextLine();
					String Mensaje9 = scanner.nextLine();		
					String Mensaje10 = scanner.nextLine();
					String Mensaje11 = scanner.nextLine();		
					String Mensaje12 = scanner.nextLine();
					String Mensaje13 = scanner.nextLine();
					String Mensaje14 = scanner.nextLine();
					String Mensaje15 = scanner.nextLine();
					String Mensaje16 = scanner.nextLine();
					String Mensaje17 = scanner.nextLine();
					String Mensaje18 = scanner.nextLine();
					String Mensaje19 = scanner.nextLine();
					String Mensaje20 = scanner.nextLine();
					String Mensaje21 = scanner.nextLine();
					String Mensaje22 = scanner.nextLine();
					String Mensaje23 = scanner.nextLine();
					String Mensaje24 = scanner.nextLine();

					String UltimaVersion = scanner.nextLine();
					String Mensaje26 = scanner.nextLine();
					String Mensaje27= scanner.nextLine();
					String Mensaje28 = scanner.nextLine();
					scanner.close();
					if(!RubyCraft.version.equals(UltimaVersion) && !URLNOVALIDAERROR){
						RubyCraft.logger.info("============================================================");
						RubyCraft.logger.info(UltimaVersion + " Esta es la Ultima Version de RubyCraft Disponible");
						
						if(!Mensaje26.equals("")){
						RubyCraft.logger.info(Mensaje26);
						//bloque_de_actualizaciones.Mensaje1 = Mensaje26;

						TestearActualizaciones.Mensaje1 = Mensaje26;
						}if(!Mensaje27.equals("")){
							RubyCraft.logger.info(Mensaje27);
						//	bloque_de_actualizaciones.Mensaje2 = Mensaje27;
							TestearActualizaciones.Mensaje2 = Mensaje27;
						}else{
							TestearActualizaciones.Mensaje2a = false;
						}	
						if(!Mensaje28.equals("")){
							RubyCraft.logger.info(Mensaje28);
						//	bloque_de_actualizaciones.Mensaje3 = Mensaje28;
							TestearActualizaciones.Mensaje3 = Mensaje28;
							RubyCraft.logger.info("============================================================");
						}else{
							TestearActualizaciones.Mensaje3a = false;
						}
						if(Mensaje1.equals("") && Mensaje2.equals("") && Mensaje3.equals("")){			
							RubyCraft.logger.info("No hay cambios en actualizacion");
						//	bloque_de_actualizaciones.Mensaje1 = "No Hay Cambios en actualizacion";
							TestearActualizaciones.Mensaje1 = "No hay Cambios en actualizacion";
							RubyCraft.logger.info("============================================================");
						}
						
						TestearActualizaciones.UltimaVersion = UltimaVersion;
						FijarNuevaVersion();
					}
				} catch (MalformedURLException e) {
					URLNOVALIDAERROR = true;
					
				} catch (IOException e) {
					RubyCraft.logger.info("Error al buscar actualizaciones: " + e);
					URLNOVALIDAERROR = true;
				}
			}
			
		}.start();
	}
	
	public static synchronized void FijarNuevaVersion(){
		NuevaVersion = true;
	}
	
	public static synchronized boolean HayNuevaVersion(){
		return NuevaVersion;
	}

	
	 
	
	}
