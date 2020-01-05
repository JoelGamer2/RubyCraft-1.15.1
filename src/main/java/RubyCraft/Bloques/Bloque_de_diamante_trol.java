package RubyCraft.Bloques;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Bloque_de_diamante_trol extends Block {

	  public static DamageSource Troleo = new DamageSource("Troleo").setDamageAllowedInCreativeMode();

	  protected static final VoxelShape field_196400_b = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	   protected static final VoxelShape field_196401_c = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	  /**Cosas Modificables por Addons
	   Addons Can Modify**/
	public static int Coordenaday = 256;
	public static int Coordenadax = 0;
	public static int Coordenadaz = 0;
	public static DamageSource MensajedeMuerte = Troleo;
	public static int Experiencia = 10;
	public static float Dano = 20.0F;
	public static float Dano_Inocentes = 26.0F;
	public static float Variable_y_multipladora = 3;
	
	/**Cosas no modificables por Addons
	   Addons can not Modify**/
	private final float  DanoTrol = 40.0F;
	private final float DanoNavidad = 0.5F;

	
	public Bloque_de_diamante_trol(Properties properties) {
		super(properties);
	}
	

	@Override
	   public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
	    player.setPosition(player.getPosition().getX() + Coordenadax, player.getPosition().getY() + Coordenaday, player.getPosition().getZ() + Coordenadaz);
	    player.addExperienceLevel(Experiencia);
	    world.setBlockState(pos, Blocks.LAVA.getDefaultState(), 2);
		if(!world.isRemote) {
		player.sendMessage(new TranslationTextComponent(TextFormatting.GOLD + player.getName().getString() + TextFormatting.RED + " Vas" + TextFormatting.BLUE + " a Morir " +  TextFormatting.GREEN + " xD "));
		}
	    return ActionResultType.SUCCESS;
	    
	   
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return field_196400_b;
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return field_196401_c;
	   }
	
	   
	   @Override
	public boolean ticksRandomly(BlockState state) {
		
		return true;
	}
	   
@Override
public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entity) {
	
	entity.attackEntityFrom(Troleo, Dano);
	
	
}
}
