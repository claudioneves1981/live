package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createlocalidade(@RequestBody Localidade localidade){
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping
    public List<Localidade> getLocalidadeList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception{
        return ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(() -> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idLocalidade") Long idLocalidade) throws Exception{
        localidadeService.deleteLocalidade(idLocalidade);
        return new ResponseEntity<String>("Localidade deletada com sucesso", HttpStatus.OK);
    }

}
