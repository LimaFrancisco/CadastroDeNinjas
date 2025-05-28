package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missao.MissaoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injeção de dependencia do NinjaRepository
    private NinjaRespository ninjaRespository;

    // Inicializado o construtor que pode ser substituido pela anotation @Autowired
    public NinjaService(NinjaRespository ninjaRespository) {
        this.ninjaRespository = ninjaRespository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRespository.findAll();
    }

    // Listar ninja por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRespository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRespository.save(ninja);
    }

    // Deltar um ninja por ID - Tem que ser um metodo void
    public void deletarNinja(Long id){
        ninjaRespository.deleteById(id);
    }
}
