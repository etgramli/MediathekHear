package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Links(
        Curies curies,
        Self self,
        First first,
        Last last,
        @JsonProperty("mt:autopilot")
        MtAutopilot mtAutopilot,
        @JsonProperty("mt:image")
        MtImage mtImage,
        @JsonProperty("mt:orderingAsc")
        MtOrderingAsc mtOrderingAsc,
        @JsonProperty("mt:orderingDesc")
        MtOrderingDesc mtOrderingDesc,
        @JsonProperty("mt:pageEditorialCategories")
        MtPageEditorialCategories mtPageEditorialCategories,
        @JsonProperty("mt:pageHomescreen")
        MtPageHomescreen mtPageHomescreen,
        @JsonProperty("mt:pageOrganizations")
        MtPageOrganizations mtPageOrganizations,
        @JsonProperty("mt:search")
        MtSearch mtSearch,
        @JsonProperty("mt:searchSuggestions")
        MtSearchSuggestions mtSearchSuggestions,
        @JsonProperty("mt:sharing")
        MtSharing mtSharing,
        @JsonProperty("mt:squareImage")
        MtSquareImage mtSquareImage,
        @JsonProperty("mt:synd_atom")
        MtSyndAtom mtSyndAtom,
        @JsonProperty("mt:synd_rss")
        MtSyndRss mtSyndRss,
        Next next) {
}
