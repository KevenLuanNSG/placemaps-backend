package com.esoft.placemaps.placemaps.localizacao;

import com.esoft.placemaps.placemaps.localizacao.dto.LocalizacaoAtualizarDTO;
import com.esoft.placemaps.placemaps.localizacao.dto.LocalizacaoFormDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/localizacao")
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    @Autowired
    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @PreAuthorize("hasRole('PROPRIETARIO')")
    @PostMapping
    public ResponseEntity<Localizacao> salvar(@RequestBody LocalizacaoFormDTO localizacaoFormDTO) {
        return ResponseEntity.ok(this.localizacaoService.salvar(localizacaoFormDTO));
    }

    @PreAuthorize("hasRole('PROPRIETARIO')")
    @PutMapping("/{id}")
    public ResponseEntity<Localizacao> editar(@PathVariable String id, @RequestBody LocalizacaoAtualizarDTO localizacaoAtualizarDTO) {
        return ResponseEntity.ok(this.localizacaoService.atualizar(id, localizacaoAtualizarDTO));
    }

    @PreAuthorize("hasRole('PROPRIETARIO')")
    @DeleteMapping("/{id}")
    public ResponseEntity deletarLocalizacao(@PathVariable String id) {
        this.localizacaoService.deletarLocalizacao(id);
        return ResponseEntity.accepted().build();
    }
    
}
