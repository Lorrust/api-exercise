package youngdev.firstexercise.service;

import youngdev.firstexercise.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaDto> getTodasCategorias();

    Optional<CategoriaDto> findById(Long id);

    CategoriaDto cadastrarCategoria(CategoriaDto novaCategoria);

    void removerCategoria(Long id);

}