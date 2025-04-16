
package br.edu.atitus.remediario.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sala")
public class SalaEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "uuid", updatable = false, nullable = false)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int capacidade;

	public SalaEntity() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}
