import javax.swing.*;
class Funcao{
	public static Variavel[] laco(int i,int f,String[] texto,Variavel[] vars,Executa inicio){
		int aux,nlinhas,chave;
		int laco=1,se;
		Variavelimite[] limite;
		limite = new Variavelimite[2];
		limite[0] = new Variavelimite();
		limite[0].setNome("inicio");
		limite[1] = new Variavelimite();
		limite[1].setNome("fim");
		Executa[] menu;
		menu = new Executa[7];
		for(aux=0;aux<menu.length;aux++){
			menu[aux] = new Executa();
		}
		menu[0].setNome("declaracao");
		menu[1].setNome("atribuicao");
		menu[2].setNome("expressao");
		menu[3].setNome("comparacao");
		menu[4].setNome("loop");
		menu[5].setNome("select");
		menu[6].setNome("screen");
		String teste,comp,linha = null;
		System.out.println("Função!"+"||==========================================||");
		while(laco==1){
			nlinhas = i+1;
			linha = texto[nlinhas];
			while(nlinhas<f){
				limite = Analise.frase(linha,limite);
				System.out.println("Função!"+"||"+linha+"||"+"Linha "+nlinhas);
				System.out.println("Função!"+"||Analise Terminada||");
				if(linha.contains("}")==true){
					limite[0].valor = limite[1].valor + 1;
				}
				if(limite[0].valor<limite[1].valor){
					teste = linha.substring(limite[0].valor,limite[1].valor);
					System.out.println("Função!"+"||"+teste+"||"+"Linha "+nlinhas);
					menu = Interpretador.interpreta(teste,menu);
					System.out.println("Função!"+"||Interpretaçao Terminada||");
					if(menu[0].status){
						teste = teste.substring(0,menu[1].indice);
						vars = Declara.insere(teste,vars,linha);
						if(vars==null){
							return vars;
						}
					}
					if(menu[1].status){
						if(menu[2].status){
							teste = linha.substring(limite[0].valor,limite[1].valor);
							teste = Expressao.opera(teste,menu,vars);
							if(teste!=null){
								vars = Declara.atribui(teste,menu[1],vars);
								if(vars==null){
									return vars;
								}
							}else{
								return null;
							}
						}else{
							teste = linha.substring(limite[0].valor,limite[1].valor);
							vars = Declara.atribui(teste,menu[1],vars);
							if(vars==null){
								return vars;
							}
						}
					}
					if(menu[3].status){	
						if(menu[4].status){
							teste = linha.substring(limite[0].valor,limite[1].valor);
							laco = Compare.compara(teste,menu[3],vars);
							chave = Agiliza.percore(texto,nlinhas);
							System.out.println("Função! chave = "+chave);
							System.out.println("Função! f = "+f);
							System.out.println("Função! i = "+i);
							System.out.println("Função! nlinhas = "+nlinhas);
							if(laco==1&&chave!=-1){
								System.out.println("Função!"+"laço(true)");
								vars = Funcao.laco(nlinhas,chave,texto,vars,menu[3]);
								nlinhas = chave;
								if(vars==null){
									return null;
								}
							}else if(laco==0&&chave!=-1){
								System.out.println("Função!"+"laço(false)");
								nlinhas = chave;
							}else{
								return null;
							}
						}
						if(menu[5].status){
							teste = linha.substring(limite[0].valor,limite[1].valor);
							se = Compare.compara(teste,menu[3],vars);
							chave = Agiliza.percore(texto,nlinhas);
							if(se==1){
							}else if(se==0){
							}else{
								return null;
							}
						}
					}
				}
				System.out.println("Função!"+"vars a = "+vars[0].valor);
				System.out.println("Função!"+"vars b = "+vars[1].valor);
				System.out.println("Função!"+"vars c = "+vars[2].valor);
				nlinhas++;
				for(int count=0;count<menu.length;count++){
					menu[count].setStatus();
				}
				if(nlinhas<f){
					linha = texto[nlinhas];
				}
			}
			System.out.println("Função!"+"||-------------------------------------------------------------||");
			linha = texto[i];
			limite = Analise.frase(linha,limite);
			teste = linha.substring(limite[0].valor,limite[1].valor);
			laco = Compare.compara(teste,inicio,vars);
		}
		return vars;
	}
};
