package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtEditorialCategories__1(
        @JsonProperty("_links")
        Links__6 links,
        String id,
        String title) {
}
