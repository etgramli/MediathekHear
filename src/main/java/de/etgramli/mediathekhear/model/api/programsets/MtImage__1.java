
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public record MtImage__1(
        String href,
        boolean templated,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
