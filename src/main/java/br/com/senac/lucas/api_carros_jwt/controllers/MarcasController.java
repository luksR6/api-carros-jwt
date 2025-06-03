package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import br.com.senac.lucas.api_carros_jwt.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    private MarcasService marcasService;

    @GetMapping("/carregar")
    public ResponseEntity<List<Marcas>> carregar() {
        return null;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody Marcas marca) {
        return null;
    }

    @PutMapping("atualizar")
    public ResponseEntity<Marcas> atualizar(@PathVariable Long id,@RequestBody Marcas marca) {
        return null;
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody Long id) {
        return null;
    }
}
