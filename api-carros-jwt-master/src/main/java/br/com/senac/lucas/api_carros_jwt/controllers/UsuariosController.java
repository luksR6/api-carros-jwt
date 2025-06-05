package br.com.senac.lucas.api_carros_jwt.controllers;

import br.com.senac.lucas.api_carros_jwt.controllers.dtos.UsuariosRequest;
import br.com.senac.lucas.api_carros_jwt.controllers.dtos.UsuariosResponse;
import br.com.senac.lucas.api_carros_jwt.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuariosResponse> cadastrarUsuarios(@RequestBody UsuariosRequest usuario) {
        try {
            return ResponseEntity.ok(usuariosService.criarUsuarios(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UsuariosResponse> login(@RequestBody UsuariosRequest usuarios) {
        try {
            return ResponseEntity.ok().body(usuariosService.login(usuarios));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

