package com.integral.enigmaticlegacy.gui;

import com.integral.enigmaticlegacy.EnigmaticLegacy;
import com.integral.enigmaticlegacy.handlers.SuperpositionHandler;
import com.integral.enigmaticlegacy.items.EnderRing;
import com.integral.enigmaticlegacy.items.MagnetRing;
import com.integral.enigmaticlegacy.objects.TransientPlayerData;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;

public class ToggleMagnetEffectsButton extends PlayerInventoryButton {

	public ToggleMagnetEffectsButton(AbstractContainerScreen<?> gui, int xIn, int yIn, int widthIn, int heightIn, int xTexStartIn, int yTexStartIn, int yDiffTextIn, ResourceLocation resourceLocationIn, OnPress onPressIn) {
		super(gui, xIn, yIn, widthIn, heightIn, xTexStartIn, yTexStartIn, yDiffTextIn, resourceLocationIn, onPressIn);
	}

	@Override
	protected boolean beforeRender(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
		boolean hasRing = SuperpositionHandler.hasCurio(Minecraft.getInstance().player, EnigmaticLegacy.magnetRing) || SuperpositionHandler.hasCurio(Minecraft.getInstance().player, EnigmaticLegacy.superMagnetRing);

		if (!hasRing || !MagnetRing.inventoryButtonEnabled.getValue()) {
			this.active = false;
			return false;
		} else {
			TransientPlayerData data = TransientPlayerData.get(Minecraft.getInstance().player);
			if (data.getDisabledMagnetRingEffects()) {
				this.xTexStart = 42;
			} else {
				this.xTexStart = 21;
			}
			return true;
		}
	}

	@Override
	public Tuple<Integer, Integer> getOffsets(boolean creative) {
		int x = creative ? 147 + MagnetRing.buttonOffsetXCreative.getValue() : 127 + MagnetRing.buttonOffsetX.getValue();
		int y = creative ? 5 + MagnetRing.buttonOffsetYCreative.getValue() : 61 + MagnetRing.buttonOffsetY.getValue();

		return new Tuple<>(x, y);
	}

}
