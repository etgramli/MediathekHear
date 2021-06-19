package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtProgramSet(
        @JsonProperty("_links")
        Links__2 links,
        String id,
        int numberOfElements,
        String synopsis,
        String title,
        @JsonProperty("_embedded")
        Embedded__2 embedded) {
}
