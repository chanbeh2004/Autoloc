package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Paiement;
import tn.esprit.spring.repository.IPaiementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    IPaiementRepository paiementRepository;

    @Override
    public Paiement creer(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement obtenirParId(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> listerTous() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement mettreAJour(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimer(Long id) {
        paiementRepository.deleteById(id);
    }
}