package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Carros;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacException;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacNovaException;
import br.com.senac.lucas.api_carros_jwt.services.CarrosService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarrosService carrosService;

    @GetMapping("carregar")
    public ResponseEntity<List<Carros>> carregar() {
        try {
            return ResponseEntity.ok(carrosService.listarCarros());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("criar")
    public ResponseEntity<?> cadastrarCarros(@RequestBody Carros carro) {
        try {
            return ResponseEntity.ok(carrosService.criarCarros(carro));
        } catch (SenacException | SenacNovaException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("atualizar")
    public ResponseEntity<Carros> atualizarCarros(@PathVariable Long id, @RequestBody Carros carro) {
        try {
            return ResponseEntity.ok(carrosService.atualizarCarros(id, carro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluirCarros(@PathVariable Long id) {
        try {
            carrosService.excluirCarros(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/completo/criar")
    public ResponseEntity<?> completoCarros() {
        return null;
    }
}
