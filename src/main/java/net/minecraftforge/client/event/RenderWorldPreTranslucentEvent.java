/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.event;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.eventbus.api.Event;

/**
 * This event is called immediately before translucent blocks are rendered in the WorldRenderer class.
 * 
 * It is useful for rendering in a similar manner to RenderWorldLastEvent without the result being
 * invisible behind translucent blocks such as stained glass or water.
 * However, due to the nature of translucent block rendering, translucent blocks in the world
 * will be invisible behind anything translucent rendered from this event.
 */

public class RenderWorldPreTranslucentEvent extends Event
{
    private final WorldRenderer context;
    private final ActiveRenderInfo info;
    private final MatrixStack mat;
    private final IRenderTypeBuffer.Impl buffers;
    private final float partialTicks;
    private final Matrix4f projectionMatrix;
    private final long finishTimeNano;

    public RenderWorldPreTranslucentEvent(WorldRenderer context, ActiveRenderInfo info, MatrixStack mat, IRenderTypeBuffer.Impl buffers, float partialTicks, Matrix4f projectionMatrix, long finishTimeNano)
    {
        this.context = context;
        this.info = info;
        this.mat = mat;
        this.buffers = buffers;
        this.partialTicks = partialTicks;
        this.projectionMatrix = projectionMatrix;
        this.finishTimeNano = finishTimeNano;
    }

    public WorldRenderer getContext()
    {
        return context;
    }
    
    public ActiveRenderInfo getActiveRenderInfo()
    {
        return info;
    }

    public MatrixStack getMatrixStack()
    {
        return mat;
    }
    
    public IRenderTypeBuffer.Impl getRenderTypeBuffers()
    {
        return buffers;
    }

    public float getPartialTicks()
    {
        return partialTicks;
    }

    public Matrix4f getProjectionMatrix()
    {
        return projectionMatrix;
    }

    public long getFinishTimeNano()
    {
        return finishTimeNano;
    }
}