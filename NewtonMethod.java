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

    public double computeRoot(double x0Estimate, double tolerance){
        int iteration_count = 0;
        double computed_iteration = computeNthIteration(iteration_count, x0Estimate);
        System.out.println("iteration Step: " + iteration_count + " Computed Result: " + computed_iteration);
        while (Math.abs(function.apply(computed_iteration)) > tolerance){
            iteration_count += 1;
            computed_iteration = computeNthIteration(iteration_count, x0Estimate);
            System.out.println("iteration Step: " + iteration_count + " Computed Result: " + computed_iteration);
        }
        return computed_iteration;
    }
    
}