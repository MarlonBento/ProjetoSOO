package projeto.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import projeto.hibernate.modelo.Veiculo;

public class TesteVeiculo {


	public static Veiculo read(Integer id) {
		Session session = obterSessionFactory().openSession();
		Veiculo veic = (Veiculo) session
				.get(Veiculo.class, id);
		session.close();
		return veic;
				
		
	}	
	

	private static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}
}
