package org.travelslog.brewnote.cupnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.cupnote.entity.CupNote;

public interface CupNoteRepository extends JpaRepository<CupNote, Long> {
}