
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Links__3(
        Self__3 self,
        @JsonProperty("mt:image")
        MtImage__2 mtImage,
        @JsonProperty("mt:squareImage")
        MtSquareImage__1 mtSquareImage,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
