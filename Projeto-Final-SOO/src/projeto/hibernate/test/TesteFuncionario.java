package projeto.hibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import projeto.hibernate.modelo.Funcionario;
import projeto.hibernate.modelo.Usuario;
import projeto.hibernate.modelo.Veiculo;

public class TesteFuncionario {
		
	
	

	public static void create (String nome, String cpf, double salario, Date dataAd, String contato, Veiculo veic) {
		Funcionario funcionario = new Funcionario(nome, cpf, salario, dataAd , contato);
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		funcionario.getVeiculos().add(veic);
		session.save(veic);
		session.save(funcionario);
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	public static Funcionario read(Integer idFuncionario) {
		Session session = obterSessionFactory().openSession();
		Funcionario funcionario = (Funcionario) session
				.get(Funcionario.class, idFuncionario);
		session.close();
		return funcionario;
		
				
		
	}

	
	public static void update(Integer idFuncionario, String nome, String cpf, Double salario,String contato) {
		
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		Funcionario funcT = read(idFuncionario);
		
		if (cpf.equals("")) {}
		else {funcT.setCpf(cpf);}
		
		if (nome.equals("")) {}
		else {funcT.setNome(nome);}
		
		if (salario==null) {}
		else {funcT.setSalario(salario);}
		
		if (contato.equals("")) {}
		else {funcT.setContato(contato);}


		session.update(funcT);
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	public static void nCar(int id, Veiculo veic) {
		Funcionario funcionario = TesteFuncionario.read(id);
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		funcionario.getVeiculos().add(veic);
		session.update(funcionario);
		session.save(veic);
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	
	public static void delete(Integer idFuncionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		Funcionario funcD = read(idFuncionario);
		session.delete(funcD);		
		session.getTransaction().commit(); 
		session.close();	
		
	}
	
	public static void list() {
		List<Funcionario> list= null;
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		 list = session.createQuery ("select t from Funcionario t").list();
               session.getTransaction().commit();
               for (Funcionario funcionario : list) {
                      System.out.println("ID: "+ funcionario.getId() +" Nome: "+ funcionario.getNome() +"  CPF: " + funcionario.getCpf());
               }

     }

	private static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}



}
