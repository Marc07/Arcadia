/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe converte um arquivo com o código em um vetor de Strings usada para a implementação das demais classes*/
import javax.swing.*;
import java.io.*;
class Converte{
	public static String[] convertstring(String[] args,Variavelimite[] lim){
		int i,aux = 0,nlinhas = 0;
		String linha,teste;
		File txt;
		if(args.length==0){
			teste = JOptionPane.showInputDialog ("Nenhum Arquivo Encontrado"+"\n"+"Digite o Caminho Para o Arquivo a Ser Executado");
			txt = new File(teste);
		}else{
			txt = new File(args[0]);
		}
		if(txt.exists()){
			try{
				FileReader reader = new FileReader(txt);
				BufferedReader leitor = new BufferedReader(reader);
				while(true){
					linha = leitor.readLine();
					if(linha==null){
						break;
					}
					lim = Analise.frase(linha,lim);
					if(linha.contains("}")==true){
						lim[1].valor = lim[0].valor + 1;
					}
					if(lim[0].valor<lim[1].valor){
						nlinhas++;
					}else{
						teste = "Caracter de Terminação Não Encontrado"+"\n"+"Na linha "+(nlinhas+1);
						JOptionPane.showMessageDialog (null, teste, "Ola!", JOptionPane.ERROR_MESSAGE);
						return null;
					}
				}
			}
			catch(Exception erro) {}
			String[] arq;
			arq = new String[nlinhas];
			try{
				FileReader reader = new FileReader(txt);
				BufferedReader leitor = new BufferedReader(reader);
				while(aux<nlinhas){
					linha = leitor.readLine();
					if(linha==null){
						break;
					}
					arq[aux] = linha;
					aux++;
				}
			}
			catch(Exception erro) {}
			lim[0].valor = 0;
			lim[1].valor = 0;
			return arq;
		}
		teste = "O Arquivo Não Existe";
		JOptionPane.showMessageDialog (null, teste, "Erro!", JOptionPane.ERROR_MESSAGE);
		return null;
	}
};
