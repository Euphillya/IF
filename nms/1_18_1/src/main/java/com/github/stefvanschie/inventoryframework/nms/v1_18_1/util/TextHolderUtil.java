package com.github.stefvanschie.inventoryframework.nms.v1_18_1.util;

import com.github.stefvanschie.inventoryframework.adventuresupport.ComponentHolder;
import com.github.stefvanschie.inventoryframework.adventuresupport.StringHolder;
import com.github.stefvanschie.inventoryframework.adventuresupport.TextHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A utility class for adding {@link TextHolder} support.
 *
 * @since 0.10.4
 */
public final class TextHolderUtil {
    
    private TextHolderUtil() {
        //private constructor to prevent construction
    }
    
    /**
     * Converts the specified value to a vanilla component.
     *
     * @param holder the value to convert
     * @return the value as a vanilla component
     * @since 0.10.4
     */
    @NotNull
    @Contract(pure = true)
    public static Component toComponent(@NotNull TextHolder holder) {
        if (holder instanceof StringHolder) {
            return toComponent((StringHolder) holder);
        } else {
            return toComponent((ComponentHolder) holder);
        }
    }
    
    /**
     * Converts the specified legacy string holder to a vanilla component.
     *
     * @param holder the value to convert
     * @return the value as a vanilla component
     * @since 0.10.4
     */
    @NotNull
    @Contract(pure = true)
    private static Component toComponent(@NotNull StringHolder holder) {
        return new TextComponent(holder.asLegacyString());
    }
    
    /**
     * Converts the specified Adventure component holder to a vanilla component.
     *
     * @param holder the value to convert
     * @return the value as a vanilla component
     * @since 0.10.4
     */
    @NotNull
    @Contract(pure = true)
    private static Component toComponent(@NotNull ComponentHolder holder) {
        return Objects.requireNonNull(Component.Serializer.fromJson(holder.asJson()));
    }
}
