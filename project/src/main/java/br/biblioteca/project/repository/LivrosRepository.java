package br.biblioteca.project.repository;

import br.biblioteca.project.model.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosEntity, Integer> {
}