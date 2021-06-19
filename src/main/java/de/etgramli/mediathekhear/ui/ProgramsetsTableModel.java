package de.etgramli.mediathekhear.ui;

import de.etgramli.mediathekhear.model.ProgramsetsDTO;
import de.etgramli.mediathekhear.model.persistence.ProgramsetsEntity;
import de.etgramli.mediathekhear.model.persistence.ProgramsetsRepository;
import org.jetbrains.annotations.Nls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgramsetsTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Id", "Titel", "Anzahl Episoden", "Sender", "Zusammenfassung"};

    @Autowired
    private ProgramsetsRepository programsetsRepo;
    private List<Long> ids;

    @Override
    public int getRowCount() {
        if (ids == null) {
            ids = programsetsRepo.findAll().stream().map(ProgramsetsEntity::getId).collect(Collectors.toList());
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
        if (row >= ids.size()) {
            return null;
        }
        long id = ids.get(row);
        ProgramsetsDTO programset = programsetsRepo.findById(id).map(ProgramsetsDTO::of).orElse(ProgramsetsDTO.EMPTY);
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
