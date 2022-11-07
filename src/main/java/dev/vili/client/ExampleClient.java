package dev.vili.client;

import hwid.Hwid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
 *
 * @Author Vili (https://github.com/v1li)
 * Code is free to use :)
 *
 */

/* Example client */
public class ExampleClient implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("example");

    @Override
    public void onInitialize() {
        LOGGER.info("Loaded.");
    }

    // Init in MinecraftClientMixin.
    public static void init() {
        // Validate hwid
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
