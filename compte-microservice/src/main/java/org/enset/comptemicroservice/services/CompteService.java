package org.enset.comptemicroservice.services;

import org.enset.comptemicroservice.entities.Compte;
import org.enset.comptemicroservice.repositries.CompteProjection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompteService {

    Compte createCompte(Compte compte);

    Optional<Compte> getCompteById(Long id);

    List<Compte> getAllComptes();
    List<CompteProjection> findAllProjectedBy();

    Compte updateCompte(Long id, Compte updatedCompte);

    void deleteCompte(Long id);

}
