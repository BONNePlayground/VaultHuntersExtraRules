//
// Created by BONNe
// Copyright - 2024
//


package lv.id.bonne.vaulthuntersextrarules.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import iskallia.vault.core.vault.Vault;
import iskallia.vault.core.vault.player.Runner;
import iskallia.vault.core.vault.time.TickTimer;
import iskallia.vault.core.world.storage.VirtualWorld;
import iskallia.vault.init.ModItems;
import iskallia.vault.world.data.ServerVaults;
import lv.id.bonne.vaulthuntersextrarules.VaultHuntersExtraRules;
import lv.id.bonne.vaulthuntersextrarules.util.GameRuleHelper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;


/**
 * Mixin to allow using RESPEC_FLASK in the first room while timer is stopped.
 */
@Mixin(value = Runner.class, remap = false)
public class MixinRunner
{
    @Inject(method = "lambda$initServer$0",
        at = @At(value = "INVOKE", target = "net/minecraftforge/event/entity/player/PlayerInteractEvent.setCanceled(Z)V"),
        cancellable = true)
    private void overwriteBlackList(VirtualWorld world, PlayerInteractEvent event, CallbackInfo ci)
    {
        if (event.getItemStack().getItem() != ModItems.RESPEC_FLASK ||
            !GameRuleHelper.getRule(VaultHuntersExtraRules.USE_RESPEC_FLASK, event.getPlayer()).get())
        {
            // fast exit
            return;
        }

        ServerVaults.get(world).ifPresent(vault -> {
            if (vault.has(Vault.CLOCK))
            {
                if (vault.get(Vault.CLOCK).has(TickTimer.PAUSED))
                {
                    // Exit before value is changed to "Event#setCancel(true)"
                    ci.cancel();
                }
            }
        });
    }
}
