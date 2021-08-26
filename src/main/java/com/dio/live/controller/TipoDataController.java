package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData createtipodata(@RequestBody TipoData tipoData){
        return tipoDataService.saveTipoData(tipoData);
    }

    @GetMapping
    public List<TipoData> gettipoDataList(){
        return tipoDataService.findAll();
    }

    @GetMapping("/{idtipoData}")
    public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        return ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(() -> new Exception("Tipo de Data não encontrada")));
    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable("idTipoData") Long idTipoData) throws Exception{
        tipoDataService.deleteTipoData(idTipoData);
        return new ResponseEntity<String>("Tipo de Data deletado com sucesso", HttpStatus.OK);
    }
}
