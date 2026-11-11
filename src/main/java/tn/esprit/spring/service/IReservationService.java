package tn.esprit.spring.service;

import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.domain.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation creer(Reservation reservation);
    Reservation obtenirParId(Long id);
    List<Reservation> listerTous();
    Reservation mettreAJour(Reservation reservation);
    void supprimer(Long id);

    Contrat ajouterReservationContrat(Long idReservation, Contrat contrat);
}