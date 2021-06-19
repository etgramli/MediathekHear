
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Links__2(
        Self__2 self,
        @JsonProperty("mt:image")
        MtImage__1 mtImage,
        @JsonProperty("mt:onlinePortal")
        MtOnlinePortal mtOnlinePortal,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
