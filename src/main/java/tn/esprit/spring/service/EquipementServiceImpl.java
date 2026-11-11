package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Equipement;
import tn.esprit.spring.repository.IEquipementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    IEquipementRepository equipementRepository;

    @Override
    public Equipement creer(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement obtenirParId(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> listerTous() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement mettreAJour(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void supprimer(Long id) {
        equipementRepository.deleteById(id);
    }
}