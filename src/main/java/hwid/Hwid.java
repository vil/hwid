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

/*
 *
 * @Author Vili (https://github.com/v1li)
 * Code is free to use :)
 *
 */
public class Hwid {
    public static boolean validateHwid() {
        String hwid = getHwid();
        /* Uncomment to get your hwid */
        //System.out.println(hwid);

        try {
            // replace the example with ur own url.
            // You can use raw GitHub links for example.
            URL url = new URL("https://example.com/hwid.json?hwid=" + hwid);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(hwid)) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Send a discord webhook when someone is logging in
    public static void sendWebhook() throws IOException {
        try {
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getHwid() {
        StringBuilder returnhwid = new StringBuilder();
        // You can make it even more secure, but I'll use this for example now.
        String hwid = System.getProperty("user.name") + System.getProperty("user.home") + System.getProperty("os.version") + System.getProperty("os.name");
        for (String s : StringUtil.getSubstrings(hwid)) {
            returnhwid.append(StringUtil.convertToString(s));
        }
        return returnhwid.toString();
    }

    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }
}