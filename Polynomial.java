import java.util.ArrayList;

public class Polynomial {
    ArrayList<Double> coeffs;
    public Polynomial(ArrayList<Double> coeffs){
        this.coeffs = coeffs;
    }

    public double compute(double x){
        double sum = 0;
        for(int i = 0; i < coeffs.size(); i++){
                sum += coeffs.get(i) * Math.pow(x, i);
        }
        return sum;
    }

    public double computeHornersAlgorithm(double x){
        double sum = 0;
        for(int i = coeffs.size() - 1; i >= 0; i--){    
            sum = coeffs.get(i) + sum * x;
        }
        
        return sum;
    }

    public Polynomial derivativeFunc(){
        ArrayList<Double> newCoeffs = new ArrayList<>(coeffs);
        newCoeffs.remove(0);
        for (int i = 0; i < newCoeffs.size(); i++){
            newCoeffs.set(i, newCoeffs.get(i) * (i+1));
        }
        return new Polynomial(newCoeffs);
    }
}
