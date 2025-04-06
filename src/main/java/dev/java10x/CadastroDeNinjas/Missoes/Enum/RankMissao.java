package dev.java10x.CadastroDeNinjas.Missoes.Enum;

public enum RankMissao {

    RANK_S("Rank S"),
    RANK_A("Rank A"),
    RANK_B("Rank B"),
    RANK_C("Rank C"),
    RANK_D("Rank D");

    private String descricao;

    RankMissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
