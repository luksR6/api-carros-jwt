package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacException;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacNovaException;
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
        try {
            return ResponseEntity.ok(marcasService.carregarMarcas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody Marcas marca) {
        try {
            return ResponseEntity.ok(marcasService.criarMarca(marca));
        } catch (SenacException | SenacNovaException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("atualizar")
    public ResponseEntity<Marcas> atualizar(@PathVariable Long id,@RequestBody Marcas marca) {
        try {
            return ResponseEntity.ok(marcasService.atualizarMarca(id, marca));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestBody Long id) {
        try {
            marcasService.excluirMarca(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
