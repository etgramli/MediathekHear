package de.etgramli.mediathekhear.model.persistence;

import de.etgramli.mediathekhear.model.EpisodeDTO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "episode")
public class EpisodeEntity {
    @Id
    private long id;
    @Column(name = "DURATION")
    private int duration;
    @Column(name = "PUBLICATIONDATETIME")
    private LocalDateTime publicationDateTime;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Column(name = "PLAYBACKURL")
    private String playbackUrl;
    @Column(name = "DOWNLOADURL")
    private String downloadUrl;
    @Column(name = "SHARINGURL")
    private String sharingUrl;
    @Column(name = "SQUAREIMAGEURL")
    private String squareImageUrl;
    @Column(name = "DOWNLOADED")
    private boolean downloaded;
    @Column(name = "PROGRAMSET")
    private long programset;

    public EpisodeEntity() {
        this(-1, 0, LocalDateTime.MIN, "", "", "", "", "", "", false, -1);
    }

    public EpisodeEntity(final long id, final int duration, @Nonnull final LocalDateTime publicationDateTime,
                         @Nonnull final String title, @Nonnull final String synopsis, @Nonnull final String playbackUrl,
                         @Nonnull final String downloadUrl, @Nonnull final String sharingUrl,
                         @Nonnull final String squareImageUrl, final boolean downloaded, final long programset) {
        this.id = id;
        this.duration = duration;
        this.publicationDateTime = publicationDateTime;
        this.title = title;
        this.synopsis = synopsis;
        this.playbackUrl = playbackUrl;
        this.downloadUrl = downloadUrl;
        this.sharingUrl = sharingUrl;
        this.squareImageUrl = squareImageUrl;
        this.downloaded = downloaded;
        this.programset = programset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Nonnull
    public LocalDateTime getPublicationDateTime() {
        return publicationDateTime;
    }

    public void setPublicationDateTime(@Nonnull final LocalDateTime publicationDateTime) {
        this.publicationDateTime = publicationDateTime;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull final String title) {
        this.title = title;
    }

    @Nonnull
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(@Nonnull final String synopsis) {
        this.synopsis = synopsis;
    }

    @Nonnull
    public String getPlaybackUrl() {
        return playbackUrl;
    }

    public void setPlaybackUrl(@Nonnull final String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }

    @Nonnull
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(@Nonnull final String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Nonnull
    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(@Nonnull final String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    @Nonnull
    public String getSquareImageUrl() {
        return squareImageUrl;
    }

    public void setSquareImageUrl(@Nonnull final String squareImageUrl) {
        this.squareImageUrl = squareImageUrl;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public long getProgramset() {
        return programset;
    }

    public void setProgramset(long programset) {
        this.programset = programset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodeEntity that = (EpisodeEntity) o;
        return id == that.id && duration == that.duration && downloaded == that.downloaded && programset == that.programset && publicationDateTime.equals(that.publicationDateTime) && title.equals(that.title) && synopsis.equals(that.synopsis) && playbackUrl.equals(that.playbackUrl) && downloadUrl.equals(that.downloadUrl) && sharingUrl.equals(that.sharingUrl) && squareImageUrl.equals(that.squareImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, publicationDateTime, title, synopsis, playbackUrl, downloadUrl, sharingUrl, squareImageUrl, downloaded, programset);
    }

    @Contract("_ -> new")
    @NotNull
    public static EpisodeEntity of(@Nonnull final EpisodeDTO episodeDTO) {
        return new EpisodeEntity(episodeDTO.id(), episodeDTO.duration(), episodeDTO.publicationDateTime(),
                episodeDTO.title(), episodeDTO.synopsis(), episodeDTO.playbackUrl(), episodeDTO.downloadUrl(),
                episodeDTO.sharingUrl(), episodeDTO.squareImageUrl(), false, -1);
    }
}
