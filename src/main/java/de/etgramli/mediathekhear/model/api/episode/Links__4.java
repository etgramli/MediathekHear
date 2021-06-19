package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__4(
        Self__4 self,
        @JsonProperty("mt:image")
        MtImage__4 mtImage,
        @JsonProperty("mt:squareImage")
        MtSquareImage__3 mtSquareImage){
}
