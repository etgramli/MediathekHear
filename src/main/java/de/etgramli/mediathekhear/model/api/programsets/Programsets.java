
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Programsets(
        @JsonProperty("_links")
        Links links,
        String id,
        @JsonProperty("_embedded")
        Embedded embedded,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
