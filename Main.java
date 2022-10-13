import java.util.ArrayList;
import java.util.function.DoubleFunction;

class main{
    public static void main(String[] args){
        System.out.println("Hello world");
        DoubleFunction<Double> func3_2 = x -> (Math.tan(x)/Math.pow(x, 2));
        DoubleFunction<Double> func3_2Derivative = x -> (x*Math.pow(Math.cos(x), -2) - 2 * Math.tan(x))/Math.pow(x, 3);
        DoubleFunction<Double> func3_2SecondDerivative = x -> (6*Math.tan(x) + 2 * x * (x * Math.tan(x) - 2)*Math.pow(Math.cos(x), -2))/Math.pow(x, 4);
        

        ArrayList<Double> coeffs = new ArrayList<Double>();
        coeffs.add(1.0);
        coeffs.add(-16.0);
        coeffs.add(61.0);
        coeffs.add(24.0);
        coeffs.add(2.0);
        Polynomial poly3_5 = new Polynomial(coeffs);
        Polynomial poly3_5Der = poly3_5.derivativeFunc();
        DoubleFunction<Double> func3_5 = x -> poly3_5.computeHornersAlgorithm(x);
        DoubleFunction<Double> func3_5Der = x -> poly3_5Der.computeHornersAlgorithm(x);

        DoubleFunction<Double> func3_14 = x -> Math.pow(x, 2)+ 2 * x * Math.pow(0 - x - Math.pow(Math.E, 0-x), 1/3) - Math.pow(Math.pow(0 - x - Math.pow(Math.E, 0-x), 1/3), 2) + Math.tan(x);
        DoubleFunction<Double> func3_14Der = x -> 2 * x
                                                + 2 * Math.pow(0 - x - Math.pow(Math.E, 0-x), 1/3) 
                                                + 2 * x * (1/3) * Math.pow(0 - x - Math.pow(Math.E, 0-x), -2/3) * (-1 + Math.pow(Math.E, 0-x))
                                                - 2 * Math.pow(0 - x - Math.pow(Math.E, 0-x), 1/3) * Math.pow(0 - x - Math.pow(Math.E, 0-x), -2/3) * (-1 + Math.pow(Math.E, 0-x))
                                                + 1/Math.pow(Math.sin(x), 2);
        
        //DoubleFunction<Double> func3_14Der = x -> 2 * x + 

        System.out.println("Solving Problem 1 - 3.2.3");
        NewtonMethod nMethodForProblem1_3_2_3 = new NewtonMethod(func3_2Derivative, func3_2SecondDerivative);
        System.out.println(nMethodForProblem1_3_2_3.computeRoot(0.5, 0.000000000000001));
        System.out.println("================================");

        System.out.println("Solving Problem 1 - 3.2.14b");

        NewtonMethod nMethodForProblem1_3_2_14b = new NewtonMethod(func3_14, func3_14Der);
        System.out.println(nMethodForProblem1_3_2_14b.computeRoot(0.3, 0.000000000000001));

        System.out.println("================================");

        System.out.println("Solving Problem 2 - 3.2.3");

        SecantMethod sMethodForProblem2_3_2_3 = new SecantMethod(func3_2Derivative);
        System.out.println(sMethodForProblem2_3_2_3.computeRoot(0.5, 0.7, 0.000000000000001));

        System.out.println("================================");

        System.out.println("Solving Problem 3 - 3.2.5");

        NewtonMethod nMethodForProblem3_3_2_5 = new NewtonMethod(func3_5, func3_5Der);
        System.out.println("Root 1:");
        System.out.println(nMethodForProblem3_3_2_5.computeRoot(0.1, 0.000000000000001));
        System.out.println("Root 2:");
        System.out.println(nMethodForProblem3_3_2_5.computeRoot(0.2, 0.000000000000001));
        System.out.println("================================");

    }
}