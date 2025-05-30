package dev.java10x.CadastroDeNinjas.Missao;

import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private Set<NinjaModel> ninjas;

}
