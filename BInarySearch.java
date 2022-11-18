public class Main {

    public static int binarySearch ( int[] Arr, int target){
        //added static because there is no class instantiated; doesn't belong to class
        int min = 0;
        int max = Arr.length; //creating general variables for navigating array
        int mid = max / 2;
        while (Arr[mid] != target){ //while the array is not equal to target:
            if(Arr[mid] > target){ //if the middle is larger than the target
                max = mid; //the array is limited to anything before the middle
            }
            else if (Arr[min] < mid) { //if the middle is smaller than the target
                min = mid; //the array is limited to anything after the middle
            }
            else{
                break;
            }
            mid = (max-min) / 2 + min; //redefining "mid" so that less and less of the array is checked depending on whether the program
            if(mid == max||mid==min){
                break;
            }
        if (Arr[mid] != target){ //at the end of this loop if the target is not in the middle of the array then it doesn't exist.in the array
            return  -1; //returns -1
        }

        }
        return mid; //return the middle number
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        System.out.println(binarySearch(A, 2));
        System.out.println(binarySearch(A, 12));
    }
}
