package ink.ptms.cronus.builder.task.other;

import ink.ptms.cronus.builder.task.TaskEntry;
import ink.ptms.cronus.builder.task.data.text.TextKey;
import ink.ptms.cronus.builder.task.data.text.TextValue;
import ink.ptms.cronus.internal.QuestTask;
import ink.ptms.cronus.internal.task.other.TaskPlayerVal;
import ink.ptms.cronus.uranus.annotations.Auto;
import io.izzel.taboolib.util.item.ItemBuilder;
import io.izzel.taboolib.util.lite.Materials;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

/**
 * @Author 坏黑
 * @Since 2019-06-22 22:19
 */
@Auto
public class PlayerVal extends TaskEntry {

    public PlayerVal() {
        objective.add(TextKey.class);
        objective.add(TextValue.class);
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Materials.NAME_TAG.parseMaterial()).name("§f玩家永久变量").lore("", "§7点击选择").flags(ItemFlag.values()).build();
    }

    @Override
    public Class<? extends QuestTask> getTask() {
        return TaskPlayerVal.class;
    }
}
