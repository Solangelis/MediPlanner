package com.solangelish.MediPlanner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;


    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;


    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;


    @Size(min = 8, max = 20, message = "O telefone deve ter entre 8 e 20 caracteres")
    private String telefone;


    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;
}
