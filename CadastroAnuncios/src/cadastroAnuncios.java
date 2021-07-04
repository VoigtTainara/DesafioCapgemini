import java.util.Scanner;
import bean.Anuncio;
import dao.AnuncioDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class cadastroAnuncios {

	static DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	static Scanner s = new Scanner (System.in);
	
	public static void main(String[] args) {
	
		int opcao = 0;
		while (opcao!=4) {
			opcao = selecionaopcao("O que você deseja fazer? Digite 1 - Incluir novo anúncio;"
				+ "2 - Ver relatório (por cliente); 3 - Ver relatório (por intervalo de tempo);"
				+ "4 - Sair ");
			
			try {
				if (opcao==1) {
					System.out.println("Opção 1!");
					String nomeAnuncio;
					String cliente;
					String dataInicio;
					String dataTermino;
					double investimento;
					
					Scanner s = new Scanner (System.in);
					System.out.println("Informe um nome para o anúncio:");
					nomeAnuncio = s.next();
					System.out.println("Informe qual o cliente:");
					cliente = s.next();
					System.out.println("Informe uma data de início dos investimentos (dd/MM/yyyy)");		
					dataInicio = s.next(); 
					System.out.println("Informe uma data de término dos investimentos (dd/MM/yyyy");	
					dataTermino = s.next();
					System.out.println("Informe o investimento diário realizado");
				    investimento = s.nextDouble();
				    
				    Anuncio a =  new Anuncio(nomeAnuncio, cliente, dataInicio, dataTermino, investimento);
				    AnuncioDAO ad = new AnuncioDAO();
				    ad.salvar(a);
				} else if (opcao == 2) {
					System.out.println("Opção 2!");
					String nomeCliente = null;
					System.out.println("Você deseja ver o relatório de qual cliente?");
					nomeCliente = s.next();
					List<Anuncio> a = new ArrayList<Anuncio>();
					AnuncioDAO ad = new AnuncioDAO();
					a = ad.buscarPorNome(nomeCliente);
					mostrarrelatorio(a);
				} else if (opcao == 3) {
					System.out.println("Opção 3!");
					String dataInicio;
					String dataTermino;
					System.out.println("Informe uma data de início para busca de anúncios"
							+ "ativos");
					dataInicio = s.next();
					System.out.println("Informe uma data de término para busca de anúncios"
							+ "ativos");
					dataTermino = s.next();
					List<Anuncio> a = new ArrayList<Anuncio>();
					AnuncioDAO ad = new AnuncioDAO();
					a = ad.buscarPorIntervaloTempo(dataInicio, dataTermino);
					mostrarrelatorio(a);
				} else if (opcao == 4){
					s.close();
					System.out.println("e saiu");
				} else {
					System.out.println("Selecione uma das opções possíveis!");
				}
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void mostrarrelatorio(List<Anuncio> a) {
		for (int i=0; i<=a.size(); i++) {
			long dias = cadastroAnuncios.calcular(a.get(i).getDataInicio(), a.get(i).getDataTermino());
		    System.out.println ("dias: "+dias);
			
			double valInvestido= dias * a.get(i).getInvestimento(); //50
			int visualizacoes = (int) (valInvestido * 30); //1500 
			int visualizacoestotal = visualizacoes; //1500
			int cliques = (visualizacoes* 12)/ 100; //180
			int cliquestotal = cliques;
			int compartilhamentos = (cliques*3)/20; //27
			int compartilhamentostotal = compartilhamentos;
			
			int con = 1;
			
			while(con!=5){
		    	visualizacoes = 40;
				int visualizacoesComp = compartilhamentos*visualizacoes; //1080
				visualizacoestotal = visualizacoestotal + visualizacoesComp;//2580
				cliques = (visualizacoesComp* 12)/ 100; // 4,8
				cliquestotal = cliquestotal + cliques;
				compartilhamentos = (cliques*3)/20;//0,6
				compartilhamentostotal = compartilhamentostotal + compartilhamentos;
				con++;
			}
			
			System.out.println("O valor investido nesse anúncio foi de: "+valInvestido);
			System.out.println("A quantidade de vezes que esse anúncio foi visualizado foi de: "+ visualizacoestotal);
			System.out.println("A quantidade de vezes que esse anúncio foi clicado foi de: "+ cliquestotal);
			System.out.println("A quantidade de vezes que esse anúncio foi compartilhado foi de: "+ compartilhamentostotal);
		}
	}
	
	public static int selecionaopcao (String msg) {
		int opcaoselecionada = 0;
		try {
			System.out.println(msg);
			opcaoselecionada =  s.nextInt();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
		return opcaoselecionada;
	}
	
	public static long calcular (String inicio, String fim) {
        Date dtInicial = null, dtFinal = null;
		try {
			dtInicial = df.parse (inicio);
			dtFinal = df.parse (fim);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (dtFinal.getTime() - dtInicial.getTime() + 3600000L) / 86400000L;
      
    }

}
