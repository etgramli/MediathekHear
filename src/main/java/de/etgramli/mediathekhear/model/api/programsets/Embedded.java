
package de.etgramli.mediathekhear.model.api.programsets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record Embedded(
        @JsonProperty("mt:programSets")
        List<MtProgramSet> mtProgramSets,
        @JsonIgnore
        Map<String, Object> additionalProperties) {
}
