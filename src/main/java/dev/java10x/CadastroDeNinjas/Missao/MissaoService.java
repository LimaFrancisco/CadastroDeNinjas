package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    // Injeção de dependencia
    private MissaoRepository missaoRepository;

    // Construtor
    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // Lista todas as missões cadastradas no banco
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }
}
