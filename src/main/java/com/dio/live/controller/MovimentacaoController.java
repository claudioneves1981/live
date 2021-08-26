package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createmovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getMovimentacaoByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception{
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new Exception("movimentação não encontrada")));
    }

    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception{
        movimentacaoService.deleteMovimentacao(idMovimentacao);
        return new ResponseEntity<String>("Movimentação deletada com sucesso", HttpStatus.OK);
    }

}
