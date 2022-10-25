package br.dh.meli.tutoriais.repository;

import br.dh.meli.tutoriais.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findTitleContaining(String title);
}
