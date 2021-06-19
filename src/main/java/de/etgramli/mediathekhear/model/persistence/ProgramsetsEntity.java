package de.etgramli.mediathekhear.model.persistence;

import de.etgramli.mediathekhear.model.ProgramsetsDTO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "programset")
public class ProgramsetsEntity {
    @Id
    private long id;
    @Column(name = "NUMBEROFELEMENTS")
    private int numberOfElements;
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ORGANIZATIONNAME")
    private String organizationName;
    @Column(name = "SHARINGURL")
    private String sharingUrl;
    @Column(name = "IMAGEURL")
    private String imageUrl;

    public ProgramsetsEntity() {
        this(-1, -1, "", "", "", "", "");
    }

    public ProgramsetsEntity(final long id, final int numberOfElements, @Nonnull final String synopsis,
                             @Nonnull final String title, @Nonnull final String organizationName,
                             @Nonnull final String sharingUrl, @Nonnull final String imageUrl) {
        this.id = id;
        this.numberOfElements = numberOfElements;
        this.synopsis = synopsis;
        this.title = title;
        this.organizationName = organizationName;
        this.sharingUrl = sharingUrl;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Nonnull
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(@Nonnull final String synopsis) {
        this.synopsis = synopsis;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull final String title) {
        this.title = title;
    }

    @Nonnull
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(@Nonnull final String organizationName) {
        this.organizationName = organizationName;
    }

    @Nonnull
    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(@Nonnull final String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    @Nonnull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@Nonnull final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramsetsEntity that = (ProgramsetsEntity) o;
        return id == that.id && numberOfElements == that.numberOfElements && synopsis.equals(that.synopsis) && title.equals(that.title) && organizationName.equals(that.organizationName) && sharingUrl.equals(that.sharingUrl) && imageUrl.equals(that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfElements, synopsis, title, organizationName, sharingUrl, imageUrl);
    }

    @Contract("_ -> new")
    @NotNull
    public static ProgramsetsEntity of(@Nonnull final ProgramsetsDTO dto) {
        return new ProgramsetsEntity(dto.id(), dto.numberOfElements(), dto.synopsis(), dto.title(), dto.organizationName(),
                dto.sharingUrl(), dto.imageUrl());
    }
}
