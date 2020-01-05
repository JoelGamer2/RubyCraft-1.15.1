package RubyCraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import RubyCraft.Lista.ItemLista;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("rc")
public class RubyCraft {

	public static RubyCraft instance;
	public static final String modid = "rc";
	private static final Logger logger = LogManager.getLogger("RubyCraft");
	
	public static final ItemGroup RubyCraftTab = new RubyCraftTab();
	public RubyCraft() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);

	}
	
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("INICIAO");
	}
	 
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("REGISTRAO");
	}
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrarEventos{
		@SubscribeEvent
	public static void RegistraItems(final RegistryEvent.Register<Item> event) {


		event.getRegistry().registerAll(
				
				ItemLista.ruby = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ruby")),
				ItemLista.colores = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("colores")),
				ItemLista.marcodelamuleto = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("marcodelamuleto")),
				ItemLista.zafiro = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("zafiro")),
				ItemLista.Plastico = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("plastico")),
				ItemLista.uranio = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("uranio")),
				ItemLista.amuleto = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("amuleto")),
				ItemLista.BoladeResina = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("boladeresina")),
				ItemLista.anillo = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("anillo")),
				ItemLista.Pepita_de_Ruby = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pepita_de_ruby")),
				ItemLista.Pepita_de_Zafiro = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pepita_de_zafiro")),
				ItemLista.palo_verde = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("palo_verde")),
				ItemLista.aluminio = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("aluminio")),
				ItemLista.cobre = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cobre")),
				ItemLista.molde_para_cofres = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("molde_para_cofres")),
				ItemLista.barra_de_aluminio = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("barra_de_aluminio")),
				ItemLista.varita = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("varita")),
				ItemLista.lingote_galactico = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("lingote_galactico")),
				ItemLista.platino = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("platino")),
				ItemLista.engranaje_de_diamante = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("engranaje_de_diamante")),
				ItemLista.pompa_de_imunidad = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pompa_de_imunidad")),
				ItemLista.anillo_angelico = new Item(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("anillo_angelico")),
				
		        ItemLista.pan_de_calabaza = new Item(new Item.Properties().group(RubyCraftTab).food(Comidas.pan_de_calabaza)).setRegistryName(location("pan_de_calabaza")),
		        ItemLista.huevo_frito = new Item(new Item.Properties().group(RubyCraftTab).food(Comidas.huevo_frito)).setRegistryName(location("huevo_frito")),
		        ItemLista.manzana_de_diamante = new Item(new Item.Properties().group(RubyCraftTab).food(Comidas.manzana_de_diamante)).setRegistryName(location("manzana_de_diamante"))



		
	);
		logger.info("Items registrados");
		
	}
	
		private static ResourceLocation location(String nombre) {
			return new ResourceLocation(modid,nombre);
		}
		
	}
	
}
