package dev.java10x.CadastroDeNinjas.Ninja;

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
}
