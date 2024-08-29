package youngdev.firstexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import youngdev.firstexercise.entity.TarefaEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean completa;
    private Long categoriaId;

    public TarefaDto(TarefaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.completa = entity.getCompleta();
        this.categoriaId = entity.getCategoria().getId();
    }
}