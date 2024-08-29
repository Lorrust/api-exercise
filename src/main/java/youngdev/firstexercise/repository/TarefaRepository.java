package youngdev.firstexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youngdev.firstexercise.entity.TarefaEntity;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

}