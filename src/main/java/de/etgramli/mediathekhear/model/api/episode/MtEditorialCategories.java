package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtEditorialCategories(
        @JsonProperty("_links")
        Links__4 links,
        String id,
        String title) {
}
