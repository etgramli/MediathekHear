package de.etgramli.mediathekhear.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

@Component
@SpringBootApplication
@EnableJpaRepositories("de.etgramli.mediathekhear.model.persistence")
public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;

    public MainWindow(@Autowired @Nonnull final EpisodeTableModel tableModel) {
        setTitle("MediathekHear");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final JTable podcastTable = new JTable(tableModel);
        podcastTable.setRowSorter(new TableRowSorter<>(podcastTable.getModel()));

        final JScrollPane scrollPane = new JScrollPane(podcastTable);
        podcastTable.setFillsViewportHeight(true);
        add(scrollPane);
    }
}
