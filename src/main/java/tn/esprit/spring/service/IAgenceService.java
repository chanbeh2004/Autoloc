package tn.esprit.spring.service;

import tn.esprit.spring.domain.Agence;

import java.util.List;

public interface IAgenceService {
    Agence creer(Agence agence);
    Agence obtenirParId(Long id);
    List<Agence> listerTous();
    Agence mettreAJour(Agence agence);
    void supprimer(Long id);
}