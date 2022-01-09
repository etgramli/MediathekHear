package de.etgramli.mediathekhear.ui;

import de.etgramli.mediathekhear.model.ProgramsetsDTO;
import de.etgramli.mediathekhear.model.persistence.ProgramsetsRepository;
import org.jetbrains.annotations.Nls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;
import java.util.List;

@Component
public class ProgramsetsTableModel extends AbstractTableModel {
    private static final Logger logger = LoggerFactory.getLogger(ProgramsetsTableModel.class);
    private static final String[] COLUMN_NAMES = {"Id", "Titel", "Anzahl Episoden", "Sender", "Zusammenfassung"};

    @Autowired
    private ProgramsetsRepository repository;
    private List<ProgramsetsDTO> programsets;

    @Override
    public int getRowCount() {
        if (programsets == null) {
            programsets = repository.findAll().stream().map(ProgramsetsDTO::of).toList();
            logger.info(String.format("Queried %d programsets from repository.", programsets.size()));
        }
        return programsets.size();
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
            case 1, 3, 4 -> String.class;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(final int row, final int column) {
        return false;
    }

    @Override
    public Object getValueAt(final int row, final int column) {
        if (programsets == null) {
            programsets = repository.findAll().stream().map(ProgramsetsDTO::of).toList();
            logger.info(String.format("Queried %d programsets from repository.", programsets.size()));
        }
        final ProgramsetsDTO programset = programsets.get(row);
        return switch (column) {
            case 0 -> programset.id();
            case 2-> programset.numberOfElements();
            case 4 -> programset.synopsis();
            case 1 -> programset.title();
            case 3 -> programset.organizationName();
            default -> null;
        };
    }
}
