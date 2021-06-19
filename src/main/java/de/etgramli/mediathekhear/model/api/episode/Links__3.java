package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__3(
        Self__3 self,
        @JsonProperty("mt:image")
        MtImage__3 mtImage,
        @JsonProperty("mt:onlinePortal")
        MtOnlinePortal mtOnlinePortal) {
}
