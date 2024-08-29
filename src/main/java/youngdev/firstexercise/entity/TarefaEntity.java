package youngdev.firstexercise.entity;

import jakarta.persistence.*;
import youngdev.firstexercise.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "tarefa")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String descricao;
    private Boolean completa;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//    @JoinColumn(name = "categoria_id", nullable = false)
//    private CategoriaEntity categoria;

    public TarefaEntity(TarefaDto dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.completa = dto.getCompleta();
    }

    public TarefaEntity atualizaTarefa(TarefaDto dto) {
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.completa = dto.getCompleta();
        return this;
    }
}