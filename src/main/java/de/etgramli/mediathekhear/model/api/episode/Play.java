package de.etgramli.mediathekhear.model.api.episode;

public record Play(
        String title,
        String chapter1,
        String chapter2,
        Sticky sticky,
        Autopilot autopilot,
        String mediaType,
        String lra,
        String channel,
        String show,
        String contentType,
        String source,
        String mediaDistributionType,
        String contentId,
        String publicationDate,
        String clipLength,
        String clipTitle) {
}
