package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import br.com.senac.lucas.api_carros_jwt.entitys.Modelos;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacException;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacNovaException;
import br.com.senac.lucas.api_carros_jwt.services.ModelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ModelosController {

    @Autowired
    private ModelosService modelosService;

    @GetMapping("/carregar")
    public ResponseEntity<List<Modelos>> carregar() {
        try {
            return ResponseEntity.ok(modelosService.carregarModelos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody Modelos modelos) {
        try {
            return ResponseEntity.ok(modelosService.criarModelos(modelos));
        } catch (SenacException | SenacNovaException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("atualizar")
    public ResponseEntity<Modelos> atualizar(@PathVariable Long id, @RequestBody Modelos modelo) {
        try {
            return ResponseEntity.ok(modelosService.atualizarModelos(id, modelo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody Long id) {
        try {
            modelosService.excluirModelos(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
