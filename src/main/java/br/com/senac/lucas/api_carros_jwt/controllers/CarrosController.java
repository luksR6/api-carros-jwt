package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.entitys.Carros;
import br.com.senac.lucas.api_carros_jwt.services.CarrosService;
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
        return null;
    }

    @PostMapping("criar")
    public ResponseEntity<?> cadastrarCarros(@RequestBody Carros carro) {
        return null;
    }

    @PutMapping("atualizar")
    public ResponseEntity<CarrosController> atualizarCarros(@PathVariable Long id, @RequestBody Carros carro) {
        return null;
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluirCarros(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/completo/criar")
    public ResponseEntity<?> completoCarros() {
        return null;
    }
}
