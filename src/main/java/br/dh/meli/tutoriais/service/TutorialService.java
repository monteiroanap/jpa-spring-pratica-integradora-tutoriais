package br.dh.meli.tutoriais.service;

import br.dh.meli.tutoriais.exception.InvalidParamException;
import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import br.dh.meli.tutoriais.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService implements ITutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public Tutorial insert(Tutorial tutorial) {
        if(tutorial == null) {
            throw new InvalidParamException("O tutorial nao pode ser nulo");
        }
        if(tutorial.getId() != null) {
            throw new InvalidParamException("O tutorial nao pode ter ID");
        }
        tutorial.setStatus(Status.DRAFT);
         return tutorialRepository.save(tutorial); //save: insere e atualiza no banco
    }

    @Override
    public List<Tutorial> getAll() {
        return null;
    }

    @Override
    public Optional<Tutorial> getbyId(Long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Tutorial updtate(Tutorial tutorial) {
        f(tutorial == null) {
            throw new InvalidParamException("O tutorial não pode ser nulo");
        }
        if(tutorial.getId() == null) {
            throw new InvalidParamException("O tutorial deve ter ID");
        }
        return tutorialRepository.save(tutorial);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Tutorial> getPublished() {
        return null;
    }

    @Override
    public List<Tutorial> getByTitle(String title) {
        return tutorialRepository.findTitleContaining(title);
    }
}
