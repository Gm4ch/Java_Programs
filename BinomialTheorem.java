import java.util.Scanner;

public class BinomialTheorem {

    // main method
    public static void main(String[] args){
        // creating a scanner object
        Scanner scr = new Scanner(System.in);

        // getting user input to represent the n value
        System.out.print("N: ");
        System.out.print(expand(scr.nextInt()));
    }
    // method for factorial
    static public int factorial(int num) {
        int answer = num;
        // factorial of 0 is 1
        if (num == 0){
            answer = 1;
        }
        else {
            for (int i = 1; i < num; i++) {
                answer *= (num - i);
            }
        }
        return answer;
    }

    // combination method
    static public int choose(int n, int k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }

    // expand method
    static public String expand(int n) {
        // variables to represent letters in the equation
        String x = "x";
        String y = "y";
        // variable that stores the full output
        String results = "";
        for (int k = 0; k <= n; k++) {
            // variable that keeps the default string format
            String template = String.format(" %d%s^%d%s^%d +", choose(n, k), "x", n - k, "y", k);

            // This is a check point 2

            if (k == 0){ //if k is zero then the y value is not printed.
                template = String.format(" %d%s^{%d} +", choose(n, k), x, n-k);
            }
            else if (n-k == 0){ //if n minus k is zero then the x value is not printed.
                template = String.format(" %d%s^{%d} +", choose(n, k), y, k);

            }
            else { //if neither are equal to zero both x and y are printed
                template = String.format(" %d%s^{%d}%s^{%d} +", choose(n, k), x, n - k, y, k);
            }

            //replacing the 1* and ^1 with another string that does not have 1 in it.
            template = template.replace("* 1 + "," + ");
            template = template.replace(" 1 * "," ");
            template = template.replace(" 1x"," x");
            template = template.replace(" 1y"," y");
            template = template.replace("^{1}", "");
            results += template;
            //System.out.println(myStr.replace('l', 'p'));

        }
        results = results.substring(0, results.length() - 1); //removing the plus sign from the end of the equation
        return results; //Return the result variable
    }

}
