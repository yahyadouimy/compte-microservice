package org.enset.comptemicroservice.repositries;

import org.enset.comptemicroservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

   // List<CompteProjection> findAllProjectedBy();
}
