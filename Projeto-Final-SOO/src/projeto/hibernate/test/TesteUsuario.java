package projeto.hibernate.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import projeto.hibernate.modelo.Endereco;
import projeto.hibernate.modelo.Usuario;
import projeto.hibernate.modelo.Viagem;

public class TesteUsuario {
		public static void create (String nome, Integer idade, String ec, Endereco enderecos, String cpf, String contato) {
		Usuario usuario = new Usuario(nome, idade, ec, cpf, contato);	
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		usuario.getEnderecos().add(enderecos);
		session.save(usuario);
		session.getTransaction().commit(); 
		session.close();
}

		
	
	public static void delete(Integer idUsuario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		Usuario usr = read(idUsuario);
		session.delete(usr);		
		session.getTransaction().commit(); 
		session.close();	
		
	}
	

	public static void update(Integer idUsr, String nome, Integer idade, String cpf, String contato, String estadoCivil) {

    	
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		Usuario usr = read(idUsr);

		if (nome.equals("")) {}
		else {usr.setNome(nome);}
		
		if (estadoCivil.equals("")) {}
		else {usr.setEstadoCivil(estadoCivil);}
		
		if (idade==null) {}
		else {usr.setIdade(idade);}
		
		if (cpf.equals("")) {}
		else {usr.setCpf(cpf);}
		
		if (contato.equals("")) {}
		else {usr.setContato(contato);}
		
		session.update(usr);
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	


	public static void nEnd(int id, Endereco end) {
		Usuario usuario = TesteUsuario.read(id);
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		usuario.getEnderecos().add(end);
		session.update(usuario);
		session.getTransaction().commit(); 
		session.close();
		
	}
	public static Usuario read(Integer id) {
		Session session = obterSessionFactory().openSession();
		Usuario usr = (Usuario) session
				.get(Usuario.class, id);
		session.close();
		return usr;
				
		
	}	
	
	public static void list() {
		List<Usuario> list= null;
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		 list = session.createQuery ("select t from Usuario t").list();
               session.getTransaction().commit();
                
               for (Usuario usuario : list) {

                      System.out.println
                       ("ID: "+ usuario.getId() +" Nome: "+ usuario.getNome() +" Idade: " + usuario.getIdade() + " CPF: " + usuario.getCpf());
               }

     }
	

	private static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}
	
	
}
