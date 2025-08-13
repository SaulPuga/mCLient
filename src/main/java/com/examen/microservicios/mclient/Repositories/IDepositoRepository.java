package com.examen.microservicios.mclient.Repositories;

import com.examen.microservicios.mclient.Models.DepositoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepositoRepository extends JpaRepository<DepositoModel, Long> {
}
