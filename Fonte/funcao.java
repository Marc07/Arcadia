/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa métodos de laço e seleção de fluxo*/
import javax.swing.*;
class Funcao{
	public static Variavel[] repeticao(int i,int f,String[] texto,Variavel[] vars,Executa inicio){
		int aux,nlinhas,chave;
		int laco=1,se=0;
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
		while(laco==1){
			nlinhas = i+1;
			linha = texto[nlinhas];
			while(nlinhas<f){
				limite = Analise.frase(linha,limite);
				if(linha.contains("}")==true){
					limite[0].valor = limite[1].valor + 1;
				}
				if(limite[0].valor<limite[1].valor){
					teste = linha.substring(limite[0].valor,limite[1].valor);
					menu = Interpretador.interpreta(teste,menu);
					if(menu[0].status){
						if(menu[1].status){
							teste = teste.substring(0,menu[1].indice);
							vars = Declara.insere(teste,vars,linha);
							if(vars==null){
								return null;
							}
						}else{
							teste = linha.substring(limite[0].valor,linha.length());
							vars = Declara.insere(teste,vars,linha);
							if(vars==null){
								return null;
							}
						}
					}
					if(menu[1].status){
						if(menu[2].status){
							teste = linha.substring(limite[0].valor,limite[1].valor);
							teste = Expressao.opera(teste,menu,vars);
							if(teste!=null){
								vars = Declara.atribui(teste,menu[1],vars);
								if(vars==null){
									return null;
								}
							}else{
								return null;
							}
						}else{
							teste = linha.substring(limite[0].valor,limite[1].valor);
							vars = Declara.atribui(teste,menu[1],vars);
							if(vars==null){
								return null;
							}
						}
					}
					if(menu[3].status){	
						if(menu[4].status){
							teste = linha.substring(limite[0].valor,limite[1].valor);
							laco = Compare.compara(teste,menu[3],vars);
							chave = Agiliza.percore(texto,nlinhas);
							if(laco==1&&chave!=-1){
								vars = Funcao.repeticao(nlinhas,chave,texto,vars,menu[3]);
								nlinhas = chave;
								if(vars==null){
									return null;
								}
							}else if(laco==0&&chave!=-1){
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
								vars = Funcao.selecao(nlinhas,chave,texto,vars);
								nlinhas = chave;
								if(vars==null){
									return null;
								}
							}else if(se==0){
								nlinhas = chave;
							}else{
								return null;
							}
						}
					}
					if(menu[6].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						vars = Tela.dialogbox(teste,menu[1],vars);
						if(vars==null){
							return null;
						}
					}
				}
				nlinhas++;
				for(int count=0;count<menu.length;count++){
					menu[count].setStatus();
					menu[count].indice = 0;
				}
				if(nlinhas<f){
					linha = texto[nlinhas];
				}
			}
			linha = texto[i];
			limite = Analise.frase(linha,limite);
			teste = linha.substring(limite[0].valor,limite[1].valor);
			laco = Compare.compara(teste,inicio,vars);
		}
		return vars;
	}
	public static Variavel[] selecao(int i,int f,String[] texto,Variavel[] vars){
		int aux,nlinhas,chave;
		int laco=0,se = 0;
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
		nlinhas = i+1;
		linha = texto[nlinhas];
		while(nlinhas<f){
			limite = Analise.frase(linha,limite);
			if(linha.contains("}")==true){
				limite[0].valor = limite[1].valor + 1;
			}
			if(limite[0].valor<limite[1].valor){
				teste = linha.substring(limite[0].valor,limite[1].valor);
				menu = Interpretador.interpreta(teste,menu);
				if(menu[0].status){
					if(menu[1].status){
						teste = teste.substring(0,menu[1].indice);
						vars = Declara.insere(teste,vars,linha);
						if(vars==null){
							return null;
						}
					}else{
						teste = linha.substring(limite[0].valor,linha.length());
						vars = Declara.insere(teste,vars,linha);
						if(vars==null){
							return null;
						}
					}
				}
				if(menu[1].status){
					if(menu[2].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						teste = Expressao.opera(teste,menu,vars);
						if(teste!=null){
							vars = Declara.atribui(teste,menu[1],vars);
							if(vars==null){
								return null;
							}
						}else{
							return null;
						}
					}else{
						teste = linha.substring(limite[0].valor,limite[1].valor);
						vars = Declara.atribui(teste,menu[1],vars);
						if(vars==null){
							return null;
						}
					}
				}
				if(menu[3].status){	
					if(menu[4].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						laco = Compare.compara(teste,menu[3],vars);
						chave = Agiliza.percore(texto,nlinhas);
						if(laco==1&&chave!=-1){
							vars = Funcao.repeticao(nlinhas,chave,texto,vars,menu[3]);
							nlinhas = chave;
							if(vars==null){
								return null;
							}
						}else if(laco==0&&chave!=-1){
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
								vars = Funcao.selecao(nlinhas,chave,texto,vars);
								nlinhas = chave;
								if(vars==null){
									return null;
								}
							}else if(se==0){
								nlinhas = chave;
							}else{
								return null;
							}
					}
				}
				if(menu[6].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						vars = Tela.dialogbox(teste,menu[1],vars);
						if(vars==null){
							return null;
						}
				}
			}
			nlinhas++;
			for(int count=0;count<menu.length;count++){
				menu[count].setStatus();
				menu[count].indice = 0;
			}
			if(nlinhas<f){
				linha = texto[nlinhas];
			}
		}
		return vars;
	}
};
