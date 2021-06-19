package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__5(
        Self__5 self,
        @JsonProperty("mt:image")
        MtImage__5 mtImage,
        @JsonProperty("mt:onlinePortal")
        MtOnlinePortal__1 mtOnlinePortal) {
}
