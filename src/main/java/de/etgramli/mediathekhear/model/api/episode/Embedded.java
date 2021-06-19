package de.etgramli.mediathekhear.model.api.episode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Embedded (
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonProperty("mt:items")
    List<MtItem> mtItems,
    @JsonProperty("mt:publicationService")
    MtPublicationService__1 mtPublicationService,
    @JsonProperty("mt:editorialCategories")
    MtEditorialCategories__1 mtEditorialCategories) {
}
