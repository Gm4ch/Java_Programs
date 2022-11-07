import java.util.Scanner;
public class CarsArray {
    public static void main(String[] args){

        final int numOfCars = 7; //creating a variable for number of cars
        //TODO: Declare an array that holds seven floating point numbers
        //float[] msrp = {1, 2, 3, 4, 5, 6, 7};
        float[] msrp = new float[numOfCars]; //initializing the array

        //TODO: Declare an array that holds seven Strings
        String[] cars = new String[numOfCars]; //initializing the array

        //TODO: Perform some quick research to determine the MSRP of seven
        // different vehicles of interest to you
        //Car Make and MSRP:
        /*
        apollo:evo - 2,670,000
        Lamborghini:Aventador - 515,000
        BMW:Mini-Cooper - 22,900
        bugatti:chiron - 3,300,000
        Mazda:Miata - 27,650
        Mitsubushi:minicab 4x4 - 7,879
        Toyota:Prius - 25,075
        */

        //TODO: Using a single Scanner object, and without creating additional variables...
        // to the appropriate array, and at the correct index, add the Make: Model and MSRP
        // of each vehicle. Make: Model are a single string.

        Scanner input = new Scanner(System.in);

        for(int x= 0; x < cars.length; x++){

            System.out.println("What is the make and model of car " +(x+1) + "? answer in the following format: \n Make:Model");
            cars[x] = input.next();
            System.out.println("What is the MSRP of car " +(x+1) + "?");
            msrp[x] = input.nextFloat();


        }

        //TODO: Print each array's contents to verify what you've added.

        for(int a = 0; a < cars.length; a++){
            System.out.print(cars[a] + " ");
            System.out.println(msrp[a]);
        }

        //TODO: From the MSRP array print the minimum value, the maximum value, and the average
        // vehicle cost. Be sure to search through the array using a loop to determine the max
        // and min values. Similarly, use a loop to get the total cost of vehicles when
        // calculating the average.

        float minimum = msrp[0];
        float maximum = 0;
        for (int i = 1; i < msrp.length; i++) {
            if (msrp[i] > maximum)
                maximum = msrp[i];
            else if (msrp[i] < minimum)
                minimum = msrp[i];
        }

        System.out.println("\nThe Minimum value is: $"+minimum);
        System.out.println("The maximum value is: $"+ maximum);

        float total = 0;
        for(int i = 0; i < msrp.length; i++){
            total += msrp[i];
        }
        System.out.println("The average cost is: $" + (total/msrp.length));

        //TODO: Create a new two dimensional array with a size of 7 x 2.
        String[][] carsAndPrice = new String[7][2];

        //TODO: To the first index of each index add the Make: Model.
        for(int x= 0; x < carsAndPrice.length; x++){
            carsAndPrice[x][0] = cars[x];
        //TODO: To the second index of each index add the MSRP
            carsAndPrice[x][1] = String.valueOf(msrp[x]);
        }

        //TODO: Sort the 2D array alphabetically according to the Make:Model

        for(int i = 0; i < cars.length; i++){
            System.out.print(carsAndPrice[i][0] + " -  $");
            System.out.println(carsAndPrice[i][1]);
        }
        //TODO: Replace the least expensive vehicle with a Tesla Model X. If this vehicle is
        // in your array, replace it with a 2022 Lucid Air
        boolean teslaExists = false;
        for(int i = 0; i < cars.length; i++){
            if(carsAndPrice[i][0].equals("Tesla:Model-x")){
                teslaExists = true;
                carsAndPrice[i][0] = "Lucid:Air";
                carsAndPrice[i][1] = "87400.0";
            }

        }
        if(!teslaExists){
            for (int l = 0; l < cars.length; l++) {
                if (carsAndPrice[l][1].equals(String.valueOf(minimum))) {
                    carsAndPrice[l][0] = "Tesla:Model-x";
                    carsAndPrice[l][1] = "120990.0";
                }
            }
        }


        //TODO: Remove the fourth item from the array
        carsAndPrice[3][0] = "";
        carsAndPrice[3][1] = "";
        //TODO: Formatted as a chart (just use a formatted string) with headings 'Vehicle' and
        // 'MSRP', print the vehicle name and then the cost.

        System.out.format("%-24s|%-10s", "Vehicle", "MSRP");
        for(int x= 0; x < cars.length; x++){
            System.out.println("\n________________________|____________");
            System.out.format("%-24s|$%-10s", carsAndPrice[x][0], carsAndPrice[x][1]);
        }


    }

}
