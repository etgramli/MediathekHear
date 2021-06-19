package de.etgramli.mediathekhear.model;

import de.etgramli.mediathekhear.model.api.programsets.Links__1;
import de.etgramli.mediathekhear.model.api.programsets.MtProgramSet;
import de.etgramli.mediathekhear.model.api.programsets.MtPublicationService;
import de.etgramli.mediathekhear.model.persistence.ProgramsetsEntity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public record ProgramsetsDTO(
        long id,
        int numberOfElements,
        String synopsis,
        String title,
        String organizationName,
        String sharingUrl,
        String imageUrl) implements Comparable<ProgramsetsDTO> {

    public static final ProgramsetsDTO EMPTY = new ProgramsetsDTO(-1, -1, "", "", "", "", "");

    @Contract("_ -> new")
    @NotNull
    public static ProgramsetsDTO of(@Nonnull final MtProgramSet mtProgramSet) {
        final MtPublicationService publicationService = mtProgramSet.embedded().mtPublicationService();
        final Links__1 links = mtProgramSet.links();
        final String squareImageUrl = links.mtImage().href().replace("{ratio}", "1x1").replace("{width}", "512");
        return new ProgramsetsDTO(mtProgramSet.id(),
                                  mtProgramSet.numberOfElements(),
                                  mtProgramSet.synopsis(),
                                  mtProgramSet.title(),
                                  publicationService.organizationName(),
                                  squareImageUrl,
                                  links.mtSharing().href());
    }

    @Contract("_ -> new")
    @NotNull
    public static ProgramsetsDTO of(@Nonnull final ProgramsetsEntity dao) {
        return new ProgramsetsDTO(dao.getId(), dao.getNumberOfElements(), dao.getSynopsis(), dao.getTitle(),
                dao.getOrganizationName(), dao.getSharingUrl(), dao.getImageUrl());
    }

    @Override
    public int compareTo(@NotNull final ProgramsetsDTO programsetsDTO) {
        return Long.compare(this.id, programsetsDTO.id);
    }
}
