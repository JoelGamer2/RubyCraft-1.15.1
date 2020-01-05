package RubyCraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import RubyCraft.Actualizaciones.Buscar_Actualizaciones;
import RubyCraft.Bases.ArmorMaterialRubyCraft;
import RubyCraft.Bases.Hacha;
import RubyCraft.Bases.Pico;
import RubyCraft.Bases.ToolMaterialRubyCraft;
import RubyCraft.Bloques.Bloque_de_Regeneracion;
import RubyCraft.Bloques.Bloque_de_diamante_trol;
import RubyCraft.Bloques.Bloque_de_veneno;
import RubyCraft.Eeventos.Iniciar;
import RubyCraft.Items.Arco_de_ruby;
import RubyCraft.Items.Arco_de_zafiro;
import RubyCraft.Items.Manzana_de_diamante;
import RubyCraft.Lista.BloqueLista;
import RubyCraft.Lista.ItemLista;
import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
	public static String version = "1.0";
	public static final Logger logger = LogManager.getLogger("RubyCraft");
	
	public static final ItemGroup RubyCraftTab = new RubyCraftTab();
	public RubyCraft() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		Iniciar.iniciar_eventos();
		
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

			Buscar_Actualizaciones.MirarActualizaciones();
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

				//Comida
		        ItemLista.pan_de_calabaza = new Item(new Item.Properties().group(RubyCraftTab).food(Comidas.pan_de_calabaza)).setRegistryName(location("pan_de_calabaza")),
		        ItemLista.huevo_frito = new Item(new Item.Properties().group(RubyCraftTab).food(Comidas.huevo_frito)).setRegistryName(location("huevo_frito")),
		        ItemLista.manzana_de_diamante = new Manzana_de_diamante(new Item.Properties().group(RubyCraftTab).food(Comidas.manzana_de_diamante)).setRegistryName(location("manzana_de_diamante")),
		        
		        		
		        
		        //Heramientas
		        		ItemLista.hacha_de_ruby = new Hacha(ToolMaterialRubyCraft.HerramientaRuby, 6.0f, -3.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("hacha_de_ruby")),
		        		ItemLista.azada_de_ruby = new HoeItem(ToolMaterialRubyCraft.HerramientaRuby, 1.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("azada_de_ruby")),
		        		ItemLista.Pico_de_ruby = new Pico(ToolMaterialRubyCraft.HerramientaRuby, 1, 1.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pico_de_ruby")),
		        		ItemLista.pala_de_ruby = new ShovelItem(ToolMaterialRubyCraft.HerramientaRuby, 0.5f, -2.5f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pala_de_ruby")),
		    			ItemLista.espada_de_ruby = new SwordItem(ToolMaterialRubyCraft.HerramientaRuby, 7, -2.4f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("espada_de_ruby")),
		    			ItemLista.tijera_de_ruby = new ShearsItem(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("tijera_de_ruby")),
		    			ItemLista.arco_de_ruby = new Arco_de_ruby(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("arco_de_ruby")),
		    					
		    			ItemLista.hacha_de_zafiro = new Hacha(ToolMaterialRubyCraft.HerramientaZafiro, 6.0f, -3.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("hacha_de_zafiro")),
				        ItemLista.azada_de_zafiro = new HoeItem(ToolMaterialRubyCraft.HerramientaZafiro, 1.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("azada_de_zafiro")),
				        ItemLista.pico_de_zafiro = new Pico(ToolMaterialRubyCraft.HerramientaZafiro, 1, 1.0f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pico_de_zafiro")),
				        ItemLista.pala_de_zafiro = new ShovelItem(ToolMaterialRubyCraft.HerramientaZafiro, 0.5f, -2.5f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pala_de_zafiro")),
				    	ItemLista.espada_de_zafiro = new SwordItem(ToolMaterialRubyCraft.HerramientaZafiro, 7, -2.4f, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("espada_de_zafiro")),
				    	ItemLista.tijera_de_zafiro = new ShearsItem(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("tijera_de_zafiro")),
                        ItemLista.arco_de_zafiro= new Arco_de_zafiro(new Item.Properties().group(RubyCraftTab)).setRegistryName(location("arco_de_zafiro")),
				    	
				    	
				    	//Armaduras
				    	
				    	
				    	ItemLista.casco_de_ruby = new ArmorItem(ArmorMaterialRubyCraft.ruby, EquipmentSlotType.HEAD, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("casco_de_ruby")),
				    	ItemLista.pechera_de_ruby = new ArmorItem(ArmorMaterialRubyCraft.ruby, EquipmentSlotType.CHEST, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pechera_de_ruby")),
				    	ItemLista.grebas_de_ruby = new ArmorItem(ArmorMaterialRubyCraft.ruby, EquipmentSlotType.LEGS, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("grebas_de_ruby")),
				    	ItemLista.botas_de_ruby = new ArmorItem(ArmorMaterialRubyCraft.ruby, EquipmentSlotType.FEET, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("botas_de_ruby")),
				    	
				    	
				        ItemLista.casco_de_zafiro = new ArmorItem(ArmorMaterialRubyCraft.zafiro, EquipmentSlotType.HEAD, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("casco_de_zafiro")),
						ItemLista.pechera_de_zafiro = new ArmorItem(ArmorMaterialRubyCraft.zafiro, EquipmentSlotType.CHEST, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("pechera_de_zafiro")),
						ItemLista.grebas_de_zafiro = new ArmorItem(ArmorMaterialRubyCraft.zafiro, EquipmentSlotType.LEGS, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("grebas_de_zafiro")),
						ItemLista.botas_de_zafiro = new ArmorItem(ArmorMaterialRubyCraft.zafiro, EquipmentSlotType.FEET, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("botas_de_zafiro")),
		               //Bloque
		                ItemLista.bloque_de_ruby = new BlockItem(BloqueLista.bloque_de_ruby, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_ruby")),
	                    ItemLista.Ladrillo_Marino= new BlockItem(BloqueLista.Ladrillo_Marino, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillomarino")),
						ItemLista.Ladrillo_de_obsidiana= new BlockItem(BloqueLista.Ladrillo_de_obsidiana, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillodeobsidiana")),
						ItemLista.Bloqueluminiscente= new BlockItem(BloqueLista.Bloqueluminiscente, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloqueluminiscente")),
						ItemLista.Bloque_de_Zafiro= new BlockItem(BloqueLista.Bloque_de_Zafiro, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_zafiro")),
						ItemLista.Bloque_de_azucar= new BlockItem(BloqueLista.Bloque_de_azucar, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_azucar")),
						ItemLista.bloque_de_blaze= new BlockItem(BloqueLista.bloque_de_blaze, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_blaze")),
						ItemLista.Bloque_de_Diamante_Trol= new BlockItem(BloqueLista.Bloque_de_Diamante_Trol, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_diamante_trol")),
						ItemLista.Bloque_de_uranio= new BlockItem(BloqueLista.Bloque_de_uranio, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_uranio")),
						ItemLista.Ladrillo_del_Bosque= new BlockItem(BloqueLista.Ladrillo_del_Bosque, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillo_del_bosque")),
						ItemLista.Bloque_de_Regeneracion= new BlockItem(BloqueLista.Bloque_de_Regeneracion, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_regeneracion")),
						ItemLista.BloquedeEnderPearld= new BlockItem(BloqueLista.BloquedeEnderPearld, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloquedeenderpearld")),
						ItemLista.bloque_de_ojo_de_enderman= new BlockItem(BloqueLista.bloque_de_ojo_de_enderman, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_ojo_de_enderman")),
						ItemLista.Bloque_de_veneno= new BlockItem(BloqueLista.Bloque_de_veneno, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_veneno")),
						ItemLista.ladrillo_de_granito= new BlockItem(BloqueLista.ladrillo_de_granito, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillo_de_granito")),
						ItemLista.ladrillo_de_andesita= new BlockItem(BloqueLista.ladrillo_de_andesita, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillo_de_andesita")),
						ItemLista.ladrillo_de_diorita= new BlockItem(BloqueLista.ladrillo_de_diorita, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillo_de_diorita")),
						ItemLista.ladrillo_de_infiedra= new BlockItem(BloqueLista.ladrillo_de_infiedra, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("ladrillo_de_infiedra")),
						ItemLista.bloque_de_pedernal= new BlockItem(BloqueLista.bloque_de_pedernal, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_pedernal")),
						ItemLista.obsidiana_que_llora= new BlockItem(BloqueLista.obsidiana_que_llora, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("obsidiana_que_llora")),
						ItemLista.Cuarzo_azul= new BlockItem(BloqueLista.Cuarzo_azul, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cuarzo_azul")),
						ItemLista.Cuarzo_verde= new BlockItem(BloqueLista.Cuarzo_verde, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cuarzo_verde")),
						ItemLista.Cuarzo_rojo= new BlockItem(BloqueLista.Cuarzo_rojo, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cuarzo_rojo")),
						ItemLista.mena_de_ruby= new BlockItem(BloqueLista.mena_de_ruby, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mena_de_ruby")),
						ItemLista.mena_de_zafiro= new BlockItem(BloqueLista.mena_de_zafiro, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mena_de_zafiro")),
						ItemLista.mena_de_zafiro_end= new BlockItem(BloqueLista.mena_de_zafiro_end, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mena_de_zafiro_end")),
						ItemLista.mena_de_ruby_end= new BlockItem(BloqueLista.mena_de_ruby_end, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mena_de_ruby_end")),
						ItemLista.mesa_de_conjuraciones= new BlockItem(BloqueLista.mesa_de_conjuraciones, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mesa_de_conjuraciones")),
						ItemLista.bloque_de_cobre= new BlockItem(BloqueLista.bloque_de_cobre, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_cobre")),
						ItemLista.cristal_azul_claro= new BlockItem(BloqueLista.cristal_azul_claro, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cristal_azul_claro")),
						ItemLista.cristal_verde_lima= new BlockItem(BloqueLista.cristal_verde_lima, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("cristal_verde_lima")),
						ItemLista.bloque_de_caca= new BlockItem(BloqueLista.bloque_de_caca, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_caca")),
						ItemLista.mesa_de_zafiro_basica= new BlockItem(BloqueLista.mesa_de_zafiro_basica, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mesa_de_zafiro_basica")),
						ItemLista.mesa_de_zafiro= new BlockItem(BloqueLista.mesa_de_zafiro, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mesa_de_zafiro")),
						ItemLista.bloque_galactico= new BlockItem(BloqueLista.bloque_galactico, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_galactico")),
						ItemLista.calabaza_espectral= new BlockItem(BloqueLista.calabaza_espectral, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("calabaza_espectral")),
						ItemLista.bloque_reforzado_tier_1= new BlockItem(BloqueLista.bloque_reforzado_tier_1, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_reforzado_tier_1")),
						ItemLista.bloque_reforzado_tier_2= new BlockItem(BloqueLista.bloque_reforzado_tier_2, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_reforzado_tier_2")),
						ItemLista.bloque_reforzado_tier_3= new BlockItem(BloqueLista.bloque_reforzado_tier_3, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_reforzado_tier_3")),
						ItemLista.bloque_reforzado_tier_4= new BlockItem(BloqueLista.bloque_reforzado_tier_4, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_reforzado_tier_4")),
						ItemLista.bloque_reforzado_tier_5= new BlockItem(BloqueLista.bloque_reforzado_tier_5, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_reforzado_tier_5")),
						ItemLista.bloque_de_platino= new BlockItem(BloqueLista.bloque_de_platino, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_platino")),
						ItemLista.mena_de_platino= new BlockItem(BloqueLista.mena_de_platino, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("mena_de_platino")),
				    	ItemLista.bloque_de_actualizaciones= new BlockItem(BloqueLista.bloque_de_actualizaciones, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("bloque_de_actualizaciones")),
						ItemLista.prueba= new BlockItem(BloqueLista.prueba, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("prueba")),						
						ItemLista.tronco_azul= new BlockItem(BloqueLista.tronco_azul, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("tronco_azul")),
						ItemLista.tronco_verde= new BlockItem(BloqueLista.tronco_verde, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("tronco_verde")),
						ItemLista.madera_azul= new BlockItem(BloqueLista.madera_azul, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("madera_azul")),
						ItemLista.madera_verde= new BlockItem(BloqueLista.madera_verde, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("madera_verde")),
						ItemLista.minero= new BlockItem(BloqueLista.minero, new Item.Properties().group(RubyCraftTab)).setRegistryName(location("minero"))
										
						


		
	);
		logger.info("Items registrados");
		
	}
	
		
		@SubscribeEvent
		public static void RegistrarBloques(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					
					
			        BloqueLista.bloque_de_ruby = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_ruby")),
					BloqueLista.Ladrillo_Marino= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillomarino")),
					BloqueLista.Ladrillo_de_obsidiana= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillodeobsidiana")),
					BloqueLista.Bloqueluminiscente= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloqueluminiscente")),
					BloqueLista.Bloque_de_Zafiro= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_zafiro")),
					BloqueLista.Bloque_de_azucar= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_azucar")),
					BloqueLista.bloque_de_blaze= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_blaze")),
					BloqueLista.Bloque_de_Diamante_Trol= new Bloque_de_diamante_trol(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_diamante_trol")),
					BloqueLista.Bloque_de_uranio= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_uranio")),
					BloqueLista.Ladrillo_del_Bosque= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillo_del_bosque")),
					BloqueLista.Bloque_de_Regeneracion= new Bloque_de_Regeneracion(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_regeneracion")),
					BloqueLista.BloquedeEnderPearld= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloquedeenderpearld")),
					BloqueLista.bloque_de_ojo_de_enderman= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_ojo_de_enderman")),
					BloqueLista.Bloque_de_veneno= new Bloque_de_veneno(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_veneno")),
					BloqueLista.ladrillo_de_granito= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillo_de_granito")),
					BloqueLista.ladrillo_de_andesita= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillo_de_andesita")),
					BloqueLista.ladrillo_de_diorita= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillo_de_diorita")),
					BloqueLista.ladrillo_de_infiedra= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("ladrillo_de_infiedra")),
					BloqueLista.bloque_de_pedernal= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_pedernal")),
					BloqueLista.obsidiana_que_llora= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("obsidiana_que_llora")),
					BloqueLista.Cuarzo_azul= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("cuarzo_azul")),
					BloqueLista.Cuarzo_verde= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("cuarzo_verde")),
					BloqueLista.Cuarzo_rojo= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("cuarzo_rojo")),
					BloqueLista.mena_de_ruby= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mena_de_ruby")),
					BloqueLista.mena_de_zafiro= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mena_de_zafiro")),
					BloqueLista.mena_de_zafiro_end= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mena_de_zafiro_end")),
					BloqueLista.mena_de_ruby_end= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mena_de_ruby_end")),
					BloqueLista.mesa_de_conjuraciones= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mesa_de_conjuraciones")),
					BloqueLista.bloque_de_cobre= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_cobre")),
					BloqueLista.cristal_azul_claro= new GlassBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL).func_226896_b_()).setRegistryName(location("cristal_azul_claro")),
					BloqueLista.cristal_verde_lima= new GlassBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL).func_226896_b_()).setRegistryName(location("cristal_verde_lima")),
					BloqueLista.bloque_de_caca= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_caca")),
					BloqueLista.mesa_de_zafiro_basica= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mesa_de_zafiro_basica")),
					BloqueLista.mesa_de_zafiro= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mesa_de_zafiro")),
					BloqueLista.bloque_galactico= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_galactico")),
					BloqueLista.calabaza_espectral= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("calabaza_espectral")),
					BloqueLista.bloque_reforzado_tier_1= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_reforzado_tier_1")),
					BloqueLista.bloque_reforzado_tier_2= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_reforzado_tier_2")),
					BloqueLista.bloque_reforzado_tier_3= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_reforzado_tier_3")),
					BloqueLista.bloque_reforzado_tier_4= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_reforzado_tier_4")),
					BloqueLista.bloque_reforzado_tier_5= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_reforzado_tier_5")),
					BloqueLista.bloque_de_platino= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_platino")),
					BloqueLista.mena_de_platino= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("mena_de_platino")),
					BloqueLista.bloque_de_actualizaciones= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("bloque_de_actualizaciones")),
					BloqueLista.prueba= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("prueba")),
					BloqueLista.tronco_azul= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("tronco_azul")),
					BloqueLista.tronco_verde= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("tronco_verde")),
					BloqueLista.madera_azul= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("madera_azul")),
					BloqueLista.madera_verde= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("madera_verde")),
					BloqueLista.minero= new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.METAL)).setRegistryName(location("minero"))
			
			
					);
			
			logger.info("Bloques Registraos");

		}
		
		private static ResourceLocation location(String nombre) {
			return new ResourceLocation(modid,nombre);
		}
		
	}
	
}
