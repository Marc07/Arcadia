/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa métodos matemáticos*/
class Calculos{
	public static double soma(double a,double b){
		double resul;
		resul = a + b;
		return resul;
	}
	public static double subt(double a,double b){
		double resul;
		resul = a - b;
		return resul;
	}
	public static double divi(double a,double b){
		double resul;
		resul = a / b;
		return resul;
	}
	public static double mult(double a,double b){
		double resul;
		resul = a * b;
		return resul;
	}
	public static boolean diferente(double a,double b){
		if(a!=b){
			return true;
		}
		return false;
	}
	public static boolean igual(double a,double b){
		if(a==b){
			return true;
		}
		return false;
	}
	public static boolean menorigual(double a,double b){
		if(a<=b){
			return true;
		}
		return false;
	}
	public static boolean maiorigual(double a,double b){
		if(a>=b){
			return true;
		}
		return false;
	}
	public static boolean menor(double a,double b){
		if(a<b){
			return true;
		}
		return false;
	}
	public static boolean maior(double a,double b){
		if(a>b){
			return true;
		}
		return false;
	}
};
