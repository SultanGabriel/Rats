package com.github.alexthe666.rats.server.compat.jei.chef;

import com.github.alexthe666.rats.RatsMod;
import mezz.jei.api.gui.IDrawable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class ChefDrawable implements IDrawable {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("rats:textures/gui/chef_rat_jei.png");

    @Override
    public int getWidth() {
        return 176;
    }

    @Override
    public int getHeight() {
        return 120;
    }

    @Override
    public void draw(Minecraft minecraft, int xOffset, int yOffset) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(xOffset, yOffset, 3, 4, 170, 79);
        int scaledProgress = (minecraft.player.ticksExisted % 100) * 24 / 100;
        this.drawTexturedModalRect(71, 50, 176, 0, scaledProgress + 1, 16);
    }

    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)0).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + height), (double)0).tex((double)((float)(textureX + width) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + 0), (double)0).tex((double)((float)(textureX + width) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)0).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
        tessellator.draw();
    }
}