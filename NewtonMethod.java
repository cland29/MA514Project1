import java.util.function.DoubleFunction;


class NewtonMethod{
    DoubleFunction<Double> function, derivative;

    public NewtonMethod(DoubleFunction<Double> function, DoubleFunction<Double> derivative){
        this.function = function;
        this.derivative = derivative;
    }

    public double computeNthIteration(int n, double x0Estimate){
        if (n <= 0){
            return x0Estimate;
        }
        double priorTerm = computeNthIteration(n - 1, x0Estimate);
        return priorTerm - function.apply(priorTerm) / derivative.apply(priorTerm);
    }
}