package youngdev.firstexercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.firstexercise.dto.CategoriaDto;
import youngdev.firstexercise.entity.CategoriaEntity;
import youngdev.firstexercise.repository.CategoriaRepository;
import youngdev.firstexercise.service.CategoriaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<CategoriaDto> getTodasCategorias() {
        List<CategoriaEntity> categoriaEntityList = repository.findAll();
        return categoriaEntityList.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDto> findById(Long id) {
        var categoriaEntity = repository.findById(id);
        return categoriaEntity.map(CategoriaDto::new);
    }

    @Override
    public CategoriaDto cadastrarCategoria(CategoriaDto novaCategoriaDto) {

        var categoriaEntity = new CategoriaEntity(novaCategoriaDto);
        CategoriaEntity categoriaPersistida = repository.save(categoriaEntity);
        return new CategoriaDto(categoriaPersistida);
    }

    @Override
    public void removerCategoria(Long id) {
        repository.deleteById(id);
    }

}