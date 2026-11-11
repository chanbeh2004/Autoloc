package tn.esprit.spring.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Employe;
import tn.esprit.spring.service.IEmployeService;

import java.util.List;

@Tag(name="Gestion Employe")
@RestController
@AllArgsConstructor
@RequestMapping("/Employer")
public class EmployeController {
    IEmployeService employerService;
    @Operation
    @PostMapping("/create")
    public Employe creer(@RequestBody Employe employe) {
        return employerService.creer(employe);
    }

    public Employe obtenirParId(Long id) {
        return employerService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Employe> listerTous() {
        return employerService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Employe mettreAJour(@RequestBody Employe employe) {
        return employerService.mettreAJour(employe);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        employerService.supprimer(id);
    }


    @Operation
    @PutMapping("/affecter/{idE}/{idA}")
    public Employe affecterEmployeAgent(@PathVariable Long idE,@PathVariable Long idA) {
        return employerService.affecterEmployeAgent(idE, idA);
    }
}
