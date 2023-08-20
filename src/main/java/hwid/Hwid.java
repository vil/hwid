/*
 * Copyright (c) 2023. Vili and contributors.
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 *  file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */

package hwid;

import hwid.util.*;
import net.minecraft.client.MinecraftClient;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hwid {

    /**
     * Validates the hwid
     * @return boolean
     */
    public static boolean validateHwid() {
        String hwid = getHwid();
        try {
            URL url = new URL("https://example.com/hwid.json?hwid=" + hwid);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(hwid)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sends the webhook
     * @throws IOException if the webhook url is invalid
     */
    public static void sendWebhook() throws IOException {
        // ur webhook url, if u even want to use webhook.
        Webhook webhook = new Webhook("");
        Webhook.EmbedObject embed = new Webhook.EmbedObject();
        // Embed content
        embed.setTitle("hwid");
        // Get current skin of the player and set it as the thumbnail
        embed.setThumbnail("https://crafatar.com/avatars/" + MinecraftClient.getInstance().getSession().getUuid() + "?size=128&overlay");
        embed.setDescription("New login - " + MinecraftClient.getInstance().getSession().getUsername());
        embed.setColor(Color.GRAY);
        embed.setFooter(getTime(), null);
        webhook.addEmbed(embed);

        if (validateHwid()) webhook.execute();
    }

    /**
     * Get the hwid
     * @return The hwid
     */
    public static String getHwid() {
        String hwid = System.getProperty("user.name") + System.getProperty("user.home") +
                      System.getProperty("os.version") + System.getProperty("os.name");
        return String.valueOf(StringUtil.convertToString(hwid));
    }

    /**
     * Get the current time
     * @return The current time
     */
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }
}