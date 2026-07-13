package com.pacome.joinleave.mixin;

import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerManager.class)
public class JoinPlayerManagerMixin {

    // Modification du message de connexion
    @Redirect(
            method = "onPlayerConnect",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/PlayerManager;broadcast(Lnet/minecraft/text/Text;Z)V"
            )
    )
    private void modifyJoinMessage(PlayerManager manager, Text text, boolean overlay) {

        manager.broadcast(
                Text.literal("§6Bienvenue sur le serveur !"),
                false
        );
    }
}