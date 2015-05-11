/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe executa o método de comparação,utiliza em laços e controladores de fluxo*/
import javax.swing.*;
class Compare{
	public static int compara(String linha,Executa menu,Variavel[] seq){
		String teste,aux;
		boolean status;
		int i=0,inicio,fim;
		double x=0,y=0;
		Variavel z;
		teste = linha.substring(i,i+1);
		while(teste.compareTo("(")!=0){
			i++;
			teste = linha.substring(i,i+1);
		}
		i++;
		inicio = i;
		teste = linha.substring(i,i+1);
		while(teste.compareTo(")")!=0){
			i++;
			teste = linha.substring(i,i+1);
		}
		fim = i;
		aux = Agiliza.crescente(linha,inicio,menu.indice);
		if(aux!=null){
			teste = Agiliza.testanum(aux);
			if(teste==null){
				teste = Agiliza.testanome(aux);
				if(teste==null){
					aux = "Expressão Ilegal na Linha\n"+linha;
					JOptionPane.showMessageDialog (null, aux, "Erro!", JOptionPane.ERROR_MESSAGE);
					return -1;
				}else{
					z = Declara.getVariavel(aux,seq);
					if(z==null){
						teste = "Expressão Ilegal na Linha\n"+linha+"\nVariavel Não Encontrada\n=>"+aux;
						JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
						return -1;
					}else{
						x = z.valor;
					}
				}
			}else{
				x = Double.parseDouble(aux);
			}
		}else{
		
		}
		teste = linha.substring(menu.indice+1,menu.indice+2);
		if(teste.compareTo("=")==0){
			aux = Agiliza.crescente(linha,menu.indice+2,fim);
		}else{
			aux = Agiliza.crescente(linha,menu.indice+1,fim);
		}
		if(aux!=null){
			teste = Agiliza.testanum(aux);
			if(teste==null){
				teste = Agiliza.testanome(aux);
				if(teste==null){
					aux = "Expressão Ilegal na Linha\n"+linha;
					JOptionPane.showMessageDialog (null, aux, "Erro!", JOptionPane.ERROR_MESSAGE);
					return -1;
				}else{
					z = Declara.getVariavel(aux,seq);
					if(z==null){
						teste = "Expressão Ilegal na Linha\n"+linha+"\nVariavel Não Encontrada\n=>"+aux;
						JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
						return -1;
					}else{
						y = z.valor;
					}
				}
			}else{
				y = Double.parseDouble(aux);
			}
		}else{
		}
		if(linha.contains("==")==true){
			status = Calculos.igual(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}else if(linha.contains("!=")==true){
			status = Calculos.diferente(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}else if(linha.contains("<=")==true){
			status = Calculos.menorigual(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}else if(linha.contains(">=")==true){
			status = Calculos.maiorigual(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}else if(linha.contains("<")==true){
			status = Calculos.menor(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}else if(linha.contains(">")==true){
			status = Calculos.maior(x,y);
			if(status){
				return 1;
			}else{
				return 0;
			}
		}
		teste = linha.substring(menu.indice,menu.indice+1);
		aux = "Expressão Ilegal na Linha\n"+linha+"\nToken Não Encontrado\n=>"+teste;
		JOptionPane.showMessageDialog (null, aux, "Erro!", JOptionPane.ERROR_MESSAGE);
		return -1;
	}
};
