//
// Created by BONNe
// Copyright - 2024
//


package lv.id.bonne.vaulthunters.extrarules.mixin;


import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.UUID;

import iskallia.vault.config.VaultLevelsConfig;
import iskallia.vault.skill.PlayerVaultStats;
import lv.id.bonne.vaulthunters.extrarules.VaultHuntersExtraRules;
import lv.id.bonne.vaulthunters.extrarules.util.GameRuleHelper;
import net.minecraft.world.level.GameRules;


/**
 * This mixin changes how max level is requested. Instead of getting it from the config, it
 * takes value from the game rule.
 */
@Mixin(value = PlayerVaultStats.class, remap = false)
public class MixinPlayerVaultStats
{
    /**
     * UUID of player vault stats data.
     */
    @Shadow
    @Final
    private UUID uuid;


    /**
     * Changes max level for `getExpNeededToNextLevel` method.
     * @param instance The VaultConfig instance.
     * @return Max level from gamerule.
     */
    @Redirect(method = "getExpNeededToNextLevel",
        at = @At(value = "INVOKE", target = "Liskallia/vault/config/VaultLevelsConfig;getMaxLevel()I"))
    private int getExpNeededToNextLevelFromGameRule(VaultLevelsConfig instance)
    {
        GameRules.IntegerValue rule =
            GameRuleHelper.getRule(VaultHuntersExtraRules.MAX_PLAYER_LEVEL, uuid);

        return rule != null ? rule.get() : instance.getMaxLevel();
    }


    /**
     * Changes max level for `setVaultLevel` method.
     * @param instance The VaultConfig instance.
     * @return Max level from gamerule.
     */
    @Redirect(method = "setVaultLevel",
        at = @At(value = "INVOKE", target = "Liskallia/vault/config/VaultLevelsConfig;getMaxLevel()I"))
    private int setVaultLevelFromGameRule(VaultLevelsConfig instance)
    {
        GameRules.IntegerValue rule =
            GameRuleHelper.getRule(VaultHuntersExtraRules.MAX_PLAYER_LEVEL, uuid);

        return rule != null ? rule.get() : instance.getMaxLevel();
    }


    /**
     * Changes max level for `addVaultExp` method.
     * @param instance The VaultConfig instance.
     * @return Max level from gamerule.
     */
    @Redirect(method = "addVaultExp",
        at = @At(value = "INVOKE", target = "Liskallia/vault/config/VaultLevelsConfig;getMaxLevel()I"))
    private int addVaultExpFromGameRule(VaultLevelsConfig instance)
    {
        GameRules.IntegerValue rule =
            GameRuleHelper.getRule(VaultHuntersExtraRules.MAX_PLAYER_LEVEL, uuid);

        return rule != null ? rule.get() : instance.getMaxLevel();
    }
}
