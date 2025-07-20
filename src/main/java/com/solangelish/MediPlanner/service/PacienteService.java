package com.solangelish.MediPlanner.service;

import com.solangelish.MediPlanner.model.Paciente;
import com.solangelish.MediPlanner.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;


    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }


    public Paciente salvar(Paciente paciente) {
        if (repository.existsByCpf(paciente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }


    public boolean existsCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}