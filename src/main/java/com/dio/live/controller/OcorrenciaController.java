package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia createocorrencia(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getocorrenciaList(){
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception{
        return ResponseEntity.ok(ocorrenciaService.getById(idOcorrencia).orElseThrow(() -> new Exception("ocorrencia não encontrada")));
    }

    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping("/{idOcorrencia}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception{
        ocorrenciaService.deleteOcorrencia(idOcorrencia);
        return new ResponseEntity<String>("Ocorrencia deletada com sucesso", HttpStatus.OK);
    }

}
