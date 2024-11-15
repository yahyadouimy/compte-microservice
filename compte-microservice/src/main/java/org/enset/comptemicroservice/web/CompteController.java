package org.enset.comptemicroservice.web;


import org.enset.comptemicroservice.dto.CompteDTOcreat;
import org.enset.comptemicroservice.dto.CompteDTOedit;
import org.enset.comptemicroservice.entities.Compte;
import org.enset.comptemicroservice.exc.CheckNullException;
import org.enset.comptemicroservice.repositries.CompteProjection;
import org.enset.comptemicroservice.services.CompteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    ModelMapper mapper;


    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @PostMapping("")
    public ResponseEntity<Compte> createCompte(@RequestBody CompteDTOcreat compteRequest) {

        Compte compte  = this.mapper.map(compteRequest, Compte.class);
        compte.setBalance(0);

        compteService.createCompte(compte);

        return ResponseEntity.ok(compte);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
        Optional<Compte> compte = compteService.getCompteById(id);
        return compte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }


    @GetMapping("/getAllComptesProjection")
    public List<CompteProjection> getAllComptesProjection() {
        return compteService.findAllProjectedBy();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> updateCompte(@PathVariable Long id, @RequestBody CompteDTOedit compteDTOedit) throws CheckNullException {

        if(  compteDTOedit.getCurrency()==null || compteDTOedit.getBalance()==null || compteDTOedit.getAccountNumber()==null  )
            throw new CheckNullException("check !!!!");

        if(  compteDTOedit.getCurrency().isEmpty() || compteDTOedit.getBalance()==null || compteDTOedit.getAccountNumber().isEmpty() )
            throw new RuntimeException("check !!!!");

        Compte compte  = this.mapper.map(compteDTOedit, Compte.class);


        compteService.updateCompte(id,compte);


        return ResponseEntity.ok(compteService.updateCompte(id,compte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(
            CheckNullException ex) {
        var response = new CheckNullException( ex.getMessage());
        return new ResponseEntity<>(response.getMessage(), HttpStatus.NOT_FOUND);
    }

}