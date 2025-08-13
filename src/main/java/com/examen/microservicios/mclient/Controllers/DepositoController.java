package com.examen.microservicios.mclient.Controllers;

import com.examen.microservicios.mclient.Models.CuentaModel;
import com.examen.microservicios.mclient.Models.DepositoModel;
import com.examen.microservicios.mclient.Models.DepositoRequestModel;
import com.examen.microservicios.mclient.Services.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepositoController {

    @Autowired
    DepositoService depositoService;

    @PostMapping("/deposito")
    public ResponseEntity<DepositoModel> deposito(@RequestBody DepositoRequestModel depositoRequestModel) throws Exception {
        return ResponseEntity.ok(this.depositoService.deposito(depositoRequestModel));
    }

    @PostMapping("/retiros")
    public ResponseEntity<DepositoModel> retiro(@RequestBody DepositoRequestModel depositoRequestModel) throws Exception {
        return ResponseEntity.ok(this.depositoService.retiro(depositoRequestModel));
    }
}
