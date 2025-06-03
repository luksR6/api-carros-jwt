package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import br.com.senac.lucas.api_carros_jwt.entitys.Modelos;
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
    public ResponseEntity<List<Marcas>> carregar() {
        return null;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody Modelos modelos) {
        return null;
    }

    @PutMapping("atualizar")
    public ResponseEntity<Marcas> atualizar(@PathVariable Long id, @RequestBody Modelos modelo) {
        return null;
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody Long id) {
        return null;
    }
}
