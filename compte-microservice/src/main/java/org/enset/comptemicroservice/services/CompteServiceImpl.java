package org.enset.comptemicroservice.services;

import org.enset.comptemicroservice.entities.Compte;
import org.enset.comptemicroservice.repositries.CompteProjection;
import org.enset.comptemicroservice.repositries.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService  {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public List<CompteProjection> findAllProjectedBy() {
     //   return compteRepository.findAllProjectedBy();
        return  null;
    }
    @Override
    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte updateCompte(Long id, Compte updatedCompte) {
        Optional<Compte> compte = compteRepository.findById(id);
        if (compte.isPresent()) {
            Compte existingCompte = compte.get();
            existingCompte.setAccountNumber(updatedCompte.getAccountNumber());
            existingCompte.setCurrency(updatedCompte.getCurrency());
            existingCompte.setBalance(updatedCompte.getBalance());
            return compteRepository.save(existingCompte);
        }
        return null;
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
