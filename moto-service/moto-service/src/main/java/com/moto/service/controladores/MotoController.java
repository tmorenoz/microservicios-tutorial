package com.moto.service.controladores;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarmotos(){
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenermoto(@PathVariable("id") int id){
        Moto motos = motoService.getMotoById(id);
        if (motos == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motos);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarmoto(@RequestBody Moto  moto){

        Moto nuevoMoto= motoService.save(moto);
        return ResponseEntity.ok(nuevoMoto);

    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarmotosPorusuarioId(@PathVariable("usuarioId") int id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
