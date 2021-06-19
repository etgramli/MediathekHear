package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Embedded__1(
        @JsonProperty("mt:programSet")
        MtProgramSet mtProgramSet) {
}
