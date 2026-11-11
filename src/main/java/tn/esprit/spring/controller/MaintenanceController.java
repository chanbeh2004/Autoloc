package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Maintenance;
import tn.esprit.spring.service.IMaintenanceService;

import java.util.List;



@Tag(name="Gestion Maintenance")
@RestController
@AllArgsConstructor
@RequestMapping("/Maintenance")
public class MaintenanceController {
    IMaintenanceService maintenanceService;
    @Operation
    @PostMapping("/create")
    public Maintenance creer(@RequestBody Maintenance maintenance) {
        return maintenanceService.creer(maintenance);
    }
    @Operation
    @GetMapping("/get/{id}")
    public Maintenance obtenirParId(@PathVariable("id") Long id) {
        return maintenanceService.obtenirParId(id);
    }
    @Operation
    @GetMapping("/getAll")
    public List<Maintenance> listerTous() {
        return maintenanceService.listerTous();
    }
    @Operation
    @PutMapping("/update")
    public Maintenance mettreAJour(@RequestBody Maintenance maintenance) {
        return maintenanceService.mettreAJour(maintenance);
    }
    @Operation
    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        maintenanceService.supprimer(id);
    }

    @Operation(summary = "Affecter un véhicule à une maintenance")
    @PutMapping("/affecterVehicule/{idM}/{idV}")
    public Maintenance affecterVehiculeMaintenace(
            @PathVariable("idM") Long idM,
            @PathVariable("idV") Long idV) {

        return maintenanceService.affecterVehiculeMaintenace(idM, idV);
    }

}