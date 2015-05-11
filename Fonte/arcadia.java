import javax.swing.*;
class Arcadia{
	public static void main (String args[]){
		int se,laco, i,nlinhas = 0;
		Variavelimite[] limite;
		limite = new Variavelimite[2];
		limite[0] = new Variavelimite();
		limite[0].setNome("inicio");
		limite[1] = new Variavelimite();
		limite[1].setNome("fim");
		Executa[] menu;
		menu = new Executa[7];
		for(i=0;i<menu.length;i++){
			menu[i] = new Executa();
		}
		menu[0].setNome("declaracao");
		menu[1].setNome("atribuicao");
		menu[2].setNome("expressao");
		menu[3].setNome("comparacao");
		menu[4].setNome("loop");
		menu[5].setNome("select");
		menu[6].setNome("screen");
		Variavel[] vars;
		vars = new Variavel[5];
		Variavel inserir;
		inserir = new Variavel();
		String[] arquivo;
		arquivo = Converte.convertstring(args,limite);
		String teste,aux,linha = null;
		if(arquivo==null){
			return ;
		}
		linha = arquivo[0];
		while(linha!=null){
			limite = Analise.frase(linha,limite);
			if(limite[0].valor<limite[1].valor){
				teste = linha.substring(limite[0].valor,limite[1].valor);
				menu = Interpretador.interpreta(teste,menu);
				if(menu[0].status){
					if(menu[1].status){
						teste = teste.substring(0,menu[1].indice);
						vars = Declara.insere(teste,vars,linha);
						if(vars==null){
							return;
						}
					}else{
						teste = linha.substring(limite[0].valor,linha.length());
						vars = Declara.insere(teste,vars,linha);
						if(vars==null){
							return;
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
								return;
							}
						}else{
							return;
						}
					}else{
						teste = linha.substring(limite[0].valor,limite[1].valor);
						vars = Declara.atribui(teste,menu[1],vars);
						if(vars==null){
							return;
						}
					}
				}
				if(menu[3].status){	
					if(menu[4].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						laco = Compare.compara(teste,menu[3],vars);
						i = Agiliza.percore(arquivo,nlinhas);
						if(laco==1&&i!=-1){
							vars = Funcao.repeticao(nlinhas,i,arquivo,vars,menu[3]);
							nlinhas = i;
							if(vars==null){
								return;
							}
						}else if(laco==0&&i!=-1){
							nlinhas = i;
						}else{
							return;
						}
					}
					if(menu[5].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						se = Compare.compara(teste,menu[3],vars);
						i = Agiliza.percore(arquivo,nlinhas);
						if(se==1){
							vars = Funcao.selecao(nlinhas,i,arquivo,vars);
							nlinhas = i;
							if(vars==null){
								return;
							}
						}else if(se==0){
							nlinhas = i;
						}else{
							return;
						}
					}
				}
				if(menu[6].status){
						teste = linha.substring(limite[0].valor,limite[1].valor);
						vars = Tela.dialogbox(teste,menu[1],vars);
						if(vars==null){
							return;
						}
				}
			}else{
				aux = "Caracter de Terminação Não Encontrado na Linha\n"+linha;
				JOptionPane.showMessageDialog (null, aux, "Erro!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			nlinhas++;
			for(i=0;i<menu.length;i++){
				menu[i].setStatus();
				menu[i].indice = 0;
			}
			if(nlinhas<arquivo.length){
				linha = arquivo[nlinhas];
			}else{
				linha = null;
			}
	
		}
		aux = "Programa Executado Com Sucesso!\nTotal de Linhas Executadas "+nlinhas;
		JOptionPane.showMessageDialog (null, aux, null, 1);
		
	}
};
