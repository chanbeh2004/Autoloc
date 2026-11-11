package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Equipement;
import tn.esprit.spring.service.IEquipementService;

import java.util.List;


@Tag(name="Gestion Equipement")
@RestController
@AllArgsConstructor
@RequestMapping("/Equipement")
public class EquipementController {
    IEquipementService equipementService;
    @Operation
    @PostMapping("/create")
    public Equipement creer(@RequestBody Equipement equipement) {
        return equipementService.creer(equipement);
    }
    @Operation
    @GetMapping("/get/{id}")
    public Equipement obtenirParId(@PathVariable("id") Long id) {
        return equipementService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Equipement> listerTous() {
        return equipementService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Equipement mettreAJour(@RequestBody Equipement equipement) {
        return equipementService.mettreAJour(equipement);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        equipementService.supprimer(id);
    }
}