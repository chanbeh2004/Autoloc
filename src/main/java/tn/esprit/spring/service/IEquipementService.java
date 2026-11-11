package tn.esprit.spring.service;

import tn.esprit.spring.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement creer(Equipement equipement);
    Equipement obtenirParId(Long id);
    List<Equipement> listerTous();
    Equipement mettreAJour(Equipement equipement);
    void supprimer(Long id);
}