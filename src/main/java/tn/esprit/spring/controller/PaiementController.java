package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Paiement;
import tn.esprit.spring.service.IPaiementService;

import java.util.List;



@Tag(name="Gestion Paiement")
@RestController
@AllArgsConstructor
@RequestMapping("/Paiement")
public class PaiementController {
    IPaiementService paiementService;
    @Operation
    @PostMapping("/create")
    public Paiement creer(@RequestBody Paiement paiement) {
        return paiementService.creer(paiement);
    }
    @Operation
    @GetMapping("/get/{id}")
    public Paiement obtenirParId(@PathVariable("id") Long id) {
        return paiementService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Paiement> listerTous() {
        return paiementService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Paiement mettreAJour(@RequestBody Paiement paiement) {
        return paiementService.mettreAJour(paiement);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        paiementService.supprimer(id);
    }
}