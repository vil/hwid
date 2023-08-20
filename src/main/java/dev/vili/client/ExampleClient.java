/*
 * Copyright (c) 2023. Vili and contributors.
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 *  file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */

package dev.vili.client;

import hwid.Hwid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


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
