package RubyCraft.Items;

import java.util.function.Predicate;

import RubyCraft.Lista.ItemLista;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Arco_de_ruby extends ShootableItem {
   public Arco_de_ruby(Item.Properties builder) {
      super(builder);
      this.addPropertyOverride(new ResourceLocation("pull"), (p_210310_0_, p_210310_1_, p_210310_2_) -> {
         if (p_210310_2_ == null) {
            return 0.0F;
         } else {
            return !(p_210310_2_.getActiveItemStack().getItem() instanceof Arco_de_ruby) ? 0.0F : (float)(p_210310_0_.getUseDuration() - p_210310_2_.getItemInUseCount()) / 20.0F;
         }
      });
      this.addPropertyOverride(new ResourceLocation("pulling"), (_0, _1, _2) -> {
         return _2 != null && _2.isHandActive() && _2.getActiveItemStack() == _0 ? 1.0F : 0.0F;
      });
   }

   /**
    * Called when the player stops using an Item (stops holding the right mouse button).
    */
   public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
      if (entityLiving instanceof PlayerEntity) {
         PlayerEntity playerentity = (PlayerEntity)entityLiving;
         boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
         ItemStack itemstack = null;
        
         if(playerentity.inventory.hasItemStack(new ItemStack(ItemLista.Flecha_de_ruby))) {
        	 itemstack = new ItemStack(ItemLista.Flecha_de_ruby);
         }
         

         int i = this.getUseDuration(stack) - timeLeft;
         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
         if (i < 0) return;

        if (!itemstack.isEmpty() || flag) {
           if (itemstack.isEmpty()) {
               itemstack = new ItemStack(ItemLista.Flecha_de_ruby);
           }

            float f = getArrowVelocity(i);
            if (!((double)f < 0.1D)) {
               boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof Flecha_de_ruby && ((Flecha_de_ruby)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
               if (!worldIn.isRemote) {
            	   Flecha_de_ruby arrowitem = (Flecha_de_ruby)(itemstack.getItem() instanceof Flecha_de_ruby ? itemstack.getItem() : ItemLista.Flecha_de_ruby);
                  AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
                  abstractarrowentity = customeArrow(abstractarrowentity);
                  abstractarrowentity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                  abstractarrowentity.setDamage(90.0F);
                  if (f == 1.0F) {
                     abstractarrowentity.setIsCritical(true);
                  }

                  int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                  if (j > 0) {
                     abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + 0.5D);
                  }

                  int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                  if (k > 0) {
                     abstractarrowentity.setKnockbackStrength(k);
                  }

                  if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                     abstractarrowentity.setFire(100);
                  }

                  stack.damageItem(1, playerentity, (p_220009_1_) -> {
                     p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                  });
                  if (flag1 || playerentity.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                     abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                  }

                  worldIn.addEntity(abstractarrowentity);
               }

               worldIn.playSound((PlayerEntity)null, playerentity.func_226277_ct_(), playerentity.func_226278_cu_(), playerentity.func_226281_cx_(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
               flag1=false;
               if (!flag1 && !playerentity.abilities.isCreativeMode) {
            	   itemstack = new ItemStack(ItemLista.Flecha_de_ruby);
                  itemstack.shrink(1);
                  //playerentity.inventory.deleteStack(itemstack);
                  playerentity.inventory.deleteStack(itemstack);
               }

               playerentity.addStat(Stats.ITEM_USED.get(this));
             
            }
         }
      }
   }

   
   /**
    * Gets the velocity of the arrow entity from the bow's charge
    */
   public static float getArrowVelocity(int charge) {
      float f = (float)charge / 20.0F;
      f = (f * f + f * 2.0F) / 3.0F;
      if (f > 1.0F) {
         f = 1.0F;
      }

      return f;
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 72000;
   }

   /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public UseAction getUseAction(ItemStack stack) {
      return UseAction.BOW;
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	      ItemStack itemstack = playerIn.getHeldItem(handIn);

	   if(playerIn.inventory.hasItemStack(new ItemStack(ItemLista.Flecha_de_ruby))) {
      boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

      ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
      if (ret != null) return ret;

      
         playerIn.setActiveHand(handIn);
         playerIn.inventory.deleteStack(new ItemStack(ItemLista.Flecha_de_ruby));
         return ActionResult.func_226249_b_(itemstack);
         
	   }else {
		   return ActionResult.func_226251_d_(itemstack);
	   }
   }

   /**
    * Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
    */
   public Predicate<ItemStack> getInventoryAmmoPredicate() {
      return ARROWS;
   }

   public AbstractArrowEntity customeArrow(AbstractArrowEntity arrow) {
      return arrow;
   }
}