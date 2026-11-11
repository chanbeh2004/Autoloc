package tn.esprit.spring.service;

import tn.esprit.spring.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat creer(Contrat contrat);
    Contrat obtenirParId(Long id);
    List<Contrat> listerTous();
    Contrat mettreAJour(Contrat contrat);
    void supprimer(Long id);
}