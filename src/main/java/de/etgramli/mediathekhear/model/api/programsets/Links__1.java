
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Links__1(
        Self__1 self,
        @JsonProperty("mt:image")
        MtImage mtImage,
        @JsonProperty("mt:sharing")
        MtSharing mtSharing,
        @JsonProperty("mt:squareImage")
        MtSquareImage mtSquareImage,
        @JsonProperty("mt:synd_rss")
        MtSyndRss mtSyndRss,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
