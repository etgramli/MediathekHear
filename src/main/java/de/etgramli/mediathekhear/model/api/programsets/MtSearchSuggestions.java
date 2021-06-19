
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public record MtSearchSuggestions(
        String href,
        String name,
        boolean templated,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}