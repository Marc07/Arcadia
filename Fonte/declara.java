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
};
