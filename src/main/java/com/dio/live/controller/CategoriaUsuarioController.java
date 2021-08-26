package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.CalendarioService;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createcategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.saveCategoria(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> getCategoriaByID(@PathVariable("idCategoria") Long idCategoria) throws Exception{
        return ResponseEntity.ok(categoriaUsuarioService.getById(idCategoria).orElseThrow(() -> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoria}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idCategoria") Long idCategoria) throws Exception{
        categoriaUsuarioService.deleteCategoriaUsuario(idCategoria);
        return new ResponseEntity<String>("Categoria deletada com sucesso", HttpStatus.OK);
    }

}