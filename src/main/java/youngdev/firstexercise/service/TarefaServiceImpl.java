package youngdev.firstexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.firstexercise.dto.TarefaDto;
import youngdev.firstexercise.entity.TarefaEntity;
import youngdev.firstexercise.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository repository;

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

    @Override
    public TarefaDto adicionarTarefa(TarefaDto novaTarefaDto) {
        var tarefaEntity = new TarefaEntity(novaTarefaDto);
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