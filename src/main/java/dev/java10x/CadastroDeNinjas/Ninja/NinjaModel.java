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
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "missao_id")  // Chave estrangeira da tabela Missao na table Ninja
    private MissaoModel missao;
}
