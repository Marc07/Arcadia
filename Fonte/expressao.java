/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe analise linhas do c�digo fonte que contenham express�es matem�ticas*/
import javax.swing.*;
class Expressao{
	public static String opera(String s,Executa[] menu,Variavel[] seq){
		double x,y,res;
		int i,aux;
		Variavel z;
		z = new Variavel();
		String teste,valor = null,var=  null;
		aux = menu[2].indice;
		i = menu[1].indice+1;
		var = Agiliza.crescente(s,i,aux);
		var = Agiliza.testanum(var);
		if(var==null){
			var = Agiliza.crescente(s,i,aux);
			var = Agiliza.testanome(var);
			if(var==null){
				var = Agiliza.crescente(s,i,aux);
			}
			z = Declara.getVariavel(var,seq);
			if(z!=null){
				x = z.valor;
			}else{
				valor = "Express�o Ilegal na Linha"+"\n"+s+"\n"+"=> "+var;
				JOptionPane.showMessageDialog (null, valor, "Erro!", JOptionPane.ERROR_MESSAGE);
				var = null;
				return var;
			}
		}else{
			x = Double.parseDouble(var);
		}
		i = menu[2].indice+1;
		aux = s.length()-1;
		var = Agiliza.crescente(s,i,aux);
		var = Agiliza.testanum(var);
		if(var==null){
			var = Agiliza.crescente(s,i,aux);
			var = Agiliza.testanome(var);
			if(var==null){
				var = Agiliza.crescente(s,i,aux);
			}
			z = Declara.getVariavel(var,seq);
			if(z!=null){
				y = z.valor;
			}else{
				valor = "Express�o Ilegal na Linha"+"\n"+s+"\n"+"=> "+var;
				JOptionPane.showMessageDialog (null, valor, "Erro!", JOptionPane.ERROR_MESSAGE);
				var = null;
				return var;
			}
		}else{
			y = Double.parseDouble(var);
		}
		i = menu[2].indice;
		var = s.substring(i,i+1);
		if(var.compareTo("+")==0){
			res = Calculos.soma(x,y);
		}else if(var.compareTo("-")==0){
			res = Calculos.subt(x,y);
		}else if(var.compareTo("/")==0){
			if(x==0||y==0){
				valor = "Express�o Ilegal na Linha"+"\n"+s+"\nTentativa de Efetuar Divis�o Por ZERO";
				JOptionPane.showMessageDialog (null, valor, "Erro!", JOptionPane.ERROR_MESSAGE);
				var = null;
				return var;
			}
			res = Calculos.divi(x,y);
		}else if(var.compareTo("*")==0){
			res = Calculos.mult(x,y);
		}else if(var.compareTo("%")==0){
			res = Calculos.mod(x,y);
		}else{
			valor = "Express�o Ilegal na Linha"+"\n"+s+"\n"+"=> "+var;
			JOptionPane.showMessageDialog (null, valor, "Erro!", JOptionPane.ERROR_MESSAGE);
			var = null;
			return var;
		}
		valor = s.substring(0,menu[1].indice+1);
		valor+=res;
		return valor;
	}
};
