package com.solangelish.MediPlanner.controller;

import com.solangelish.MediPlanner.model.Medico;
import com.solangelish.MediPlanner.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Medico> criarMedico(@RequestBody @Valid Medico medico) {
        return ResponseEntity.ok(service.salvar(medico));
    }


    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
