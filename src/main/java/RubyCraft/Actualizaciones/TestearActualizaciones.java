package RubyCraft.Actualizaciones;

import net.minecraft.client.Minecraft;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TestearActualizaciones {

	private boolean Iniciadosesion = false;
	public static boolean Mensaje2a = true;
	public static boolean Mensaje3a = true;
	public static String UltimaVersion = "0";
	public static String Mensaje1 = "";
	public static String Mensaje2 = "";
	public static String Mensaje3 = "";

	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event){
		if(Buscar_Actualizaciones.HayNuevaVersion() && !Iniciadosesion && Minecraft.getInstance().currentScreen == null /**&& RubyCraftConfig.MensajeActualizacion == true**/&& !Buscar_Actualizaciones.URLNOVALIDAERROR){
			Minecraft.getInstance().player.playSound(SoundEvents.ITEM_TOTEM_USE, 1.0F , 1.0F);
			Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(TextFormatting.GRAY + "[" + TextFormatting.GREEN + "RubyCraft" + TextFormatting.GRAY + "] " + TextFormatting.GOLD + Minecraft.getInstance().player.getName().getString() + " Hay Una Nueva Version Disponible: " + TextFormatting.RED + UltimaVersion));
			Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(TextFormatting.GRAY + "[" + TextFormatting.GREEN + "RubyCraft" + TextFormatting.GRAY + "] " + TextFormatting.GOLD + Mensaje1));
			if(Mensaje2a == true){
			Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(TextFormatting.GRAY + "[" + TextFormatting.GREEN + "RubyCraft" + TextFormatting.GRAY + "] " + TextFormatting.GOLD + Mensaje2));
			}if(Mensaje3a == true){
			Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(TextFormatting.GRAY + "[" + TextFormatting.GREEN + "RubyCraft" + TextFormatting.GRAY + "] " + TextFormatting.GOLD + Mensaje3));
			}
			Iniciadosesion = true;
		
		}/**if(!Iniciadosesion && Minecraft.getInstance().currentScreen == null && Buscar_Actualizaciones.URLNOVALIDAERROR && !Control_de_Version.Version_de_desarrollador) {
			Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(TextFormatting.GRAY + "[" + TextFormatting.GREEN + "RubyCraft" + TextFormatting.GRAY + "] " + TextFormatting.GOLD + Minecraft.getInstance().player.getName() + " No se pudo encontrar actualizaciones " + TextFormatting.GOLD + "error de conexion" + TextFormatting.RED));
			Iniciadosesion = true;**/

		}
	
	
}
