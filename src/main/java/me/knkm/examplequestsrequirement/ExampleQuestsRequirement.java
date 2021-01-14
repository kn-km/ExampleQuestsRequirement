package me.knkm.examplequestsrequirement;

import me.blackvein.quests.CustomRequirement;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.Map;

public class ExampleQuestsRequirement extends CustomRequirement {

    public ExampleQuestsRequirement(){
        this.setName("PapiRequire");
        this.setAuthor("test");
        this.addStringPrompt("papi", "the papi to check", null);
        this.addStringPrompt("operate", "equals, ==, >=, <= etc", null);
        this.addStringPrompt("another", "another to compare", null);
    }

    @Override
    public boolean testRequirement(Player player, Map<String, Object> map) {
        for (String s : map.keySet()) {
            if (map.get(s) ==null) return true;
        }
        // check requirement type
        if (((String) map.get("operate")).equalsIgnoreCase("equals")) {
            // papi parse
            String require = PlaceholderAPI.setPlaceholders(player, ((String) map.get("papi")));
            // check requirement
            if (require.equalsIgnoreCase(((String) map.get("another")))) {
                return true;
            }
        }
        return false;
    }
}
