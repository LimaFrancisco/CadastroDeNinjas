package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // GET -- Manda uma requisição para listar as missões
    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return this.missaoService.listarMissoes();
    }

    // GET -- Manda uma requisição para listar as missões por Id
    @GetMapping("/listar/{Id}")
    public MissaoModel listarMissoesPorId(@PathVariable Long Id){
        return missaoService.listarMissoesPorId(Id);
    }

    // POST -- Manda uma requisição para criar uma missão
    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    // PUT -- Mandar uma missão para alterar(atualizar) uma missão
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // DELETE -- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
