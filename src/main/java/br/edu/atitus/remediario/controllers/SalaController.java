package br.edu.atitus.remediario.controllers;

import br.edu.atitus.remediario.dtos.request.SalaRequestDTO;
import br.edu.atitus.remediario.dtos.response.SalaResponseDTO;
import br.edu.atitus.remediario.entities.SalaEntity;
import br.edu.atitus.remediario.entities.UserEntity;
import br.edu.atitus.remediario.security.TokenService;
import br.edu.atitus.remediario.services.SalaService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;
    
    @Autowired
    private TokenService tokenService;
    
    @GetMapping
    public List<SalaEntity> listarTodasAsSalas() {
        return salaService.buscarTodasAsSalas(); // Simples e direto como uma flecha élfica
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<SalaResponseDTO> createSala(@RequestBody SalaRequestDTO salaDto, HttpServletRequest request) {
        
        SalaEntity sala = new SalaEntity();
    	String token = request.getHeader("Authorization").replace("Bearer ", "");
        String userId = tokenService.getUserIdFromToken(token);
        if (userId == null) {
            return ResponseEntity.status(403).body(null);
        }
    
        sala.setName(salaDto.getName());
        sala.setCapacidade(salaDto.getCapacidade());
        salaService.saveSala(sala);
        SalaResponseDTO salaDTO = new SalaResponseDTO(
                    sala.getId(),
                    sala.getCapacidade(),
                    sala.getName());
        return ResponseEntity.ok(salaDTO);
    }
    
    
    @DeleteMapping("/deletebyid/{salaId}")
    public ResponseEntity<String> deleteMedicamentoById(@PathVariable UUID salaId, HttpServletRequest request) {
        
        salaService.deleteSalaById(salaId);
        return ResponseEntity.ok("sala deletada com sucesso.");
    }
    

    @GetMapping("/getbyid/{salaId}")
    public ResponseEntity<SalaResponseDTO> getMedicamentoById(@PathVariable UUID salaId, HttpServletRequest request) {
        UserEntity currentUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (currentUser.getCurrentProfileId() == null) {
            return ResponseEntity.status(400).body(null);
        }

       

        SalaEntity sala = salaService.getById(salaId);


        SalaResponseDTO salaDTO = new SalaResponseDTO(
                sala.getId(),
                sala.getCapacidade(),
                sala.getName());

        return ResponseEntity.ok(salaDTO);
    }

}
