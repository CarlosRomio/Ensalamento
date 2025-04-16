package br.edu.atitus.remediario.dtos.request;


public class SalaRequestDTO {
    
    private String name;
    
    private int capacidade;
  

    public SalaRequestDTO() {
    	
    }

    public SalaRequestDTO(String name, int capacidade) {
        
        this.name = name;
        this.capacidade = capacidade;
      
    }

    public String getName() {
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
