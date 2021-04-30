package lesson7.articletask.repository;

import lesson7.articletask.entity.Lavozim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LavozimRepository extends JpaRepository<Lavozim,Long> {
    Optional<Lavozim> findByName(String name);
    boolean existsByName(String name);
}
