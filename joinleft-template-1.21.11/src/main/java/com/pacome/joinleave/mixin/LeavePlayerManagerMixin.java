package com.pacome.joinleave.mixin;

import net.minecraft.server.PlayerManager;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class LeavePlayerManagerMixin {

    @Inject(
            method = "broadcast(Lnet/minecraft/text/Text;Z)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void removeVanillaLeaveMessage(Text message, boolean overlay, CallbackInfo ci) {

        String msg = message.getString();

        if (msg.contains("left the game")) {
            ci.cancel();
        }
    }
}