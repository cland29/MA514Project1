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

    public double computeRoot(double x0Estimate, double x1Estimate, double tolerance){
        int iteration_count = 0;
        double computed_iteration = computeNthIteration(iteration_count, x0Estimate, x1Estimate);
        System.out.println("iteration Step: " + iteration_count + " Computed Result: " + computed_iteration);
        while (Math.abs(function.apply(computed_iteration)) > tolerance){
            iteration_count += 1;
            computed_iteration = computeNthIteration(iteration_count, x0Estimate, x1Estimate);
            System.out.println("iteration Step: " + iteration_count + " Computed Result: " + computed_iteration);
        }
        return computed_iteration;
    }
}