  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.gestionvehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alanl
 */
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    @PostMapping
    public void agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @PutMapping("/{placa}")
    public void actualizarVehiculo(@PathVariable String placa, @RequestBody Vehiculo vehiculo) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                v.setModelo(vehiculo.getModelo());
                v.setColor(vehiculo.getColor());
                v.setPuertas(vehiculo.getPuertas());
                break;
            }
        }
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
}
