package br.biblioteca.project.repository;

import br.biblioteca.project.model.EditoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Integer> {
}
