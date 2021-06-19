package de.etgramli.mediathekhear.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.etgramli.mediathekhear.model.api.episode.Embedded;
import de.etgramli.mediathekhear.model.api.episode.MtItem;
import de.etgramli.mediathekhear.model.api.episode.Programset;
import de.etgramli.mediathekhear.model.api.programsets.MtProgramSet;
import de.etgramli.mediathekhear.model.api.programsets.Programsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Methods for querying from the Ard Audiothek (REST) API.
 */
public final class AudiothekUtils {

    private static final Logger logger = LoggerFactory.getLogger(AudiothekUtils.class);
    public static final String PROGRAMSETS_BASE_URL = "https://api.ardaudiothek.de/programsets";
    private static Set<MtProgramSet> PROGRAMSETS;
    private static final Map<Long, List<MtItem>> EPISODES = new HashMap<>();


    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Default number of episodes to be fetched at once from the REST API.
     */
    private static final int MAX_NUMBER_OF_ELEMENTS_TO_FETCH = 50;

    @Nonnull
    @Unmodifiable
    public static Set<MtProgramSet> getProgramsets() {
        if (PROGRAMSETS == null) {
            logger.info("Querying program sets.");
            try {
                final URL programsetsUrl = new URL(PROGRAMSETS_BASE_URL);

                final Programsets programsets = MAPPER.readValue(programsetsUrl, Programsets.class);

                PROGRAMSETS = Set.copyOf(programsets.embedded().mtProgramSets());
            } catch (MalformedURLException e) {
                logger.error("Could not parse URL: ", e);
            } catch (IOException e) {
                logger.error("Could not parse JSON: ", e);
            }
        }
        return PROGRAMSETS;
    }

    private static final String URL_PATTERN_LIMIT = "%s/%d?limit=%d";
    @Nonnull
    @Unmodifiable
    public static List<MtItem> getEpisodes(final long id) {
        if (!EPISODES.containsKey(id)) {
            logger.info("Querying episodes for program set: " + id);
            try {
                final String urlWithParams = URL_PATTERN_LIMIT.formatted(PROGRAMSETS_BASE_URL, id, MAX_NUMBER_OF_ELEMENTS_TO_FETCH);
                final URL programsetUrl = new URL(urlWithParams);

                final Programset programset = MAPPER.readValue(programsetUrl, Programset.class);

                if (programset != null) {
                    final Embedded embedded = programset.embedded();
                    if (embedded != null) {
                        List<MtItem> items = embedded.mtItems();
                        if (items == null) {
                            logger.warn(String.format("Programset with id %d contained no episodes!", id));
                            items = Collections.emptyList();
                        }
                        EPISODES.put(id, List.copyOf(items));
                    }
                }
            } catch (MalformedURLException e) {
                logger.error("Could not parse URL: ", e);
                EPISODES.put(id, Collections.emptyList());
            } catch (IOException e) {
                logger.error("Could not parse JSON: ", e);
                EPISODES.put(id, Collections.emptyList());
            }
        }
        return EPISODES.get(id);
    }

    @NotNull
    public static LocalDateTime parseDate(@Nonnull final String dateString) {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}
