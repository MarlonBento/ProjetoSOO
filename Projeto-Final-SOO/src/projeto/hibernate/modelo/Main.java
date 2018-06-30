package projeto.hibernate.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import projeto.hibernate.test.TesteFuncionario;
import projeto.hibernate.test.TesteUsuario;
import projeto.hibernate.test.TesteViagem;


public class Main {
	private static Scanner entrada;
	private static Scanner func;


	public static void main(String[] args) throws ParseException {
		entrada = new Scanner(System.in);   
        int escolha;  
        boolean continuar;
    	do {   
	    System.out.println("O que deseja alterar?");
        System.out.println("1. Funcionario");
        System.out.println("2. Cliente");
        System.out.println("3. Viagem");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
        
       
        escolha = Integer.parseInt(entrada.nextLine());  

        switch (escolha) {  
	        case 1:  
	        	menuFunc();
	            continuar = true;
	            break;  
	        case 2:  
	        	menuClien(); 
	        	continuar = true;
	            break;  
	        case 3:  
	        	menuViag();
	        	continuar = true;
	            break; 

	        case 0: 
	        	continuar = false;
	        	break;
	        default: 
	        	System.out.println("\n");
	        	System.out.println("Operacao Invalida!");
	        	System.out.println("\n");
	            continuar = true;
	            break;  
	    }  
	} while (continuar);  
	}


	

	private static void menuViag() throws ParseException {
		Scanner entradaV = new Scanner(System.in); 
		Scanner viag = new Scanner(System.in);   
        int escolha;  
        boolean continuar;

		
		do {   
		    System.out.println("Qual opcao deseja realizar?");
	        System.out.println("1. Inserir Viagem");
	        System.out.println("2. Buscar Viagem");
	        System.out.println("3. Listar Viagens");
	        System.out.println("0. Voltar");
	        System.out.println("Opcao:");
	        
	       
	        escolha = Integer.parseInt(entradaV.nextLine());  
	       
	        switch (escolha) {  
		        case 1:  
		        	System.out.println("Digite a Data da Viagem dd/mm/yyyy");
		        	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		        	Date data = formato.parse(viag.nextLine());
		            System.out.println("Digite a Origem da viagem");
		            String origem = viag.nextLine();
		            System.out.println("Digite o Destino da viagem");
		            String destino = viag.nextLine();
		            System.out.println("Digite a ID do Funcionario encarregado da viagem");
		            Integer idFun = Integer.parseInt(viag.nextLine());
		            System.out.println("Digite o numero de passageiros");
		            Integer nUsr = Integer.parseInt(viag.nextLine());     
		            TesteViagem.create(data, origem, destino, idFun, nUsr);
		            continuar = true;
		            break;  
		        case 2:
		        	System.out.println("Digite o id da viagem que deseja buscar");
		        	Viagem viagem = TesteViagem.read(Integer.parseInt(viag.nextLine()));
		        	System.out.println("ID: "+ viagem.getId() + " Data " + viagem.getDataViagem() + " Origem: "+ viagem.getOrigem() +" Destino: " + viagem.getDestino() );
		        	continuar = true;
		        	continuar = true;
		        	break;
		        case 3:  
		        	TesteViagem.list();
		        	
		            continuar = true;
		            break;  		        	
		        case 0:
		        	continuar = false;
		        	break;
		        default: 
		        	System.out.println("\n");
		        	System.out.println("Operacao Invalida!");
		        	System.out.println("\n");
		            continuar = true;
		            break;  
		    }  
		} while (continuar);  
	
	}
		
	




	private static void menuClien() {
		Scanner entradaU = new Scanner(System.in); 
		Scanner usr = new Scanner(System.in);   
        int escolha;  
        boolean continuar;

		
		do {   
		    System.out.println("Qual opcao deseja realizar?");
	        System.out.println("1. Inserir Cliente");
	        System.out.println("2. Alterar Cliente");
	        System.out.println("3. Deletar Cliente");
	        System.out.println("4. Buscar Cliente");
	        System.out.println("5. Adicionar novo endereco a cliente");
	        System.out.println("6. Listar Clientes");
	        System.out.println("0. Voltar");
	        System.out.println("Opcao:");
	        
	       
	        escolha = Integer.parseInt(entradaU.nextLine());  
	       
	        switch (escolha) {  
		        case 1:  
		        	Endereco endereco = new Endereco();
		        	System.out.println("Digite o nome do Usuario");
		        	String nome = usr.nextLine();
		        	System.out.println("Digite a idade do Usuario");
		        	Integer idade = Integer.parseInt(usr.nextLine());
		        	System.out.println("Digite estado civil do Usuario");
		        	String ec = usr.nextLine();	
		        	System.out.println("Digite o CPF do usuario");
		        	String cpf = usr.nextLine();	
		        	System.out.println("Digite o contato do usuario");
		        	String contato = usr.nextLine();	
		        	System.out.println("Inserir endereco principal");
		        	System.out.println("                          ");
		        	System.out.println("Digite o logradouro");
		        	endereco.setLogradouro(usr.nextLine());
		        	System.out.println("Digite o numero");
		        	endereco.setNumero(Integer.parseInt(usr.nextLine()));
		        	System.out.println("Digite a cidade");
		        	endereco.setCidade(usr.nextLine());
		        	TesteUsuario.create(nome,  idade, ec, endereco, cpf, contato);	
		            continuar = true;
		            break;  
		        case 2:  
		         	System.out.println("Digite o id do Cliente");
		        	Integer id = Integer.parseInt(usr.nextLine());
		        	System.out.println("Digite o novo nome do Cliente");
		        	nome = usr.nextLine();
		        	System.out.println("Digite a nova idade do Cliente");
		        	idade = Integer.parseInt(usr.nextLine());
		        	System.out.println("Digite o novo cpf do Cliente");
		        	cpf = usr.nextLine();
		        	System.out.println("Digite o novo contato do Cliente");
		        	contato = usr.nextLine();
		        	System.out.println("Digite o novo estado civil do Usuario");
		        	 ec = usr.nextLine();	
		        	TesteUsuario.update(id, nome, idade, cpf, contato, ec); 	
		            continuar = true;
		            break;  

		        case 3:  
		        	System.out.println("Digite o id do cliente que deseja deletar");
		        	Integer idU = Integer.parseInt(usr.nextLine());
		        	continuar = true;
		        	TesteUsuario.delete(idU);
		        	continuar = true;
		            break; 
		        case 4:
		        	System.out.println("Digite o id do cliente que deseja buscar");
		        	Usuario usuario = TesteUsuario.read(Integer.parseInt(usr.nextLine()));
		        	System.out.println("ID: "+ usuario.getId() +" Nome: "+ usuario.getNome() +" Idade: " + usuario.getIdade() + " CPF: " + usuario.getCpf());
		        	continuar = true;
		            break;     
		        case 5: 
		        	endereco = new Endereco();
		        	System.out.println("Digite o id do Cliente");
		        	Integer idC = Integer.parseInt(usr.nextLine());
		        	System.out.println("Inserir endereco novo");
		        	System.out.println("                          ");
		        	System.out.println("Digite o novo logradouro");
		        	endereco.setLogradouro(usr.nextLine());
		        	System.out.println("Digite o novo numero");
		        	endereco.setNumero(Integer.parseInt(usr.nextLine()));
		        	System.out.println("Digite a nova cidade");
		        	endereco.setCidade(usr.nextLine());
		        	TesteUsuario.nEnd(idC, endereco);
		        	continuar = true;
		        	break;
		        case 6:
		        	TesteUsuario.list();
		            continuar = true;
		            break;  		        	
		        case 0:
		        	continuar = false;
		        	break;
		        default: 
		        	System.out.println("\n");
		        	System.out.println("Operacao Invalida!");
		        	System.out.println("\n");
		            continuar = true;
		            break;  
		    }  
		} while (continuar);  
	
	}
	
	
	
	private static void menuFunc() throws ParseException {
		Scanner entradaF = new Scanner(System.in);   
		func = new Scanner(System.in);
        int escolha;  
        boolean continuar;
		
	  	do {   
		    System.out.println("Qual alteracao deseja realizar?");
	        System.out.println("1. Inserir Funcionario ");
	        System.out.println("2. Alterar Funcionario");
	        System.out.println("3. Deletar Funcionario");
	        System.out.println("4. Buscar Funcionario");
	        System.out.println("5. Adicionar Veiculo a Funcionario");
	        System.out.println("6. Listar Funcionarios");
	        System.out.println("0. Voltar");
	        System.out.println("Opcao:");
	        
	       
	        escolha = Integer.parseInt(entradaF.nextLine());  

	        switch (escolha) {  
		        case 1:  
		        	Veiculo veiculo = new Veiculo();
		        	System.out.println("Digite o nome do funcionario");
		        	String nome = func.nextLine();
		 	        System.out.println("Digite o cpf do funcionario");
		 	        String cpf = func.nextLine();
		 	        System.out.println("Digite o contato do funcionario");
		 	        String contato = func.nextLine();
		 	        System.out.println("Digite o salario");
		 	        Double salario = Double.parseDouble(func.nextLine()); 
			 	   	System.out.println("        ");
			 	   	System.out.println("        ");
			 	   	System.out.println("Inserir veiculo");
			 	   	System.out.println("");		 	   	
			 	   	System.out.println("Digite o modelo");
			 	   	veiculo.setModelo(func.nextLine());
			 	   	System.out.println("Digite o ano do veiculo");
			 	   	veiculo.setAno(Integer.parseInt(func.nextLine()));
		        	TesteFuncionario.create(nome, cpf, salario, new Date(), contato, veiculo);
		            continuar = true;
		            break;  
		        case 2:  
		        	System.out.println("Digite o id do funcionario");
		        	Integer id = Integer.parseInt(func.nextLine());
		        	System.out.println("Digite o novo nome");
		        	nome = func.nextLine();
		        	System.out.println("Digite o novo cpf");
		        	cpf = func.nextLine();
		        	System.out.println("Digite o novo salario");
		        	salario = Double.parseDouble(func.nextLine()); 
		        	System.out.println("Digite o novo contato");
		        	contato = func.nextLine();
		        	
		        	TesteFuncionario.update(id, nome, cpf, salario, contato);
		        	continuar = true;
		            break;  
		        case 3:  
		        	System.out.println("Digite o id do funcionario que deseja deletar");
		        	id = Integer.parseInt(func.nextLine());
		        	continuar = true;
		        	TesteFuncionario.delete(id);
		            break; 
		        case 4:  
		        	System.out.println("Digite o id do funcionario que deseja buscar");    	
		        	Funcionario funcionario = TesteFuncionario.read(Integer.parseInt(func.nextLine()));
		        	System.out.println("Nome: "+funcionario.getNome() +"  CPF: " + funcionario.getCpf());
		        	continuar = true;
		            break;
		        case 5:
		         	veiculo = new Veiculo();
		        	System.out.println("Digite o id do Funcionario");
		        	Integer idF = Integer.parseInt(func.nextLine());
		        	System.out.println("Inserir veiculo");
		        	System.out.println("");
		        	System.out.println("Digite o modelo");
		        	veiculo.setModelo(func.nextLine());
		        	System.out.println("Digite o ano do veiculo");
		        	veiculo.setAno(Integer.parseInt(func.nextLine()));
		        	TesteFuncionario.nCar(idF, veiculo);
		        	continuar = true;
		        	break;
		        case 6: 
		        	TesteFuncionario.list();
		            continuar = true;
		            break;  	
		        case 0: 
		        	continuar = false;
		        	break;
		        default: 
		        	System.out.println("\n");
		        	System.out.println("Operacao Invalida!");
		        	System.out.println("\n");
		            continuar = true;
		            break;  
		    }  
		} while (continuar);  
		
		
	
	}
}
