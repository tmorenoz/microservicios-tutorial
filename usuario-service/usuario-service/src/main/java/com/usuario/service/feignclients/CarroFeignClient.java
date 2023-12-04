package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import com.usuario.service.modelos.Carro;
@FeignClient(name = "carro-service",url = "http://localhost:8002")
public interface CarroFeignClient {

    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/carro/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);

    

}
