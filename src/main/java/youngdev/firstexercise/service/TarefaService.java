package youngdev.firstexercise.service;

import youngdev.firstexercise.dto.TarefaDto;

import java.util.List;
import java.util.Optional;

public interface TarefaService {

    List<TarefaDto> getTodasTarefas();

    Optional<TarefaDto> findById(Long id);

    TarefaDto adicionarTarefa(TarefaDto novaTarefa);

    TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada);

    void removerTarefa(Long id);
}