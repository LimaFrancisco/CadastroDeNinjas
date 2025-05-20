package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missao.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    @Column(unique = true)
    private String email;

    @ManyToOne
    private MissaoModel missoes;
}
