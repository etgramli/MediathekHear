package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links__1(
        Self__1 self,
        @JsonProperty("mt:bestQualityPlaybackUrl")
        MtBestQualityPlaybackUrl mtBestQualityPlaybackUrl,
        @JsonProperty("mt:downloadUrl")
        MtDownloadUrl mtDownloadUrl,
        @JsonProperty("mt:image")
        MtImage__1 mtImage,
        @JsonProperty("mt:mediaCollection")
        MtMediaCollection mtMediaCollection,
        @JsonProperty("mt:playCounting")
        MtPlayCounting mtPlayCounting,
        @JsonProperty("mt:sharing")
        MtSharing__1 mtSharing,
        @JsonProperty("mt:squareImage")
        MtSquareImage__1 mtSquareImage) {
}
