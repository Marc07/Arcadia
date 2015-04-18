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
		System.out.println("Não é possivel inserir mais variaveis");
		return;
	}
	
	public static Variavel insere(String s,Variavel i,Variavel[] seq){
		int aux;
		String teste,f=null;
		aux = s.length();
		aux-=1;
		while(aux>0){
			teste = s.substring(aux-1,aux);
			if(teste.compareTo(" ")!=0){
				if(f==null){
					f = teste;
				}else{
					f+=teste;
				}
			}else{
				if(f!=null){
					aux = -1;
				}
			}
			aux--;
		}
		if(Declara.getVariavel(f,seq)==null){
			i.setNome(f);
			Declara.setVariavel(i,seq);
			return Declara.getVariavel(f,seq);
		}else{
			return null;
		}
	}
};