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
    public ResponseEntity<Object> getCuentabyId(@PathVariable("id") Long id){
        if(cuentaService.getByid(id).isPresent()){
            return ResponseEntity.ok(this.cuentaService.getByid(id));
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path= "/cuenta/type/{tipoCuenta}")
    public ResponseEntity<Object> getCuentabyType(@PathVariable("tipoCuenta") String type){
        if(cuentaService.getByParam(type).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok(this.cuentaService.getByParam(type));
        }
    }

    @GetMapping(path= "/cuenta/status/{status}")
    public ResponseEntity<Object> getCuentabyStatus(@PathVariable("status") boolean status){
        if(cuentaService.getByStatus(status).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok(this.cuentaService.getByStatus(status));
        }
    }
}
