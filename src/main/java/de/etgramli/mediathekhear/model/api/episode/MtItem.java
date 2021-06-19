package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtItem(
        @JsonProperty("_links")
        Links__1 links,
        int duration,
        long id,
        String publicationStartDateAndTime,
        String synopsis,
        String title,
        Tracking__1 tracking,
        @JsonProperty("_embedded")
        Embedded__1 embedded) {
}
