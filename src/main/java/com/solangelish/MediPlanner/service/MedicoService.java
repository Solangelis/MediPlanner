package com.solangelish.MediPlanner.service;

import com.solangelish.MediPlanner.model.Medico;
import com.solangelish.MediPlanner.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }


    public Medico salvar(Medico medico) {
        if (repository.existsByCrm(medico.getCrm())) {
            throw new IllegalArgumentException("CRM já cadastrado");
        }
        return repository.save(medico);
    }


    public List<Medico> listarTodos() {
        return repository.findAll();
    }
}
