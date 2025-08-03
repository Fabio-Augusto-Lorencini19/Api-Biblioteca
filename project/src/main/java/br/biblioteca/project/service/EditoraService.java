package br.biblioteca.project.service;

import br.biblioteca.project.model.EditoraEntity;
import br.biblioteca.project.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public EditoraEntity save(EditoraEntity editoraEntity) {
        return editoraRepository.save(editoraEntity);
    }

    public List<EditoraEntity> findAll() {
        return editoraRepository.findAll();
    }

    public EditoraEntity findById(Integer id) {
        return editoraRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public EditoraEntity update(Integer id, EditoraEntity editoraEntity) {
        EditoraEntity update = findById(id);

        if (editoraEntity.getNome() != null && !editoraEntity.getNome().isBlank()) {
            update.setNome(editoraEntity.getNome());
        }

        if (editoraEntity.getEndereco() != null && !editoraEntity.getEndereco().isBlank()) {
            update.setEndereco(editoraEntity.getEndereco());
        }

        if (editoraEntity.getTelefone() != null && !editoraEntity.getTelefone().isBlank()) {
            update.setTelefone(editoraEntity.getTelefone());
        }

        return editoraRepository.save(update);
    }

    public void delete(Integer id) {
        EditoraEntity delete = findById(id);
        editoraRepository.delete(delete);
    }
}
