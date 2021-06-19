
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record MtEditorialCategories(
        @JsonProperty("_links")
        Links__3 links,
        String id,
        String title,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
