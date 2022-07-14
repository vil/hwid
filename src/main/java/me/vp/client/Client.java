package me.vp.client;

import hwid.Hwid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
 *
 * @Author Vp (https://github.com/herravp)
 * Code is free to use :)
 *
 */
public class Client implements ModInitializer {
    public static MinecraftClient mc = MinecraftClient.getInstance();
    public static final Logger LOGGER = LoggerFactory.getLogger("larp");

    @Override
    public void onInitialize() {
        LOGGER.info("I love larping fr adsajdadhafgff");
    }

    // Init in MinecraftClientMixin.
    public static void init() {
        LOGGER.info("Validating HWID...");
        if (!Hwid.validateHwid()) {
            LOGGER.error("HWID not found!");
            System.exit(1);
        } else {
            LOGGER.info("HWID found!");
            try {
                Hwid.sendWebhook();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
