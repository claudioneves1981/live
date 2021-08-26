package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/bancohoras")
    public class BancoHorasController {

        @Autowired
        BancoHorasService bancoHorasService;

        @PostMapping
        public BancoHoras createbanco(@RequestBody BancoHoras bancoHoras) {
            return bancoHorasService.saveBanco(bancoHoras);
        }

    @GetMapping
    public List<BancoHoras> getBancoList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBanco}")
    public ResponseEntity<BancoHoras> getBancoByID(@PathVariable("idBanco") Long idBanco) throws Exception{
        return ResponseEntity.ok(bancoHorasService.getById(idBanco).orElseThrow(() -> new Exception("Banco de Horas não encontrada")));
    }

    @PutMapping
    public BancoHoras updateBanco(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBanco(bancoHoras);
    }

    @DeleteMapping("/{idBanco}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idBanco") Long idBanco) throws Exception{
        bancoHorasService.deleteBanco(idBanco);
        return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    }

    }
