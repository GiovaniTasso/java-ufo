package teste.exemplo.datosdeportivosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teste.exemplo.datosdeportivosapi.model.entity.Pin;

import java.util.List;

public interface PinRepository extends JpaRepository<Pin, Long> {

    @Query(value = "select * from pins", nativeQuery = true)
    List<Pin> GetAllPins();

    @Query(value = "select id from pins where id = :id", nativeQuery = true)
    Pin findByid(@Param("id") Long id);


}
