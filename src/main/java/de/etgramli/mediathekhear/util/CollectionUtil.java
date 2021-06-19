package de.etgramli.mediathekhear.util;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Map;

public final class CollectionUtil {
    private CollectionUtil() {}

    public static @NotNull String printMap(@Nonnull final Map<String, String> map) {
        final int maxWidthLeftCol = StringUtil.maxLength(map.keySet());

        final StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            final String keyPadded = StringUtil.padRightWithSpaces(entry.getKey(), maxWidthLeftCol);
            sb.append(keyPadded)
                    .append("\t")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
