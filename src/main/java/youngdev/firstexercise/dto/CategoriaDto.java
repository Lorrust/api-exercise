package youngdev.firstexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.firstexercise.entity.CategoriaEntity;
import youngdev.firstexercise.enuns.PrioridadeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoriaDto {

    private Long id;
    private String nome;
    private String descricao;
    private PrioridadeEnum prioridadeEnum;

    public CategoriaDto(CategoriaEntity categoriaEntity) {
        this.id = categoriaEntity.getId();
        this.nome = categoriaEntity.getNome();
        this.descricao = categoriaEntity.getDescricao();
        this.prioridadeEnum = categoriaEntity.getPrioridadeEnum();
    }

}
