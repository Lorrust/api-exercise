package youngdev.firstexercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.firstexercise.dto.CategoriaDto;
import youngdev.firstexercise.dto.TarefaDto;
import youngdev.firstexercise.entity.CategoriaEntity;
import youngdev.firstexercise.entity.TarefaEntity;
import youngdev.firstexercise.repository.TarefaRepository;
import youngdev.firstexercise.service.CategoriaService;
import youngdev.firstexercise.service.TarefaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<TarefaDto> getTodasTarefas() {
        List<TarefaEntity> tarefaEntityList = repository.findAll();
        return tarefaEntityList.stream().map(TarefaDto::new).collect(Collectors.toList());
    }

    @Override
    public Optional<TarefaDto> findById(Long id) {
        var tarefaEntity = repository.findById(id);
        return tarefaEntity.map(TarefaDto::new);
    }

//    TODO: Fix this method, so that the task can be associated to a category
    @Override
    public TarefaDto adicionarTarefa(TarefaDto novaTarefaDto) {
        var categoria = categoriaService.findById(novaTarefaDto.getCategoriaId());
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
        CategoriaDto categoria = new CategoriaDto(categoriaEntity);
        novaTarefaDto.setId(categoria.getId());
        TarefaEntity tarefaEntity = new TarefaEntity(novaTarefaDto, categoriaEntity);
        TarefaEntity entidadePersistida = repository.save(tarefaEntity);
        return new TarefaDto(entidadePersistida);
    }

    @Override
    public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) {
        Optional<TarefaEntity> tarefaEntity = repository.findById(id);
        if (tarefaEntity.isPresent()) {
            tarefaEntity.get().atualizaTarefa(tarefaAtualizada);
            var entidadePersistida = repository.save(tarefaEntity.get());
            return new TarefaDto(entidadePersistida);
        }
        return null;
    }

    @Override
    public void removerTarefa(Long id) {
        repository.deleteById(id);
    }
}