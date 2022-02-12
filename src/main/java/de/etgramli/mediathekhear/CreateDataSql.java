package de.etgramli.mediathekhear;

import de.etgramli.mediathekhear.model.EpisodeDTO;
import de.etgramli.mediathekhear.model.ProgramsetsDTO;
import de.etgramli.mediathekhear.model.api.programsets.MtProgramSet;
import de.etgramli.mediathekhear.util.AudiothekUtils;
import org.apache.commons.cli.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public final class CreateDataSql {
    private CreateDataSql() {}

    private static final Logger logger = LoggerFactory.getLogger(CreateDataSql.class);

    /**
     * Help option to be used in own method.
     */
    private static final Option HELP_OPTION = Option.builder("h")
            .longOpt("help")
            .required(false)
            .hasArg(false)
            .desc("Prints this help text.")
            .build();

    public static void main(@Nonnull final String[] args) {
        final Options options = new Options();
        options.addOption(HELP_OPTION);
        options.addRequiredOption("o", "outputFile", true, "Target SQL to place entries in");
        options.addOption("e", "episodes", true, "Download all episodes of a certain programset with the given id.");
        options.addOption("E", "all-episodes", false, "Download all episodes of all programsets.");

        String outputFilePathString = "data.sql";
        boolean allEpisodes = false;
        long programsetId = -1;
        try {
            if (testForHelp(args)) {
                new HelpFormatter().printHelp("java -jar ApiTest.jar", "Save programsets and episodes to SQL file.", options, "", true);
                return;
            }
            final CommandLine cmd = new DefaultParser().parse(options, args);
            outputFilePathString = cmd.getOptionValue("o");
            allEpisodes = cmd.hasOption("E");
            if (cmd.hasOption("e")) {
                programsetId = Long.parseLong(cmd.getOptionValue("e"));
            }
        } catch (ParseException e) {
            logger.error("Error parsing command line arguments: ", e);
        }

        final StringBuilder dataSql = new StringBuilder();

        for (MtProgramSet programSet : AudiothekUtils.getProgramsets()) {
            final ProgramsetsDTO programsetsDTO = ProgramsetsDTO.of(programSet);
            dataSql.append(getProgramsetDbLine(programsetsDTO));

            final long currentId = programsetsDTO.id();
            if (allEpisodes || currentId == programsetId) {
                AudiothekUtils.getEpisodes(currentId).stream()
                        .map(EpisodeDTO::of)
                        .map(e -> getEpisodeDbLine(e, currentId))
                        .forEachOrdered(dataSql::append);
            }
        }

        try {
            final BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePathString));
            bw.write(dataSql.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean testForHelp(final String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption(HELP_OPTION);
        return new DefaultParser().parse(options, args, true).hasOption(HELP_OPTION.getOpt());
    }

    @NotNull
    private static String removeTabsAndNewlines(@Nonnull final String string) {
        return string.replaceAll("\\n", " ").replaceAll("\\t", " ");
    }

    @Nonnull
    private static String escapeSql(@Nonnull final String string) {
        return replaceSingleQuotesWithDoubleSingleQuotes(string);
    }

    @Nonnull
    private static String replaceSingleQuotesWithDoubleSingleQuotes(@Nonnull final String string) {
        return string.replaceAll("'", "''");
    }

    private static String getProgramsetDbLine(@Nonnull final ProgramsetsDTO programsets) {
        final String PROGRAMSET_LINE_PATTERN =
                "INSERT INTO programset" +
                " (id, numberOfElements, synopsis, title, organizationName, sharingUrl, imageUrl) VALUES" +
                " (%d, %d, '%s', '%s', '%s', '%s', '%s');" + System.lineSeparator();
        final String escapedTitle = escapeSql(removeTabsAndNewlines(programsets.title()));
        final String escapedSynopsis = escapeSql(removeTabsAndNewlines(programsets.synopsis()));
        return String.format(PROGRAMSET_LINE_PATTERN,
                programsets.id(),
                programsets.numberOfElements(),
                escapedSynopsis,
                escapedTitle,
                programsets.organizationName(),
                programsets.sharingUrl(),
                programsets.imageUrl());
    }

    private static String getEpisodeDbLine(@Nonnull final EpisodeDTO episode, final long programsetId) {
        final String EPISODE_LINE_PATTERN =
                "INSERT INTO episode" +
                " (id, duration, publicationDateTime, title, synopsis, playbackUrl, downloadUrl, sharingUrl, squareImageUrl, downloaded, programset)" +
                " VALUES" +
                " (%d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', 0, %d);" + System.lineSeparator();
        final String escapedTitle = escapeSql(removeTabsAndNewlines(episode.title()));
        final String escapedSynopsis = escapeSql(removeTabsAndNewlines(episode.synopsis()));
        return String.format(EPISODE_LINE_PATTERN,
                episode.id(),
                episode.duration(),
                episode.publicationDateTime().toString(),
                escapedTitle,
                escapedSynopsis,
                episode.playbackUrl(),
                episode.downloadUrl(),
                episode.sharingUrl(),
                episode.squareImageUrl(),
                programsetId);
    }

    private static void updateH2Programsets(@Nonnull final Collection<ProgramsetsDTO> programsets) {
        // ToDo: delete(also episodes) if programset does not exist in collection, add if it does not exist in db
    }
}
