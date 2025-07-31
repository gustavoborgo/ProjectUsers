package br.com.gustavoborgo.projectusers.controller;
import br.com.gustavoborgo.projectusers.dto.UsuarioDTO;
import br.com.gustavoborgo.projectusers.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> ListarTodos() {
        return usuarioService.ListarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.inserir(usuarioDTO);
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.alterar(usuarioDTO);
    }

    // ex: http://endereco/usuario/3 -> parâmetro vem da url
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }




}
