package com.examen.microservicios.mclient.Controllers;

import com.examen.microservicios.mclient.Models.CuentaModel;
import com.examen.microservicios.mclient.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @PostMapping("/crear")
    public ResponseEntity<CuentaModel> crearCuenta(@RequestBody CuentaModel cuenta) throws Exception {
        return ResponseEntity.ok(this.cuentaService.saveCuenta(cuenta));
    }

    @GetMapping(path= "/cuenta/{id}")
    public ResponseEntity<Object> getUserbyId(@PathVariable("id") Long id){
        if(cuentaService.getByParam(id).isPresent()){
            return ResponseEntity.ok(this.cuentaService.getByParam(id));
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
