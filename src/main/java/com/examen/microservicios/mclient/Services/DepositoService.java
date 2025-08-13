package com.examen.microservicios.mclient.Services;

import com.examen.microservicios.mclient.Models.CuentaModel;
import com.examen.microservicios.mclient.Models.DepositoModel;
import com.examen.microservicios.mclient.Models.DepositoRequestModel;
import com.examen.microservicios.mclient.Repositories.IDepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositoService {

    @Autowired
    IDepositoRepository depositoRepository;

    @Autowired
    CuentaService cuentaService;

    public DepositoModel deposito(DepositoRequestModel depositoRequestModel) throws Exception {
        DepositoModel depositoModel = new DepositoModel();

        for (CuentaModel cuenta : cuentaService.getCuentas()) {
            if (cuenta.getNumeroCuenta().equals(depositoRequestModel.getNumeroCuenta())) {
                if(cuenta.isActiva()) {
                    depositoModel.setNumeroCuenta(cuenta.getNumeroCuenta());
                    depositoModel.setSaldoAnterior(cuenta.getSaldoInicial());
                    depositoModel.setSaldoNuevo(cuenta.getSaldoInicial() + depositoRequestModel.getMonto());
                    depositoModel.setOperacion("DEPOSITO");
                    depositoModel.setMensaje("DEPOSITO REALIZADO CON EXITO");
                }else{
                    throw new Exception("La cuenta esta desactivada");
                }
        }else{
                throw new Exception("El numero de cuenta no es valido, revisar");
            }
    }
        return depositoModel;
    }
}
