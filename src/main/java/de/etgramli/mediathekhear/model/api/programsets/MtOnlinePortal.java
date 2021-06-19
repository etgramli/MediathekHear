
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public record MtOnlinePortal(
        String href,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
