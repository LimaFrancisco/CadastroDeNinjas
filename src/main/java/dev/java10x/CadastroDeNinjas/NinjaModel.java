package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cadastro")
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
}
