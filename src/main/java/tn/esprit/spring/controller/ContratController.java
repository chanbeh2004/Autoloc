package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.service.IContratService;

import java.util.List;


@Tag(name="Gestion Contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/Contrat")
public class ContratController {
    IContratService contratService;
    @Operation
    @PostMapping("/create")
    public Contrat creer(@RequestBody Contrat contrat) {
        return contratService.creer(contrat);
    }
    @Operation
    @GetMapping("/get/{id}")
    public Contrat obtenirParId(@PathVariable("id") Long id) {
        return contratService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Contrat> listerTous() {
        return contratService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Contrat mettreAJour(@RequestBody Contrat contrat) {
        return contratService.mettreAJour(contrat);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        contratService.supprimer(id);
    }
}