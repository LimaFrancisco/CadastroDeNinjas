package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injeção de dependencia do NinjaRepository
    private NinjaRespository ninjaRespository;
    private NinjaMapper ninjaMapper;

    // Inicializado o construtor que pode ser substituido pela anotation @Autowired
    public NinjaService(NinjaRespository ninjaRespository, NinjaMapper ninjaMapper) {
        this.ninjaRespository = ninjaRespository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRespository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deltar um ninja por ID - Tem que ser um metodo void
    public void deletarNinja(Long id){
        ninjaRespository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRespository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRespository.save(ninjaAtualizado);
        }
        else{
            return null;
        }
    }
}
