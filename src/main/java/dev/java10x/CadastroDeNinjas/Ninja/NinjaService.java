package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRespository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninja por ID
    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRespository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRespository.findById(id); // Filtra o ninja por id para um optional
        if (ninjaExistente.isPresent()){ // Caso o ninja existir
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO); // Cria um modelo a partir do dto
            ninjaAtualizado.setId(id);//
            NinjaModel ninjaSalvo = ninjaRespository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null; // Caso o ninja não existir
    }
}
