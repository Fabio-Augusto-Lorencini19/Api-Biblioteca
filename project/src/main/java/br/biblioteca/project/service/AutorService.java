package br.biblioteca.project.service;

import br.biblioteca.project.model.AutorEntity;
import br.biblioteca.project.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AutorEntity save(AutorEntity autorEntity) {
        return autorRepository.save(autorEntity);
    }

    public List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }

    public AutorEntity findById(Integer id) {
        return autorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public AutorEntity update(Integer id, AutorEntity autorEntity) {
        AutorEntity update = findById(id);

        if (autorEntity.getNome() != null && !autorEntity.getNome().isBlank()) {
            update.setNome(autorEntity.getNome());
        }

        if (autorEntity.getCpf() != null && !autorEntity.getCpf().isBlank()) {
            update.setCpf(autorEntity.getCpf());
        }

        if (autorEntity.getIdade() != null && !autorEntity.getIdade().isBlank()) {
            update.setIdade(autorEntity.getIdade());
        }

        return autorRepository.save(update);
    }

    public void delete(Integer id) {
        AutorEntity delete = findById(id);
        autorRepository.delete(delete);
    }
}