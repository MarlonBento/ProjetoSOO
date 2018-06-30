package projeto.hibernate.modelo;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Usuario{


	
	private Integer id;
	private String nome;
	private Integer idade;
    private String estadoCivil;
    private String cpf;
    private String contato;
	private List <Endereco> enderecos = new ArrayList<>();

	

	public Usuario() {}

	public Usuario(String nome, Integer idade, String estadoCivil, String cpf, String contato) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
		this.cpf = cpf;
		this.contato = contato;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	@ElementCollection (fetch = FetchType.EAGER)
	public List <Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List <Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	

}