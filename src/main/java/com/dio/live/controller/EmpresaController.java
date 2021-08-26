package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createempresa(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception{
        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idEmpresa") Long idEmpresa) throws Exception{
        empresaService.deleteEmpresa(idEmpresa);
        return new ResponseEntity<String>("Empresa deletada com sucesso", HttpStatus.OK);
    }

}
