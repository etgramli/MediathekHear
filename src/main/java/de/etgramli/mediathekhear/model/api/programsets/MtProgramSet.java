
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record MtProgramSet(
        @JsonProperty("_links")
        Links__1 links,
        long id,
        int numberOfElements,
        String synopsis,
        String title,
        @JsonProperty("_embedded")
        Embedded__1 embedded,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
