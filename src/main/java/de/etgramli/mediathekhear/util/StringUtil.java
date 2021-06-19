package de.etgramli.mediathekhear.util;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

public final class StringUtil {
    private StringUtil() {}

    @NotNull
    public static String padRightWithSpaces(@Nonnull final String string, final int newLength) {
        if (string.length() >= newLength) {
            return string;
        }
        final int numWhitespaces = newLength - string.length();
        return string + " ".repeat(numWhitespaces);
    }

    public static int maxLength(@Nonnull final Collection<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static List<Integer> maxLengths(@Nonnull final Collection<Collection<String>> strings) {
        return strings.stream()
                .map(StringUtil::maxLength)
                .toList();
    }
}
