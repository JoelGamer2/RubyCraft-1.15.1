package RubyCraft.Items;

import RubyCraft.Lista.BloqueLista;
import RubyCraft.Lista.ItemLista;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Flecha_de_ruby extends Item {
   public Flecha_de_ruby(Item.Properties builder) {
      super(builder);
   }

 

      public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
         ArrowEntity arrowentity = new ArrowEntity(worldIn, shooter);
         arrowentity.setPotionEffect(stack);
         return arrowentity;
      }

      public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
         int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
         return enchant <= 0 ? false : this.getClass() == Flecha_de_ruby.class;
      }


   
}