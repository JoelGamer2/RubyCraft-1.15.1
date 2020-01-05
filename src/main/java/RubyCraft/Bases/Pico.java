package RubyCraft.Bases;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class Pico extends PickaxeItem
{
	public Pico(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
}