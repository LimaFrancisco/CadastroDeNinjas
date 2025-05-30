package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // POST -- Mandar uma requisição para criar uma missão
    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao){
        return missaoService.criarMissao(missao);
    }

    // GET -- Mandar uma requisição para listar as missões
    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorID(@PathVariable Long id){
        return missaoService.listarMissaoPorId(id);
    }

    // PUT -- Mandar uma requisição para atualizar as missões
    @PutMapping("/alterar/{id}")
    public MissaoModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissaoModel missaoAtualizada){
        return missaoService.alterarMissao(id ,missaoAtualizada);
    }

    // DELETE -- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }
}
