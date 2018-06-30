package projeto.hibernate.modelo;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Veiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3476820366105401956L;
	/**
	 * 
	 */
	
	private Integer id;


	private String modelo;	
	private Integer ano;
	



	public Veiculo() {}
	
	public Veiculo(String modelo, Integer ano, Usuario usuario) {
		super();
		this.modelo = modelo;
		this.ano = ano;

	}
	
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
}