package RubyCraft.Bloques;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Bloque_de_Regeneracion extends Block {

	public Bloque_de_Regeneracion(Properties properties) {
		super(properties);
		
	}

	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		
    	if(entity instanceof PlayerEntity){

	
	   ((PlayerEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int)  200 , (int) 10));
    	}
	
	}
	
}
