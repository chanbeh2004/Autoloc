package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Agence;
import tn.esprit.spring.service.IAgenceService;

import java.util.List;

@Tag(name ="Gestion Agence")
@RestController
@AllArgsConstructor
@RequestMapping("/Agence")
public class AgenceController {
    IAgenceService agenceService;
    @Operation
    @PostMapping("/create")
    public Agence creer(@RequestBody Agence agence) {
        return agenceService.creer(agence);
    }
    @Operation
    @GetMapping("/get/{id}")
    public Agence obtenirParId(@PathVariable("id") Long id) {
        return agenceService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Agence> listerTous() {
        return agenceService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Agence mettreAJour(@RequestBody Agence agence) {
        return agenceService.mettreAJour(agence);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        agenceService.supprimer(id);
    }
}