package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.repository.IContratRepository;
import tn.esprit.spring.repository.IReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final IContratRepository contratRepository;

    @Override
    public Reservation creer(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation obtenirParId(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> listerTous() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation mettreAJour(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
        reservationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Contrat ajouterReservationContrat(Long idReservation, Contrat contrat) {

        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() ->
                        new RuntimeException("Réservation introuvable : " + idReservation));

        // la relation est OneToOne + unique : une réservation ne peut avoir qu'un seul contrat
        if (reservation.getContrat() != null) {
            throw new RuntimeException("Cette réservation possède déjà un contrat");
        }

        if (contrat.getDateSignature() == null) {
            contrat.setDateSignature(LocalDate.now());
        }

        // côté propriétaire : remplit la colonne id_reservation
        contrat.setReservation(reservation);

        Contrat saved = contratRepository.save(contrat);

        // garde les deux côtés synchronisés en mémoire
        reservation.setContrat(saved);

        return saved;
    }
}