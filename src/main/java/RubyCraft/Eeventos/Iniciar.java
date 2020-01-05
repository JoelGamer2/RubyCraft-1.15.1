package RubyCraft.Eeventos;

import RubyCraft.Actualizaciones.TestearActualizaciones;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.SidedProvider;

public class Iniciar {

	public static void iniciar_eventos() {
		
		MinecraftForge.EVENT_BUS.register(new Eventos());
        MinecraftForge.EVENT_BUS.register(new TestearActualizaciones());
		
	}
	
}
