package com.solangelish.MediPlanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data e hora da consulta é obrigatória")
    private LocalDateTime dataHora;

    @NotBlank(message = "O motivo da consulta é obrigatório")
    private String motivo;

    private String observacoes;

    // Relação com Paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // Relação com Médico
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @JsonIgnoreProperties({"crm", "especialidade", "telefone"})
    private Medico medico;
}
