package projeto.hibernate.test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import projeto.hibernate.modelo.Funcionario;
import projeto.hibernate.modelo.Usuario;
import projeto.hibernate.modelo.Viagem;

public class TesteViagem {
	

	public static void create(Date data, String origem, String destino, int idF, int nUsr) {
			Scanner scan = new Scanner(System.in);
			Funcionario funcionario = TesteFuncionario.read(idF);
			Viagem viagem = new Viagem(data, origem, destino, funcionario);	

			Session session = obterSessionFactory().openSession();
			session.beginTransaction();
			for(int i=0; i<nUsr; i++) {
			System.out.println("Digite o id do usuario");
			Integer idU = Integer.parseInt(scan.nextLine());
		    viagem.getUsuario().add(TesteUsuario.read(idU));
			}
			session.save(viagem);
			session.getTransaction().commit(); 
			session.close();
}
		
		
		public static Viagem read(Integer id) {
			Session session = obterSessionFactory().openSession();
			Viagem viag = (Viagem) session
					.get(Viagem.class, id);
			session.close();
			return viag;
					
			
		}	
		
		
		
		
		
	public static void list() {
		List<Viagem> list= null;
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		 list = session.createQuery ("select t from Viagem t").list();
               session.getTransaction().commit();
                
               for (Viagem viagem : list) {
                      System.out.println
                       ("Viagem id:"+ viagem.getId() + " Data " + viagem.getDataViagem() +" Origem: " + viagem.getOrigem() +" Destino:" +viagem.getDestino());
               }

     }
	
	
	private static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}


}
