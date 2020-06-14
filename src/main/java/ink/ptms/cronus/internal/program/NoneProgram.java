package ink.ptms.cronus.internal.program;

import ink.ptms.cronus.database.data.DataQuest;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * @Author 坏黑
 * @Since 2019-05-26 22:38
 */
public class NoneProgram extends QuestProgram {

    private static final DataQuest GLOBAL = new DataQuest("null", "null");

    public NoneProgram(Player player) {
        super(player, GLOBAL);
    }

    public NoneProgram(Player player, Event event) {
        super(player, GLOBAL, event);
    }
}
