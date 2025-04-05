package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor    // Criando um contrutor sem parametros com o Lombok
@AllArgsConstructor   // Criando um construtor com todos os argumentos com o Lombok
@Data                 // Criando todos os getters e setters com o Lombok
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManytoOne Um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key = Chave Estrangeira
    private MissaoModel missao;

}
