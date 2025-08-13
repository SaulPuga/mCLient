package com.examen.microservicios.mclient.Repositories;

import com.examen.microservicios.mclient.Models.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository <CuentaModel, Long>{
}
