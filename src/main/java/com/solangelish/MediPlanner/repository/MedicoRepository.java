package com.solangelish.MediPlanner.repository;

import com.solangelish.MediPlanner.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    boolean existsByCrm(String crm);
}
