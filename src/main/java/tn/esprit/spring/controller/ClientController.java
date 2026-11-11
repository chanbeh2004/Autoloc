package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;
import tn.esprit.spring.service.IClientService;

import java.util.List;

@Tag(name = "Gestion des Clients")
@RestController
@AllArgsConstructor
@RequestMapping("/Client")
public class ClientController {

    IClientService clientService;

    @Operation
    @PostMapping("/create")
    public Client creer(@RequestBody Client client) {
        return clientService.creer(client);
    }

    @Operation
    @GetMapping("/get/{id}")
    public Client obtenirParId(@PathVariable("id") Long id) {
        return clientService.obtenirParId(id);
    }

    @Operation
    @GetMapping("/getAll")
    public List<Client> listerTous() {
        return clientService.listerTous();
    }

    @Operation
    @PutMapping("/update")
    public Client mettreAJour(@RequestBody Client client) {
        return clientService.mettreAJour(client);
    }

    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        clientService.supprimer(id);
    }

    @Operation
    @PostMapping("/ajouterClientReservation")
    public Client ajouterClientReservation(@RequestBody Client client) {
        return clientService.ajouterClientReservation(client);
    }

    @Operation(summary = "Récupérer les clients par nom, prénom et catégorie de véhicule")
    @GetMapping("/recupererParNomPrenomEtCategorie")
    public List<Client> recupererParNomPrenomEtCategorieVehicule(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("categorie") CategorieVehicule categorie) {
        return clientService.recupererParNomPrenomEtCategorieVehicule(nom, prenom, categorie);
    }
}