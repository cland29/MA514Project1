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
}
