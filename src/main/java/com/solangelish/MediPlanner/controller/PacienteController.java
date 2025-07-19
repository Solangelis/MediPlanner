package com.solangelish.MediPlanner.controller;

import com.solangelish.MediPlanner.model.Paciente;
import com.solangelish.MediPlanner.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;


    public PacienteController(PacienteService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(service.salvar(paciente));
    }


    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}