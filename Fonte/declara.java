import javax.swing.*;
class Declara{
	public static Variavel getVariavel(String nome,Variavel[] seq){
		int aux;
		String test;
		for(aux=0;aux<seq.length;aux++){
			if(seq[aux]!=null){
				test = seq[aux].getNome();
				if(test.compareTo(nome)==0){
					return seq[aux];
				}    
			}
		}                               
		return null;
	}
			                      
	public static void setVariavel(Variavel v,Variavel[] seq){
		int aux;    
		for(aux=0;aux<seq.length;aux++){
			if(seq[aux]==null){
				seq[aux] = v;
				return;
			}
		} 
		return;
	}
	
	public static Variavel[] insere(String s,Variavel[] seq,String linha){
		int aux;
		Variavel i;
		i = new Variavel();
		String teste,var=null;
		aux = s.length();
		aux-=1;
		var = Agiliza.decrescente(s,0,aux);
		var = Agiliza.testanome(var,0);
		if(var==null){
			var = "Declara��o Ilegal de Variavel na Linha"+"\n"+linha;
			JOptionPane.showMessageDialog (null, var, "Erro!", JOptionPane.ERROR_MESSAGE);
			return seq;
		}else if(Declara.getVariavel(var,seq)==null){
			i.setNome(var);
			Declara.setVariavel(i,seq);
			return seq;
		}else{
			return seq;
		}
	}
	
	public static Variavel[] atribui(String s,Executa menu,Variavel[] seq){
		int aux;
		double x;
		Variavel i,y;
		String teste,valor=null,var=null;
		aux = menu.indice;
		aux++;
		valor = Agiliza.crescente(s,aux,s.length()-1);
		aux = menu.indice;
		aux-=1;
		var = Agiliza.decrescente(s,0,aux);
		var = Agiliza.testanome(var,0);
		if(var==null){
			var = "Declara��o Ilegal de Variavel na Linha"+"\n"+s;
			JOptionPane.showMessageDialog (null, var, "Erro!", JOptionPane.ERROR_MESSAGE);
			return seq;
		}
		i = Declara.getVariavel(var,seq);
		teste = valor;
		y = Declara.getVariavel(valor,seq);
		valor = Agiliza.testanum(valor,0,valor.length());
		if(valor==null&&y==null){
			valor = "Atribui��o Ilegal de Valor na Linha"+"\n"+s;
			JOptionPane.showMessageDialog (null, valor, "Erro!", JOptionPane.ERROR_MESSAGE);
			return seq;
		}
		if(i!=null&&y==null&&valor!=null){
			x = Double.parseDouble(valor);
			i.valor = x;
			return seq;
		}else if(i==null&&y==null&&valor!=null){
			seq = Declara.insere(var,seq,s);
			i = Declara.getVariavel(var,seq);
			if(i!=null){
				x = Double.parseDouble(valor);
				i.valor = x;
				return seq;
			}else{
				JOptionPane.showMessageDialog (null, "N�o � Possivel Inserir Mais Variavies", "Erro!", JOptionPane.ERROR_MESSAGE);
				return seq;
			}
		}else if(i!=null&&y!=null){
			i.valor = y.valor;
			return seq;
		}else if(i==null&&y!=null){
			seq = Declara.insere(var,seq,s);
			i = Declara.getVariavel(var,seq);
			if(i!=null){
				i.valor = y.valor;
				return seq;
			}else{
				JOptionPane.showMessageDialog (null, "N�o � Possivel Inserir Mais Variavies", "Erro!", JOptionPane.ERROR_MESSAGE);
				return seq;
			}
		}
		return seq;
	}
};