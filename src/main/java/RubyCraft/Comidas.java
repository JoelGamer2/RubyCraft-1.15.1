package RubyCraft;

import net.minecraft.item.Food;

public class Comidas {

	
	public static final Food pan_de_calabaza;
	public static final Food huevo_frito;
	public static final Food manzana_de_diamante;
	
	private static Food buildStew(int comida, float saturacion, boolean perro) {
		
		if(perro) {
		return (new Food.Builder().hunger(comida).saturation(saturacion).build());
		}else {
			return (new Food.Builder().hunger(comida).saturation(saturacion).meat().build());

		}
		
	}
	static {
		
		pan_de_calabaza = buildStew(10, 1.0F, false);
		huevo_frito = buildStew(5, 0.6F, true);
		manzana_de_diamante = buildStew(6, 1.0F, false);		
		
	}
	
}
