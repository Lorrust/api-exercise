package youngdev.firstexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youngdev.firstexercise.dto.CategoriaDto;
import youngdev.firstexercise.dto.TarefaDto;
import youngdev.firstexercise.service.CategoriaService;
import youngdev.firstexercise.service.TarefaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDto> getTodasCategorias() {
        return categoriaService.getTodasCategorias();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaDto> getCategoriaPorId(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public void cadastrarCategoria(@RequestBody CategoriaDto novaCategoria) {
        categoriaService.cadastrarCategoria(novaCategoria);
    }

    @DeleteMapping("/{id}")
    public void removerCategoria(@PathVariable Long id) {
        categoriaService.removerCategoria(id);
    }

}