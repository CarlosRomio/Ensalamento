package br.edu.atitus.remediario.dtos.response;

import java.util.UUID;

public class SalaResponseDTO {

    private UUID id;
    private String name;
    private int capacidade;


    public SalaResponseDTO(UUID id, int capacidade, String name) {
        this.id = id;
        this.capacidade = capacidade;
        this.name = name;
    }

	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}
