package tn.esprit.spring.service;

import tn.esprit.spring.domain.Employe;
import java.util.List;

public interface IEmployeService {

    Employe creer(Employe employe);

    Employe obtenirParId(Long id);

    List<Employe> listerTous();

    Employe mettreAJour(Employe employe);

    void supprimer(Long id);

    Employe affecterEmployeAgent(Long idE, Long idA);
}