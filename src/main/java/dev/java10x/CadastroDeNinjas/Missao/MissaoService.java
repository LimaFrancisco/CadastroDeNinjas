package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Listar missões por ID
    public MissaoModel listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Criar missao
    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    // Deletar missao
    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    // Atualizar missao
    public MissaoModel alterarMissao(Long id, MissaoModel missaoAtualizada){
        if (missaoRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        }else{
            return null;
        }
    }
}
