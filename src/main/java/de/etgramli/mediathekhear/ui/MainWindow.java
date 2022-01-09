package de.etgramli.mediathekhear.ui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

@Component
@SpringBootApplication
@EnableJpaRepositories("de.etgramli.mediathekhear.model.persistence")
public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;

    public MainWindow(@Autowired @Nonnull final ProgramsetsTableModel programsetsTableModel,
                      @Autowired @Nonnull final EpisodeTableModel episodeTableModel) {
        // Frame settings
        setTitle("MediathekHear");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar
        final JMenuBar menuBar = new JMenuBar();
        final JMenuItem reloadData = new JMenuItem("Daten aktualisieren");
        reloadData.addActionListener(e -> {throw new UnsupportedOperationException();});
        menuBar.add(reloadData);
        setJMenuBar(menuBar);

        // Main content
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Podcasts", getSortableTableInScrollPane(programsetsTableModel));
        tabbedPane.addTab("Episoden", getSortableTableInScrollPane(episodeTableModel));
        add(tabbedPane);
    }

    @Contract("_ -> new")
    @NotNull
    private static JScrollPane getSortableTableInScrollPane(@Nonnull final TableModel tableModel) {
        final JTable table = new JTable(tableModel);
        table.setRowSorter(new TableRowSorter<>(table.getModel()));
        table.setFillsViewportHeight(true);
        return new JScrollPane(table);
    }
}
