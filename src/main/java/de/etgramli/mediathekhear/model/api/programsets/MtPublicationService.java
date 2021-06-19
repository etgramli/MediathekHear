package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record MtPublicationService(
        @JsonProperty("_links")
        Links__2 links,
        String brandingColor,
        String genre,
        String id,
        int numberOfElements,
        String organizationName,
        String title,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
