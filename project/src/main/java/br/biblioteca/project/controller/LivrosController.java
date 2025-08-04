package br.biblioteca.project.controller;

import br.biblioteca.project.model.LivrosEntity;
import br.biblioteca.project.service.LivrosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private final LivrosService livrosService;

    public LivrosController(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LivrosEntity>> findAll() {
        try {
            var result = livrosService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<LivrosEntity> findById(@PathVariable Integer id) {
        try {
            var result = livrosService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<LivrosEntity> save(@RequestBody LivrosEntity livrosEntity) {
        try {
            var result = livrosService.save(livrosEntity);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LivrosEntity> update(@PathVariable Integer id, @RequestBody LivrosEntity livrosUpdate) {
        try {
            var result = livrosService.update(id, livrosUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LivrosEntity> delete(@PathVariable Integer id) {
        try {
            livrosService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}