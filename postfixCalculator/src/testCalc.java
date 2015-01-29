/**
 * Created by lrraymond13 on 12/7/14.
 */

public class testCalc {

    public static void main(String[] args) {
        String[] testCases = {"(4+8)*(6-5)/((3-2)*(2+2))", "(300+23)*(43-21)/(84+7)",
        "3+4*5/6","(4.1+8.44)*(6.5-5.0)/((3000.0-21)*(21+0))" };
        String[] testPostfix = {"4 8 + 6 5 - * 3 2 – 2 2 + * /", "300 23 + 43 21 - * 84 7 + /",
                "3 4 5 * 6 / +","4.1 8.44 + 6.5 5.0 - * 3000.0 21 – 21 0 + * /" };

        double[] testRes = {3.0, 78.08791208791209, 6.33334, 0.00030067616170335204 };

        for (int i=0; i < testCases.length; i++) {
            System.out.println("Testing "+i);
            converter testC = new converter(testCases[i]);
            String result = testC.toPostFix();
            System.out.println("Result is: "+result);
            System.out.println("Correct value is: "+testPostfix[i]);

            assert result.equals(testPostfix[i]);
            double output=calculator.PostFixEvaluator(result);
            System.out.println("Result is: "+output);
            System.out.println("Correct value is: "+testRes[i]);
            assert output-testRes[i]<.00001;
        }

    }
}
