import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double valInvestido;
		
		System.out.println("Informe o valor investido (em reais) no anúncio");
		valInvestido= s.nextDouble(); //50
		int visualizacoes = (int) (valInvestido * 30); 
		int visualizacoestotal = visualizacoes;
		int cliques = (visualizacoes* 12)/ 100;
		int compartilhamentos = (cliques*3)/20;
		
		System.out.println("Visualização com o primeiro compartilhamento: "+ visualizacoestotal);
		visualizacoes = 40;
		int visualizacoesPrimeiroComp = compartilhamentos*visualizacoes;
		visualizacoestotal = visualizacoestotal + visualizacoesPrimeiroComp;
		cliques = (visualizacoesPrimeiroComp* 12)/ 100;
		int compartilhamentosPrimeiroComp = (cliques*3)/20;
		
		System.out.println("Visualização com o segundo compartilhamento:" +visualizacoestotal);
		visualizacoes = 40;
		int visualizacoesSegundoComp = compartilhamentosPrimeiroComp*visualizacoes;
		visualizacoestotal = visualizacoestotal + visualizacoesSegundoComp;
		cliques = (visualizacoesSegundoComp* 12)/ 100;
		int compartilhamentosSegundoComp = (cliques*3)/20;
		
		System.out.println("Visualização com o terceiro compartilhamento:"+visualizacoestotal);
		visualizacoes = 40;
		int visualizacoesTerceiroComp = compartilhamentosSegundoComp*visualizacoes; 
		visualizacoestotal = visualizacoestotal + visualizacoesTerceiroComp;
		cliques = (visualizacoesTerceiroComp* 12)/ 100;
		int compartilhamentosTerceiroComp = (cliques*3)/20;
		
		System.out.println("Visualização com o quarto compartilhamento:"+visualizacoestotal);
		visualizacoes = 40;
		int visualizacoesQuartoComp = compartilhamentosTerceiroComp*visualizacoes; 
		visualizacoestotal = visualizacoestotal + visualizacoesQuartoComp;
		
		System.out.println("A quantidade de vezes que esse anúncio foi visualizado foi de: "+ visualizacoestotal);
		s.close();
	};

}
