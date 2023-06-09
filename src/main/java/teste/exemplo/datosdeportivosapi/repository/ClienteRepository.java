package teste.exemplo.datosdeportivosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;

import java.util.Map;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {




    @Query(value = "SELECT c.email AS email, c.senha AS senha FROM Cliente c WHERE c.email = :email", nativeQuery = true)
    Map<String, Object> findByEmail(@Param("email") String email);

    boolean existsByEmail(String email);
}
