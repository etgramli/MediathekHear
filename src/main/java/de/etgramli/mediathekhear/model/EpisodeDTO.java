package de.etgramli.mediathekhear.model;

import de.etgramli.mediathekhear.model.api.episode.Links__1;
import de.etgramli.mediathekhear.model.api.episode.MtItem;
import de.etgramli.mediathekhear.model.persistence.EpisodeEntity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public record EpisodeDTO(
        long id,
        int duration,
        LocalDateTime publicationDateTime,
        String title,
        String synopsis,
        String playbackUrl,
        String downloadUrl,
        String sharingUrl,
        String squareImageUrl
) implements Comparable<EpisodeDTO> {
    private static final String DATE_TIME_FORMATTER_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER_STRING);

    public static final EpisodeDTO EMPTY = new EpisodeDTO(-1, 0, LocalDateTime.MIN, "","", "", "", "", "");

    @Contract("_ -> new")
    @NotNull
    public static EpisodeDTO of(@Nonnull final MtItem item) {
        final OffsetDateTime publicationDateTime =
                OffsetDateTime.parse(item.publicationStartDateAndTime(), DATE_TIME_FORMATTER);
        final Links__1 links = item.links();
        final String downloadUrl = links.mtDownloadUrl() == null ? "" : links.mtDownloadUrl().href();
        return new EpisodeDTO(
                item.id(),
                item.duration(),
                publicationDateTime.toLocalDateTime(),
                item.title(),
                item.synopsis(),
                links.mtBestQualityPlaybackUrl().href(),
                downloadUrl,
                links.mtSharing().href(),
                links.mtSquareImage().href());
    }

    @Contract("_ -> new")
    @NotNull
    public static EpisodeDTO of(@Nonnull final EpisodeEntity episodeEntity) {
        return new EpisodeDTO(episodeEntity.getId(), episodeEntity.getDuration(),
                episodeEntity.getPublicationDateTime(), episodeEntity.getTitle(), episodeEntity.getSynopsis(),
                episodeEntity.getPlaybackUrl(), episodeEntity.getDownloadUrl(), episodeEntity.getSharingUrl(),
                episodeEntity.getSquareImageUrl());
    }

    @Override
    public int compareTo(@NotNull final EpisodeDTO episodeDTO) {
        return Long.compare(this.id, episodeDTO.id);
    }
}
