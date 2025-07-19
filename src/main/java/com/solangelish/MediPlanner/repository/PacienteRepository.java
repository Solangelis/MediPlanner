package com.solangelish.MediPlanner.repository;

import com.solangelish.MediPlanner.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    boolean existsByCpf(String cpf);
}
