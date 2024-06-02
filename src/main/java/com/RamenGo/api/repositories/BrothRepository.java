package com.RamenGo.api.repositories;

import com.RamenGo.api.models.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends JpaRepository<Broth, String> {
  @Query("SELECT b.name FROM Broth b WHERE b.id = :brothId")
  String findNameById(@Param("brothId") String brothId);
}
