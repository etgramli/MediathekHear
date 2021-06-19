package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MtPublicationService(
        @JsonProperty("_links")
        Links__3 links,
        String brandingColor,
        String genre,
        String id,
        int numberOfElements,
        String organizationName,
        String title) {
}
