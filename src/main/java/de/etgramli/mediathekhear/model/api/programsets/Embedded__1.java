
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Embedded__1(
        @JsonProperty("mt:publicationService")
        MtPublicationService mtPublicationService,
        @JsonProperty("mt:editorialCategories")
        MtEditorialCategories mtEditorialCategories,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
