package redebayesiana;

public class Probabilidade {

	private Double belief[][] = new Double[2][1];
	private Double lambdaPai[][] = new Double[2][1];

	public Double[][] beliefPaiFilho(Double beliefPai[][], Double pi[][], Double oldLambdaPai[][]) {
		beliefPai[0][0] = beliefPai[0][0] /  oldLambdaPai[0][0];
		beliefPai[1][0] = beliefPai[1][0] /  oldLambdaPai[1][0];
		
		
		belief[0][0] = pi[0][0] * beliefPai[0][0] + pi[1][0] * beliefPai[1][0];
		belief[1][0] = pi[0][1] * beliefPai[0][0] + pi[1][1] * beliefPai[1][0];

		return belief;

	}

	public Double[][] beliefEvento(Double beliefAtual[][], Double lambda[][]) {
		Double soma = new Double(0.0);
		belief[0][0] = lambda[0][0] * beliefAtual[0][0];
		belief[1][0] = lambda[1][0] * beliefAtual[1][0];
		soma = 1 / (belief[0][0] + belief[1][0]);
		belief[0][0] = soma * belief[0][0];
		belief[1][0] = soma * belief[1][0];
		return belief;

	}
	
	public Double[][]lambdaFilhoPai(Double lambdaPaiAtual[][], Double novoLambdaFilho[][], Double filhoPi[][] ){
		belief[0][0] =  filhoPi[0][0] * novoLambdaFilho[0][0] + filhoPi[0][1] * novoLambdaFilho[1][0];
		belief[1][0] =  filhoPi[1][0] * novoLambdaFilho[0][0] + filhoPi[1][1] * novoLambdaFilho[1][0];
		lambdaPai[0][0] = belief[0][0] * lambdaPaiAtual[0][0];
		lambdaPai[1][0] = belief[1][0] * lambdaPaiAtual[1][0];
		return lambdaPai;
	}
	
	
	/*	public Double[][] paiFilhoBilefOldLambda(Double oldLambdaPai[][], Double beliefPai[][] ){//procedimento de passar o biliefe do pai qunado o pai teve o lambada alteraado
		belief[0][0] = beliefPai[0][0] /  oldLambdaPai[0][0];
		belief[1][0] = beliefPai[1][0] /  oldLambdaPai[1][0];
		
		
		return belief;
	}

	public static void main(String[] args) {
		Double testeP[][] = new Double[2][2];
		Double testeBilipai[][] = new Double[2][1];
		Double lambdaPai[][] = new Double[2][1];
		Double resultado[][] = new Double[2][1];
		Double oldLambdaPai[][] = new Double[2][1];
		Probabilidade teste = new Probabilidade();
		//teste belief inicial
		System.out.println("teste beliefInicial");
		oldLambdaPai[0][0] = 1.0;
		oldLambdaPai[1][0] = 1.0;
		testeBilipai[0][0] = 0.1;
		testeBilipai[1][0] = 0.9;
		testeP[0][0] = 0.6;
		testeP[1][0] = 0.0;
		testeP[0][1] = 0.4;
		testeP[1][1] = 1.0;
		resultado = teste.beliefPaiFilho(testeBilipai, testeP, oldLambdaPai);
		System.out.println(resultado[0][0]);
		System.out.println(resultado[1][0]);
		//Teste belief evento
		System.out.println("teste beliefEvento");
		Double beliefAtual[][]=new Double[2][1];
		Double lambda[][]=new Double[2][1];	
		beliefAtual[0][0] = 0.06;
		beliefAtual[1][0] = 0.94;
		lambda[0][0] = 0.8;
		lambda[1][0] = 0.04;
		resultado = new Double[2][1];
		resultado = teste.beliefEvento(beliefAtual, lambda);
		System.out.println(resultado[0][0]);
		System.out.println(resultado[1][0]);
		//teste lambda novo pai
		System.out.println("teste Novo Lambada Pai");
		lambda[0][0] = 1.0;
		lambda[1][0] = 0.02;
		
		testeP[0][0] = 0.1;
		testeP[1][0] = 0.7;
		testeP[0][1] = 0.9;
		testeP[1][1] = 0.3;
		
		lambdaPai[0][0] = 0.5;
		lambdaPai[1][0] = 0.04;
		
		resultado = teste.lambdaFilhoPai(lambdaPai, lambda, testeP);
		System.out.println(resultado[0][0]);
		System.out.println(resultado[1][0]);
		
	}*/
	
	
	
}
