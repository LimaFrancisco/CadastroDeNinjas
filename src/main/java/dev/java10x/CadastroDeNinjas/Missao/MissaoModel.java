package dev.java10x.CadastroDeNinjas.Missao;

import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_missao")
@Data
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missao")
    @JoinColumn(name = "missao_id")
    private NinjaModel ninjas;
}
