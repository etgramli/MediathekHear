package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Embedded__2(
        @JsonProperty("mt:publicationService")
        MtPublicationService mtPublicationService,
        @JsonProperty("mt:editorialCategories")
        MtEditorialCategories mtEditorialCategories) {
}
