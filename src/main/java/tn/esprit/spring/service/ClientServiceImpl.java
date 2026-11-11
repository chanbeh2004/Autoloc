package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.domain.*;
import tn.esprit.spring.repository.IClientRepository;
import tn.esprit.spring.repository.IVehiculeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;
    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client obtenirParId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> listerTous() {
        return clientRepository.findAll();
    }

    @Override
    public Client mettreAJour(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void supprimer(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Client ajouterClientReservation(Client client) {

        if (client.getDateInscription() == null) {
            client.setDateInscription(LocalDate.now());
        }

        if (client.getReservations() == null) {
            client.setReservations(new ArrayList<>());
        }

        for (Reservation reservation : client.getReservations()) {

            // côté propriétaire de la relation : obligatoire pour remplir id_client
            reservation.setClient(client);

            if (reservation.getStatut() == null) {
                reservation.setStatut(StatutReservation.values()[0]); // ou StatutReservation.EN_ATTENTE selon ton enum
            }

            if (reservation.getVehicule() == null || reservation.getVehicule().getIdVehicule() == null) {
                throw new RuntimeException("Chaque réservation doit contenir un véhicule (idVehicule)");
            }

            Long idVehicule = reservation.getVehicule().getIdVehicule();
            Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                    .orElseThrow(() -> new RuntimeException("Véhicule introuvable : " + idVehicule));
            reservation.setVehicule(vehicule);
        }

        // cascade PERSIST : le client et ses réservations sont enregistrés ensemble
        return clientRepository.save(client);
    }
    @Override
    public List<Client> recupererParNomPrenomEtCategorieVehicule(String nom, String prenom, CategorieVehicule categorieVehicule) {
        return clientRepository.findDistinctByNomAndPrenomAndReservations_Vehicule_Categorie(nom, prenom, categorieVehicule);
    }


}