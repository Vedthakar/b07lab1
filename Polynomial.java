import java.lang.Math;

public class Polynomial {
    double[] coeff;

    public Polynomial(){
        coeff = new double[1];
        coeff[0] = 0.0;
    }

    public Polynomial(double[] arguements){
        coeff = arguements;
    }

    public Polynomial add(Polynomial to_add){
        //to set make the temp big need to make it biggest
        int max_length;
        if(coeff.length > to_add.coeff.length){
            max_length = coeff.length;
        }else{
            max_length = to_add.coeff.length;
        }
        double[] arguements = new double[max_length];
        Polynomial temp = new Polynomial(arguements);
        double total = 0;
        int i = 0;
        if(to_add.coeff.length >= coeff.length){
            while(i<coeff.length){
                total = to_add.coeff[i] + coeff[i];
                temp.coeff[i] = total;
                i++;
            }// at this point i is the length of coeff (smaller)
            while(i<to_add.coeff.length){
                temp.coeff[i] = to_add.coeff[i]; // add the remaining.
                i++;
            }

        }else if(to_add.coeff.length < coeff.length){
            while(i<to_add.coeff.length){
                total = to_add.coeff[i] + coeff[i];
                temp.coeff[i] = total;
                i++;
            }// at this point i is the length of coeff (smaller)
            while(i<coeff.length){
                temp.coeff[i] = coeff[i]; // add the remaining.
                i++;
            }

        }
        return temp;
    }

    public double evaluate(double val){
        double temp = 0;
        for(int i = 0; i < coeff.length; i++){//skip constant
            temp += coeff[i] * Math.pow((val), i);
        }
        return temp;
    }

    public boolean hasRoot(double val){
        if(evaluate(val) == 0){
            return true;
        }
            return false;
    }
}
