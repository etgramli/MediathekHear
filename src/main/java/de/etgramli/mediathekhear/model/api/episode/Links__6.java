package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__6(
        Self__6 self,
        @JsonProperty("mt:image")
        MtImage__6 mtImage,
        @JsonProperty("mt:squareImage")
        MtSquareImage__4 mtSquareImage) {
}
