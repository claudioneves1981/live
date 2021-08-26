package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createusuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getusuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception{
        return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new Exception("usuario não encontrada")));
    }

    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idUsuario") Long idUsuario) throws Exception{
        usuarioService.deleteUsuario(idUsuario);
        return new ResponseEntity<String>("Usuario Deletado com sucesso", HttpStatus.OK);
    }
}
