package br.biblioteca.project.service;

import br.biblioteca.project.model.LivrosEntity;
import br.biblioteca.project.repository.LivrosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {

    private final LivrosRepository livrosRepository;
    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public LivrosEntity save(LivrosEntity livrosEntity) {
        return livrosRepository.save(livrosEntity);
    }

    public List<LivrosEntity> findAll() {
        return livrosRepository.findAll();
    }

    public LivrosEntity findById(Integer id) {
        return livrosRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public LivrosEntity update(Integer id, LivrosEntity livrosEntity) {
        LivrosEntity update = findById(id);

        if (livrosEntity.getISSN() != null && !livrosEntity.getISSN().isBlank()) {
            update.setISSN(livrosEntity.getISSN());
        }

        if (livrosEntity.getTitulo() != null && !livrosEntity.getTitulo().isBlank()) {
            update.setTitulo(livrosEntity.getTitulo());
        }

        if (livrosEntity.getSinopse() != null && !livrosEntity.getSinopse().isBlank()) {
            update.setSinopse(livrosEntity.getSinopse());
        }

        if (livrosEntity.getAno() != null && !livrosEntity.getAno().isBlank()) {
            update.setAno(livrosEntity.getAno());
        }

        if (livrosEntity.getNumPag() != null && !livrosEntity.getNumPag().isBlank()) {
            update.setNumPag(livrosEntity.getNumPag());
        }

        return livrosRepository.save(update);
    }

    public void delete(Integer id) {
        LivrosEntity delete = findById(id);
        livrosRepository.delete(delete);
    }
}