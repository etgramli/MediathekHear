
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public record MtPageHomescreen(
        String href,
        String name,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
