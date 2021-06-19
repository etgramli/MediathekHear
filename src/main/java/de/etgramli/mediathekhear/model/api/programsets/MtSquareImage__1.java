
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public record MtSquareImage__1(
        String href,
        String name,
        String title,
        boolean templated,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
