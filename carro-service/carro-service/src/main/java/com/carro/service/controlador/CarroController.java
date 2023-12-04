package com.carro.service.controlador;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroRepository;
import com.carro.service.servicio.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carros = carroService.getCarroById(id);
        if (carros == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro  carro){

        Carro nuevoCarro= carroService.save(carro);
        return ResponseEntity.ok(nuevoCarro);

    }

    @GetMapping("usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorusuarioId(@PathVariable("usuarioId") int id){
        List<Carro> carros = carroService.byUsuarioId(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
}
