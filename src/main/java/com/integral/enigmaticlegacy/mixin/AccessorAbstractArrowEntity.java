package com.integral.enigmaticlegacy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.projectile.AbstractArrowEntity;

@Mixin(AbstractArrowEntity.class)
public interface AccessorAbstractArrowEntity {

	@Invoker("func_213870_w")
	public abstract void clearHitEntities();

}