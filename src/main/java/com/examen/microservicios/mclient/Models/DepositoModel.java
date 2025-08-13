package com.examen.microservicios.mclient.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "deposito")
@AllArgsConstructor
@NoArgsConstructor
public class DepositoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;
    private String numeroCuenta;
    private float saldoAnterior;
    private float saldoNuevo;
    private String operacion;
    private String mensaje;

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(float saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public float getSaldoNuevo() {
        return saldoNuevo;
    }

    public void setSaldoNuevo(float saldoNuevo) {
        this.saldoNuevo = saldoNuevo;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
