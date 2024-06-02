package com.RamenGo.api.repositories;

import com.RamenGo.api.models.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, String> {
  @Query("SELECT p.name FROM Protein p WHERE p.id = :proteinId")
  String findNameById(@Param("proteinId") String proteinId);
}
