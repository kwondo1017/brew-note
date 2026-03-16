package org.travelslog.brewnote.cupnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.Bean;

public interface CupNoteRepository extends JpaRepository<Bean, Long> {
}