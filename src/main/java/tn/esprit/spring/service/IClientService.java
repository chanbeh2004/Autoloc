package tn.esprit.spring.service;

import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;

import java.util.List;

public interface IClientService {
    Client creer(Client client);
    Client obtenirParId(Long id);
    List<Client> listerTous();
    Client mettreAJour(Client client);
    void supprimer(Long id);

    Client ajouterClientReservation(Client client);

    List<Client> recupererParNomPrenomEtCategorieVehicule(
            String nom, String prenom, CategorieVehicule categorieVehicule);
}