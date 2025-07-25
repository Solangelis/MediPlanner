package com.solangelish.MediPlanner.controller;

import com.solangelish.MediPlanner.model.Consulta;
import com.solangelish.MediPlanner.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody @Valid Consulta consulta) {
        return ResponseEntity.ok(service.salvar(consulta));
    }


    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        return ResponseEntity.ok(service.listarTodas());
    }
}
