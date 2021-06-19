
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Links(
        Curies curies,
        Self self,
        @JsonProperty("mt:autopilot")
        MtAutopilot mtAutopilot,
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
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
