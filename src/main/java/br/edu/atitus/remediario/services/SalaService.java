package br.edu.atitus.remediario.services;

import br.edu.atitus.remediario.entities.SalaEntity;
import br.edu.atitus.remediario.repositories.SalaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

	@Autowired
    private SalaRepository salaRepository;
    

    public SalaEntity saveSala(SalaEntity sala) {
   
        return salaRepository.save(sala);
    }
    
    
    public void deleteSalaById(UUID salaId) {
        Optional<SalaEntity> sala = salaRepository.findById(salaId);
        if (sala.isPresent()) {
            salaRepository.delete(sala.get());
        } else {
            throw new IllegalArgumentException("Medicamento com ID " + salaId + " não encontrado.");
        }
    }
    
    public SalaEntity getById(UUID salaId) {
        return salaRepository.findById(salaId)
                .orElseThrow(() -> new IllegalArgumentException("Medicamento com ID " + salaId + " não encontrado."));
    }
    
    public List<SalaEntity> buscarTodasAsSalas() {
        return salaRepository.findAll();
    }
    
}