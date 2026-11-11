package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.service.IVehiculeService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Gestion Vehicule")
@RestController
@AllArgsConstructor
@RequestMapping("/Vehicule")
public class VehiculeController {

    IVehiculeService vehiculeService;



    @Operation
    @PostMapping("/create")
    public Vehicule creer(@RequestBody Vehicule vehicule) {
        return vehiculeService.creer(vehicule);
    }

    @Operation
    @GetMapping("/get/{id}")
    public Vehicule obtenirParId(@PathVariable("id") Long id) {
        return vehiculeService.obtenirParId(id);
    }

    @Operation
    @GetMapping("/getAll")
    public List<Vehicule> listerTous() {
        return vehiculeService.listerTous();
    }

    @Operation
    @PutMapping("/update")
    public Vehicule mettreAJour(@RequestBody Vehicule vehicule) {
        return vehiculeService.mettreAJour(vehicule);
    }

    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        vehiculeService.supprimer(id);
    }

    @Operation
    @PutMapping("/affecter/{idV}/{idEQ}")
    public Vehicule affecterVehiculeEquipement(@PathVariable("idV") Long idV,
                                               @PathVariable("idEQ") Long idEQ) {
        return vehiculeService.affecterVehiculeEquipement(idV, idEQ);
    }



    @Operation(summary = "1. Véhicules d'une marque")
    @GetMapping("/marque")
    public List<Vehicule> parMarque(@RequestParam String marque) {
        return vehiculeService.rechercherParMarque(marque);
    }

    @Operation(summary = "2. Marque contient un mot")
    @GetMapping("/marque/contient")
    public List<Vehicule> marqueContient(@RequestParam String mot) {
        return vehiculeService.rechercherMarqueContient(mot);
    }

    @Operation(summary = "3. Marque commence par")
    @GetMapping("/marque/commence")
    public List<Vehicule> marqueCommence(@RequestParam String debut) {
        return vehiculeService.rechercherMarqueCommencePar(debut);
    }

    @Operation(summary = "4. Marque se termine par")
    @GetMapping("/marque/termine")
    public List<Vehicule> marqueTermine(@RequestParam String fin) {
        return vehiculeService.rechercherMarqueTerminePar(fin);
    }

    @Operation(summary = "5. Marque sans tenir compte de la casse")
    @GetMapping("/marque/ignorecase")
    public List<Vehicule> marqueIgnoreCase(@RequestParam String marque) {
        return vehiculeService.rechercherParMarqueIgnoreCase(marque);
    }

    @Operation(summary = "6. Véhicules par modèle")
    @GetMapping("/modele")
    public List<Vehicule> parModele(@RequestParam String modele) {
        return vehiculeService.rechercherParModele(modele);
    }

    @Operation(summary = "7. Existe par immatriculation")
    @GetMapping("/existe")
    public boolean existe(@RequestParam String immatriculation) {
        return vehiculeService.existeParImmatriculation(immatriculation);
    }

    @Operation(summary = "8. Compter les véhicules d'une marque")
    @GetMapping("/marque/count")
    public long compterMarque(@RequestParam String marque) {
        return vehiculeService.compterParMarque(marque);
    }



    @Operation(summary = "9. Tarif supérieur à")
    @GetMapping("/tarif/superieur")
    public List<Vehicule> tarifSuperieur(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifSuperieurA(tarif);
    }

    @Operation(summary = "10. Tarif inférieur à")
    @GetMapping("/tarif/inferieur")
    public List<Vehicule> tarifInferieur(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifInferieurA(tarif);
    }

    @Operation(summary = "11. Tarif supérieur ou égal à")
    @GetMapping("/tarif/superieur-egal")
    public List<Vehicule> tarifSuperieurEgal(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifSuperieurOuEgalA(tarif);
    }

    @Operation(summary = "12. Tarif entre deux valeurs")
    @GetMapping("/tarif/entre")
    public List<Vehicule> tarifEntre(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return vehiculeService.tarifEntre(min, max);
    }

    @Operation(summary = "13. Tri par tarif croissant")
    @GetMapping("/tri/tarif/asc")
    public List<Vehicule> triAsc() {
        return vehiculeService.trierParTarifCroissant();
    }

    @Operation(summary = "14. Tri par tarif décroissant")
    @GetMapping("/tri/tarif/desc")
    public List<Vehicule> triDesc() {
        return vehiculeService.trierParTarifDecroissant();
    }

    @Operation(summary = "15. Marque triée par tarif croissant")
    @GetMapping("/marque/tri/tarif/asc")
    public List<Vehicule> marqueTriAsc(@RequestParam String marque) {
        return vehiculeService.marqueTriesParTarifCroissant(marque);
    }

    @Operation(summary = "16. Marque dont le tarif dépasse une valeur")
    @GetMapping("/marque/tarif/superieur")
    public List<Vehicule> marqueTarifSuperieur(@RequestParam String marque,
                                               @RequestParam BigDecimal tarif) {
        return vehiculeService.marqueTarifSuperieurA(marque, tarif);
    }

    @Operation(summary = "17. Marque OU modèle")
    @GetMapping("/marque-ou-modele")
    public List<Vehicule> marqueOuModele(@RequestParam String marque, @RequestParam String modele) {
        return vehiculeService.marqueOuModele(marque, modele);
    }

    @Operation(summary = "18. Marque dans une liste")
    @GetMapping("/marque/in")
    public List<Vehicule> marqueIn(@RequestParam List<String> marques) {
        return vehiculeService.marqueDansListe(marques);
    }

    @Operation(summary = "19. Marque hors d'une liste")
    @GetMapping("/marque/not-in")
    public List<Vehicule> marqueNotIn(@RequestParam List<String> marques) {
        return vehiculeService.marqueHorsListe(marques);
    }



    @Operation(summary = "20. Véhicules par statut")
    @GetMapping("/statut")
    public List<Vehicule> parStatut(@RequestParam StatutVehicule statut) {
        return vehiculeService.parStatut(statut);
    }

    @Operation(summary = "21. Disponibles triés par tarif croissant")
    @GetMapping("/disponibles/tri/tarif")
    public List<Vehicule> disponiblesTries() {
        return vehiculeService.disponiblesTriesParTarif();
    }



    @Operation(summary = "22. Véhicules d'une agence")
    @GetMapping("/agence/{idAgence}")
    public List<Vehicule> parAgence(@PathVariable Long idAgence) {
        return vehiculeService.parAgence(idAgence);
    }

    @Operation(summary = "23. Véhicules d'une agence d'une ville")
    @GetMapping("/agence/ville")
    public List<Vehicule> parVille(@RequestParam String ville) {
        return vehiculeService.parVilleAgence(ville);
    }

    @Operation(summary = "24. Agence dont le nom contient")
    @GetMapping("/agence/nom-contient")
    public List<Vehicule> parNomAgence(@RequestParam String mot) {
        return vehiculeService.parNomAgenceContient(mot);
    }

    @Operation(summary = "25. Véhicules d'une agence et d'une marque")
    @GetMapping("/agence/{idAgence}/marque")
    public List<Vehicule> parAgenceEtMarque(@PathVariable Long idAgence, @RequestParam String marque) {
        return vehiculeService.parAgenceEtMarque(idAgence, marque);
    }

    @Operation(summary = "26. Véhicules sans agence")
    @GetMapping("/sans-agence")
    public List<Vehicule> sansAgence() {
        return vehiculeService.sansAgence();
    }

    @Operation(summary = "27. Véhicules affectés à une agence")
    @GetMapping("/avec-agence")
    public List<Vehicule> avecAgence() {
        return vehiculeService.avecAgence();
    }

    @Operation(summary = "28. Compter les véhicules d'une agence")
    @GetMapping("/agence/{idAgence}/count")
    public long compterParAgence(@PathVariable Long idAgence) {
        return vehiculeService.compterParAgence(idAgence);
    }

    @Operation(summary = "29. Une agence possède-t-elle des véhicules ?")
    @GetMapping("/agence/{idAgence}/existe")
    public boolean agenceADesVehicules(@PathVariable Long idAgence) {
        return vehiculeService.agenceADesVehicules(idAgence);
    }
}