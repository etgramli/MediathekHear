package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__2(
        Self__2 self,
        @JsonProperty("mt:image")
        MtImage__2 mtImage,
        @JsonProperty("mt:sharing")
        MtSharing__2 mtSharing,
        @JsonProperty("mt:squareImage")
        MtSquareImage__2 mtSquareImage,
        @JsonProperty("mt:synd_rss")
        MtSyndRss__1 mtSyndRss) {
}
