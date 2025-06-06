package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Injetar dependencia do Service
    NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boas-vindas")
    public String boasVindas(){
        return "Bem vindo a minha api";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os nijas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable  Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
