/*
package com.maisalae.shiningsapphires.world.dimensions;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

import com.maisalae.shiningsapphires.init.BiomeInit;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProviderSettings;
import net.minecraft.world.gen.SimplexNoiseGenerator;

public class SakuraBiomeProvider extends BiomeProvider {
    private final SimplexNoiseGenerator generator;
    private final SharedSeedRandom random;
    // eventually add other biomes here
    private static final Set<Biome> field_226853_f_ = ImmutableSet.of(BiomeInit.SKY_MEADOW.get());

    public SakuraBiomeProvider(EndBiomeProviderSettings settings) {
        super(field_226853_f_);
        this.random = new SharedSeedRandom(settings.getSeed());
        this.random.skip(17292);
        this.generator = new SimplexNoiseGenerator(this.random);
    }

    public Biome func_225526_b_(int xPos, int yPos, int zPos) {
        int i = xPos >> 2;
        int j = zPos >> 2;
        // if within 16 blocks in all directions of 0,0 then it's sky meadow
        if ((long)i * (long)i + (long)j * (long)j <= 256L) {
            return BiomeInit.SKY_MEADOW.get();
        } else {
            float f = this.calculateFloat(i * 2 + 1, j * 2 + 1);
            if (f > 40.0F) {
                return BiomeInit.SKY_MEADOW.get();
            } else if (f >= 0.0F) {
                // eventually change this to other biome
                return BiomeInit.SKY_MEADOW.get();
            } else {
                // eventually change these to two different biomes
                return f < -20.0F ? BiomeInit.SKY_MEADOW.get() : BiomeInit.SKY_MEADOW.get();
            }
        }
    }

    public float calculateFloat(int iIn, int jIn) {
        // currently position divided by two
        int i = iIn / 2;
        int j = jIn / 2;
        // modulus of 2 of current position
        int k = iIn % 2;
        int l = jIn % 2;
        // 100 - distance from 0,0 * 8
        float f = 100.0F - MathHelper.sqrt((float)(iIn * iIn + jIn * jIn)) * 8.0F;
        // clamps it between -100 and 80, so if its lower or higher it just gets set to the min/max respectively
        f = MathHelper.clamp(f, -100.0F, 80.0F);

        //looping from -12 to 12 in both x and z directions
        for(int i1 = -12; i1 <= 12; ++i1) {
            for(int j1 = -12; j1 <= 12; ++j1) {
                // currently position divided by 2 plus -12 to 12
                long k1 = (long)(i + i1);
                long l1 = (long)(j + j1);
                if (k1 * k1 + l1 * l1 > 4096L && this.generator.getValue((double)k1, (double)l1) < (double)-0.9F) {
                    float f1 = (MathHelper.abs((float)k1) * 3439.0F + MathHelper.abs((float)l1) * 147.0F) % 13.0F + 9.0F;
                    float f2 = (float)(k - i1 * 2);
                    float f3 = (float)(l - j1 * 2);
                    float f4 = 100.0F - MathHelper.sqrt(f2 * f2 + f3 * f3) * f1;
                    f4 = MathHelper.clamp(f4, -100.0F, 80.0F);
                    f = Math.max(f, f4);
                }
            }
        }
        return f;
    }
}

 */