package com.examen.microservicios.mclient.Services;

import com.examen.microservicios.mclient.Models.CuentaModel;
import com.examen.microservicios.mclient.Repositories.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    ICuentaRepository cuentaRepository;

    public CuentaModel saveCuenta(CuentaModel cuenta) throws Exception {
        if(validarCuenta(cuenta.getNumeroCuenta()) != null) {
            LocalDate fechaActual = LocalDate.now();
            cuenta.setFechaApertura(fechaActual);
            cuenta.setActiva(true);
            return cuentaRepository.save(cuenta);
        }else{
            throw new Exception("El numero de cuenta no es valido, revisar");
        }
    }

    public Optional<CuentaModel> getByid(Long id) {
        return cuentaRepository.findById(id);
    }

    public ArrayList<CuentaModel> getCuentas() {
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }

    public List<CuentaModel> getByParam(String param) {
        getCuentas();
        ArrayList<CuentaModel> cuentassEncontradas = new ArrayList<>();

        for (CuentaModel cuenta : getCuentas()) {
            if (cuenta.getTipoCuenta().equals(param)) {
                cuentassEncontradas.add(cuenta);
            }
        }
        return cuentassEncontradas;
    }

    public List<CuentaModel> getByStatus(boolean status) {
        getCuentas();
        ArrayList<CuentaModel> cuentassEncontradas = new ArrayList<>();

        for (CuentaModel cuenta : getCuentas()) {
            if (cuenta.isActiva() == status) {
                cuentassEncontradas.add(cuenta);
            }
        }
        return cuentassEncontradas;
    }

    public String validarCuenta(String numeroCuenta) {
        if (numeroCuenta.length() <= 11) {
            if (numeroCuenta.length() >= 3) {
                String primerasTres = numeroCuenta.substring(0, 3);
                boolean letrasValidas = true;
                for (char c : primerasTres.toCharArray()) {
                    if (!Character.isLetter(c)) {
                        letrasValidas = false;
                        break;
                    }
                }

                if (letrasValidas) {
                    String resto = numeroCuenta.substring(3);
                    boolean numerosValidos = true;
                    for (char c : resto.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            numerosValidos = false;
                            break;
                        }
                    }

                    if (numerosValidos) {
                        return numeroCuenta;
                    }
                }
            }
        }
        return null;
    }
}
