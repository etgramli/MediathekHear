package de.etgramli.mediathekhear.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("programsetsRepo")
public interface ProgramsetsRepository extends JpaRepository<ProgramsetsEntity, Long> {
}
