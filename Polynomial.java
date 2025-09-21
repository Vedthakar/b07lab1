package Polynomial;
import java.lang.Math;

public class Polynomial {
	double[] coefficients;
	
	public Polynomial() {
		coefficients = new double[1];
	}
	
	public Polynomial(double[] arr) {
		coefficients = new double[arr.length];
		coefficients = arr;
	}
	
	public Polynomial add(Polynomial argue) {
		Polynomial answer;
		if(argue.coefficients.length > this.coefficients.length) {
			answer = new Polynomial(argue.coefficients);
		}else {
			answer = new Polynomial(this.coefficients);
		}
		int i = 0;
		for(i = 0; i < Math.min(this.coefficients.length, argue.coefficients.length); i++) {
			answer.coefficients[i] += this.coefficients[i];
		}
		if(argue.coefficients.length - i > 0) {
			for(int j = i; j <  argue.coefficients.length-1; j++) {
				answer.coefficients[j] += this.coefficients[j];
			}
		}else if(this.coefficients.length - i > 0){
			for(int j = i; j <  this.coefficients.length-1; j++) {
				answer.coefficients[j] += this.coefficients[j];
			}
		}
		return answer;
	}
	
	public double evaluate(double x){
		double answer = 0;
		int i = 0;
		for(i = 0; i < coefficients.length-1; i++) {
			answer += coefficients[i] * Math.pow(x,i);
		}
		answer += coefficients[i] * Math.pow(x,i);
		return answer;
	}
	
	public boolean hasRoot(double root) {
		if(evaluate(root) == 0) {
			return true;
		}			
		return false;
	}
}
