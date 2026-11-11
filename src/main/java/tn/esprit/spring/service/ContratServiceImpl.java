package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.repository.IContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {
    IContratRepository contratRepository;

    @Override
    public Contrat creer(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat obtenirParId(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> listerTous() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat mettreAJour(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimer(Long id) {
        contratRepository.deleteById(id);
    }
}