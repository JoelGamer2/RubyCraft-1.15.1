package RubyCraft.Items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class Manzana_de_diamante extends Item {

	public Manzana_de_diamante(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

@Override
public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
	
	
           entity.addPotionEffect(new EffectInstance(Effects.SPEED, 6000 , 10));
		   entity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 6000 , 1));
		   entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000 , 1));
		   entity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 6000 , 255));
		   entity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 6000 , 255));
		   entity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 6000 , 20));
		   entity.addPotionEffect(new EffectInstance(Effects.HASTE, 6000 , 10));
		   entity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 6000 , 255));
		   entity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 6000 , 255));

	
	
	return super.onItemUseFinish(stack, world, entity);
}
	
}
