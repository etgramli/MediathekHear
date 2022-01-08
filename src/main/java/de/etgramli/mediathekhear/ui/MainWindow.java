package de.etgramli.mediathekhear.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

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
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(podcastTable.getModel());
        sorter.setSortKeys(List.of(
                new RowSorter.SortKey(0, SortOrder.ASCENDING),
                new RowSorter.SortKey(1, SortOrder.DESCENDING)
        ));
        podcastTable.setRowSorter(sorter);

        final JScrollPane scrollPane = new JScrollPane(podcastTable);
        podcastTable.setFillsViewportHeight(true);
        add(scrollPane);
    }
}
