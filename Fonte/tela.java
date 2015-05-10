/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa métodos de entrada e saida*/
import javax.swing.*;
class Tela{
	public static Variavel[] dialogbox(String linha,Executa separa,Variavel[] seq){
		int i,fim;
		String teste,var=null,mostra,valor;
		Variavel p;
		if(linha.contains("screen")==true){
			i = separa.indice;
			teste = linha.substring(i-1,i);
			while(teste.compareTo("(")!=0){
				i--;
				if(i<0){
					teste = "A Função Não Esta Bem Definida\n=>"+linha;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}
				teste = linha.substring(i-1,i);
			}
			mostra = linha.substring(i,separa.indice);
			i = separa.indice;
			teste = linha.substring(i,i+1);
			while(teste.compareTo(")")!=0&&i<linha.length()){
				i++;
				teste = linha.substring(i,i+1);
				if(teste.compareTo(";")==0){
					teste = "A Função Não Esta Bem Definida\n=>"+linha;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}
				if(i<linha.length()){
					teste = linha.substring(i,i+1);
				}
			}
			fim = i;
			var = Agiliza.crescente(linha,separa.indice+1,fim);
			if(var!=null){
				p = Declara.getVariavel(var,seq);
				if(p!=null){
					var = Double.toString(p.valor);
				}else{
					var = " ";
				}
			}
			teste = mostra+var;
			JOptionPane.showMessageDialog (null, teste, null, 1);
			return seq;
		}
		if(linha.contains("screin")==true){
			i = separa.indice;
			teste = linha.substring(i,i+1);
			while(teste.compareTo(")")!=0&&i<linha.length()){
				i++;
				teste = linha.substring(i,i+1);
				if(teste.compareTo(";")==0){
					teste = "A Função Não Esta Bem Definida\n=>"+linha;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}
				if(i<linha.length()){
					teste = linha.substring(i,i+1);
				}
			}
			mostra = linha.substring(separa.indice+1,i);
			i = separa.indice;
			teste = linha.substring(i-1,i);
			while(teste.compareTo("(")!=0){
				i--;
				if(i<0){
					teste = "A Função Não Esta Bem Definida\n=>"+linha;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}
				teste = linha.substring(i-1,i);
			}
			var = Agiliza.crescente(linha,i,separa.indice);
			if(var!=null){
				p = Declara.getVariavel(var,seq);
				valor = JOptionPane.showInputDialog (mostra);
				valor = Agiliza.testanum(valor);
				if(p==null){
					teste = "Variavel Não Encontrada Na Linha\n"+linha+"\n=>"+var;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}
				if(valor==null){
					teste = "Atribuição Ilegal de Valor\n=>"+var;
					JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
					return null;
				}else{
					p.valor = Double.parseDouble(valor);
					return seq;
				}
			}
			
		}
		return seq;
	}
};
