package de.etgramli.mediathekhear.ui;

import de.etgramli.mediathekhear.model.EpisodeDTO;
import de.etgramli.mediathekhear.model.persistence.EpisodeEntity;
import de.etgramli.mediathekhear.model.persistence.EpisodeRepository;
import org.jetbrains.annotations.Nls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EpisodeTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Id", "Titel", "Dauer", "Veröffentlichung", "Zusammenfassung"};

    @Autowired
    private EpisodeRepository repository;
    private List<Long> ids;

    @Override
    public int getRowCount() {
        if (ids == null) {
            ids = repository.findAll().stream().map(EpisodeEntity::getId).collect(Collectors.toList());
        }
        return ids.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Nls
    @Override
    public String getColumnName(final int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(final int column) {
        return switch (column) {
            case 0 -> Long.class;
            case 2 -> Integer.class;
            case 3 -> LocalDateTime.class;
            case 1, 4 -> String.class;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(final int row, final int column) {
        return false;
    }

    @Override
    public Object getValueAt(final int row, final int column) {
        if (row >= ids.size()) {
            return null;
        }
        final long id = ids.get(row);
        EpisodeDTO episode = repository.findById(id).map(EpisodeDTO::of).orElse(EpisodeDTO.EMPTY);
        return switch (column) {
            case 0 -> episode.id();
            case 1 -> episode.title();
            case 2-> episode.duration();
            case 3 -> episode.publicationDateTime();
            case 4 -> episode.synopsis();
            default -> null;
        };
    }
}
