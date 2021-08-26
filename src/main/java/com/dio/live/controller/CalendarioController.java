package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createcalendario(@RequestBody Calendario calendario) {
        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendarioList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioByID(@PathVariable("idCalendario") Long idCalendario) throws Exception{
        return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new Exception("Calendario não encontrada")));
    }

    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario){
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idCalendario") Long idCalendario) throws Exception{
        calendarioService.deleteCalendario(idCalendario);
        return new ResponseEntity<String>("Calendario deletado com sucesso", HttpStatus.OK);
    }

}