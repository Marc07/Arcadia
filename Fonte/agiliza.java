/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe reduz a repetição de códigos, além de separar uma String
em partes menores e testa se um nome de variável é valido*/
import javax.swing.*;
class Agiliza{
	public static int percore(String[] texto,int nlinhas){
		int aux,chave = 1;
		String linha,ex;
		aux = nlinhas;
		while(chave>0){
			aux++;
			if(aux<texto.length){
				linha = texto[aux];
			}else{
				JOptionPane.showMessageDialog (null, "Caracter de Terminação Não Encontrado\n=> }", "Erro!", JOptionPane.ERROR_MESSAGE);
				return -1;
			}
			if(linha.contains("{")==true){
				chave++;
			}
			if(linha.contains("}")==true){
				chave--;
			}
		}
		return aux;
	}
	public static String crescente(String s,int i,int aux){
		String teste,var = null;
		while(i<aux){
			teste = s.substring(i,i+1);
			if(teste.compareTo(" ")!=0){
				if(teste.compareTo(";")==0){
					return var;
				}
				if(var==null){
					var = teste;
				}else{
					var+=teste;
				}
			}else{
				if(var!=null){
					i = aux;
				}
			}
			if(teste.compareTo(".")==0){
				aux++;
			}
			i++;
		}
		return var;
	}
	public static String testanum(String s){
		String teste;
		int i = 0,aux = s.length();
		while(i<aux){
			teste = s.substring(i,i+1);
			if(((teste.charAt(0) >= 'A') && (teste.charAt(0) <='Z')) || ((teste.charAt(0) >= 'a') && (teste.charAt(0) <='z'))){
				return null;
			}
			i++;
		}
		return s;
	}
	public static String testanome(String s){
		String teste;
		int i = 0;
		teste = s.substring(i,i+1);
		if(((teste.charAt(0) >= '0') && (teste.charAt(0) <='9'))){
			return null;
		}else{
			return s;
		}
	}
	public static String decrescente(String s,int i,int aux){
		String teste,var = null;
		while(aux>i){
			teste = s.substring(aux-1,aux);
			if(teste.compareTo(" ")!=0){
				if(teste.compareTo("\n")==0){
					
				}else if(var==null){
					var = teste;
				}else{
					teste+=var;
					var = teste;
				}
			}else{
				if(var!=null){
					aux = -1;
				}
			}
			aux--;
		}
		return var;
	}
};
