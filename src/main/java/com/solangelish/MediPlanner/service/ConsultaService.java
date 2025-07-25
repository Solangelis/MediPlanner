package com.solangelish.MediPlanner.service;

import com.solangelish.MediPlanner.model.Consulta;
import com.solangelish.MediPlanner.model.Medico;
import com.solangelish.MediPlanner.model.Paciente;
import com.solangelish.MediPlanner.repository.ConsultaRepository;
import com.solangelish.MediPlanner.repository.MedicoRepository;
import com.solangelish.MediPlanner.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(ConsultaRepository repository,
                           PacienteRepository pacienteRepository,
                           MedicoRepository medicoRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }


    public Consulta salvar(Consulta consulta) {
        Paciente p = pacienteRepository.findById(consulta.getPaciente().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        Medico m = medicoRepository.findById(consulta.getMedico().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));

        consulta.setPaciente(p);
        consulta.setMedico(m);

        return repository.save(consulta);
    }


    public List<Consulta> listarTodas() {
        return repository.findAll();
    }
}
