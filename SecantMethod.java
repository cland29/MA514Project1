import java.util.function.DoubleFunction;

class SecantMethod{

    DoubleFunction<Double> function;

    public SecantMethod(DoubleFunction<Double> function){
        this.function = function;
    }

    public double computeNthIteration(int n, double x0Estimate, double x1Estimate){
        if (n <= 0){
            return x0Estimate;
        }
        if (n == 1){
            return x1Estimate;
        }

        double doublePriorTerm = computeNthIteration(n - 2, x0Estimate, x1Estimate);
        double priorTerm = computeNthIteration(n - 1, x0Estimate, x1Estimate);
        return priorTerm - function.apply(priorTerm) * ((priorTerm - doublePriorTerm)/(function.apply(priorTerm) - function.apply(doublePriorTerm)));
    }
}