import java.util.Scanner;

public class prettyNum {
    public static void main(String[] args) { //creating the pretty num class
        Scanner input = new Scanner(System.in); //defining scanner

        System.out.println("[dec_number] Please enter a number: "); //asking user for number
        double userNum = input.nextDouble(); //turning the number into a double

        System.out.println("[dec/d/sci/s] Please enter a format: "); //asking user for format of number
        String format = input.next(); //setting the format variable equal to it

        System.out.println("[precision] Please enter level of precision: "); //asking user for level of precision
        int precision  = input.nextInt(); //making precision an int

        System.out.println("[pretty: true/false] Please true or false for a pretty number: "); //asking user if they want a pretty number
        boolean pretty = Boolean.parseBoolean(input.next()); //turning input into a boolean

        switch(format) { //whether the user wants scientific notation or decimal
            case "dec":
            case "d": //if the user wants a decimal number:
                if(pretty){
                    System.out.printf("%,3." + precision + "f", userNum); //adds commas every 3 and rounds to precision
                }
                else{
                    //just rounds to user specified precision
                    System.out.printf("%." + precision + "f", userNum);
                }
                break;
            case "sci":
            case "s": //don't have to make pretty
                if(pretty){ //add else
                    System.out.printf("%."+precision+ "E",userNum); //tuns number into scientific notation and rounds
                }
                else{
                    System.out.printf("%."+precision+ "E",userNum); //tuns number into scientific notation and rounds
                }
                break;
            default:
                System.out.println("Wrong format buddy. check your input");

        }
    }
}
