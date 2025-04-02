package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_missao")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankMissao dificuldade;

    // Uma missão vai ter vários ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissaoModel() {
    }

    public MissaoModel(List<NinjaModel>  ninjas, RankMissao dificuldade, String nome) {
        this.ninjas = ninjas;
        this.dificuldade = dificuldade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissao getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(RankMissao dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    public Long getId(){
        return this.id;
    }
}
