package com.esoft.placemaps.placemaps.plano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/plano")
public class PlanoPublicController {

    private final PlanoService planoService;

    @Autowired
    public PlanoPublicController(PlanoService planoService) {
        this.planoService = planoService;
    }
    
    @GetMapping
    public ResponseEntity<Page<Plano>> pegarPlanos (Pageable pageable) {
        return ResponseEntity.ok(planoService.pegarPlanos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> pegarPlanoPeloId(@PathVariable String id) {
        return ResponseEntity.ok(planoService.pegarPlanoPeloId(id));
    }
}
