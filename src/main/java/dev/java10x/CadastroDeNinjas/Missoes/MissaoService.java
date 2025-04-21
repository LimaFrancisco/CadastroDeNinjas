package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    // Injeção de dependencia
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // Listar todos as missões cadastradas no banco de dados
    public List<MissaoModel> listarMissoes(){
        return this.missaoRepository.findAll();
    }

    // Listar uma missão cadastrada no bando de dados pelo ID
    public MissaoModel listarMissoesPorId(Long Id){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(Id);
        return missaoModel.orElse(null);
    }

    // Cria uma missão e salvar no banco de dados
    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }
}
