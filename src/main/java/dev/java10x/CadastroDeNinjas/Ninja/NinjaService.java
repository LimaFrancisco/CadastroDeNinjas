package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
