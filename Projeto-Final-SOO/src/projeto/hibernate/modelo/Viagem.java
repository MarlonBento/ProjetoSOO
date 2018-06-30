package projeto.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Viagem {

	private Date dataViagem;
	private Integer id;
	
	private String origem;
	private String destino;
	private Funcionario funcionario;
	private List<Usuario> usuario = new ArrayList<>();
	
	
    public Viagem(List<Usuario> usuario) {
		super();
		this.usuario = usuario;
	}
	public Viagem() {}
	public Viagem(Date dataViagem, String origem, String destino, Funcionario funcionario) {
		super();
		this.dataViagem = dataViagem;
		this.origem = origem;
		this.destino = destino;
		this.funcionario = funcionario;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	@ManyToOne
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	


	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(name = "viagem_usuario", 
	joinColumns = @JoinColumn(name = "id_viag" ), 
	inverseJoinColumns = @JoinColumn(name = "id_usr"))
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}