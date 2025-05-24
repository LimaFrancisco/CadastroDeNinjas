package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoRepository missaoRepository;

    public MissaoController(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // POST -- Mandar uma requisição para criar uma missão
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }

    // GET -- Mandar uma requisição para listar as missões
    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }

    // PUT -- Mandar uma requisição para atualizar as missões
    @PutMapping("/alterar")
    public String alterarMissaoPorId(){
        return "Missao alterada com sucesso";
    }

    // DELETE -- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/delete")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }
}
