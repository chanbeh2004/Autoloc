package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.service.IReservationService;

import java.util.List;

@Tag(name="Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/Reservation")
public class ReservationController {

    IReservationService reservationService;

    @Operation
    @PostMapping("/create")
    public Reservation creer(@RequestBody Reservation reservation) {
        return reservationService.creer(reservation);
    }

    @Operation
    @GetMapping("/get/{id}")
    public Reservation obtenirParId(@PathVariable("id") Long id) {
        return reservationService.obtenirParId(id);
    }

    @Operation
    @GetMapping("/getAll")
    public List<Reservation> listerTous() {
        return reservationService.listerTous();
    }

    @Operation
    @PutMapping("/update")
    public Reservation mettreAJour(@RequestBody Reservation reservation) {
        return reservationService.mettreAJour(reservation);
    }

    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        reservationService.supprimer(id);
    }

    @Operation
    @PostMapping("/ajouterReservationContrat/{idReservation}")
    public Contrat ajouterReservationContrat(@PathVariable("idReservation") Long idReservation,
                                             @RequestBody Contrat contrat) {
        return reservationService.ajouterReservationContrat(idReservation, contrat);
    }
}