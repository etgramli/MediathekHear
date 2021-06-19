package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Programset(
        @JsonProperty("_links")
        Links links,
        String id,
        int numberOfElements,
        String synopsis,
        String title,
        Tracking tracking,
        @JsonProperty("_embedded")
        Embedded embedded) {
}
