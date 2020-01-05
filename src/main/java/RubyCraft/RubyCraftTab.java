package RubyCraft;

import RubyCraft.Lista.ItemLista;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RubyCraftTab extends ItemGroup {

	public RubyCraftTab () {
		super(RubyCraft.modid);
		setBackgroundImageName("rubycraft.png");
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ItemLista.ruby);
	}
	
	
	@Override
	public boolean hasSearchBar() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
