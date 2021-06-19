package de.etgramli.mediathekhear;

import com.mpatric.mp3agic.*;
import de.etgramli.mediathekhear.model.EpisodeDTO;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;

public final class Downloader {
    private static final Logger logger = LoggerFactory.getLogger(Downloader.class);

    private final Path outputFolderPath;
    private final LinkedHashMap<Entry, Boolean> downloads;

    private record Entry(String url, String filename) {}

    public Downloader(@Nonnull final String outputFolderPathString) throws IOException {
        outputFolderPath = Path.of(outputFolderPathString);
        if (!Files.exists(outputFolderPath)) {
            Files.createDirectories(outputFolderPath);
        }
        downloads = new LinkedHashMap<>();
    }

    public void download(@Nonnull final EpisodeDTO episodeDTO) {
        final String filename =
                String.format("%d_-_%s.mp3", episodeDTO.id(), replaceInvalidCharacters(episodeDTO.title()));
        final Entry entry = new Entry(episodeDTO.downloadUrl(), filename);

        if (!downloads.containsKey(entry)) {
            downloads.put(entry, false);
            downloadFileFromUrl(entry.url, outputFolderPath + "/" + entry.filename);
            downloads.replace(entry, true);
        }
    }

    public void download(@Nonnull final Collection<EpisodeDTO> episodes) {
        episodes.forEach(this::download);
    }

    private static void downloadFileFromUrl(@Nonnull final String url, @Nonnull final String filePath) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(filePath));
        } catch (MalformedURLException e) {
            logger.error("Could not parse url from string: ", e);
        } catch (IOException e) {
            logger.error("Could not download url to file: ", e);
        }
    }

    @Contract(pure = true)
    public static @NotNull String replaceInvalidCharacters(@Nonnull final String fileName) {
        return fileName.replaceAll("[\\\\/:*?\"<>|]", "-");
    }

    private static void setCoverImage(@Nonnull final String filePath, @Nonnull final String imageUrlPath) {
        final String tempImageFilePath = "img.jpg";
        downloadFileFromUrl(imageUrlPath, tempImageFilePath);

        try {
            final byte[] imgBytes = Files.readAllBytes(new File(tempImageFilePath).toPath());
            final Mp3File mp3File = new Mp3File(filePath);
            if (!mp3File.hasId3v2Tag()) {
                mp3File.setId3v2Tag(new ID3v24Tag());
            }
            mp3File.getId3v2Tag().setAlbumImage(imgBytes, "Front Cover");
            mp3File.save(filePath);
        } catch (IOException e) {
            logger.error("Could not read image file: ", e);
        } catch (InvalidDataException e) {
            logger.error("Error reading mp3 file: ", e);
        } catch (UnsupportedTagException e) {
            logger.error("Wrong MP3 tag: ", e);
        } catch (NotSupportedException e) {
            e.printStackTrace();
        }
    }
}
