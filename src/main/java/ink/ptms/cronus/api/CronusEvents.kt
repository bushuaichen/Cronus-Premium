package ink.ptms.cronus.api

import com.google.common.collect.Maps
import org.bukkit.plugin.Plugin

/**
 * @Author sky
 * @Since 2020-03-17 15:14
 */
@Suppress("UNCHECKED_CAST")
object CronusEvents {

    val listener = Maps.newConcurrentMap<String, MutableList<SingeListener>>()!!

    fun cancel(plugin: Plugin) {
        listener.remove(plugin.name)
    }

    fun <T> listen(plugin: Plugin, event: Class<out T>, listener: (T) -> Unit) {
        listen(plugin, event, 0, listener)
    }

    fun <T> listen(plugin: Plugin, event: Class<out T>, priority: Int, listener: (T) -> (Unit)) {
        CronusEvents.listener.computeIfAbsent(plugin.name) { ArrayList() }.run {
            this.add(SingeListener(priority, event) { listener.invoke(it as T) })
            this.sortBy { it.priority }
        }
    }

    fun <T> call(event: T): T {
        listener.values.flatten().filter { it.event.isInstance(event) }.forEach { it.listener.invoke(event!!) }
        return event
    }

    class SingeListener(val priority: Int, val event: Class<*>, val listener: (Any) -> (Any))
}