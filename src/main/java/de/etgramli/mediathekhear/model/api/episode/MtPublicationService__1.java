package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtPublicationService__1(
        @JsonProperty("_links")
        Links__5 links,
        String brandingColor,
        String genre,
        String id,
        int numberOfElements,
        String organizationName,
        String title) {
}
