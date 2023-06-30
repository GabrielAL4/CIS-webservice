package br.com.cisbrasil.found.repository;

import br.com.cisbrasil.found.model.Cost;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CostRepository extends JpaRepository<Cost, Integer> {
    @Query("SELECT c FROM Cost c")
    List<Cost> findAllCosts();
}
