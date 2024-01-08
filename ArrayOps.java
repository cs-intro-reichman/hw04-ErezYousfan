public class ArrayOps {
    public static void main(String[] args) {
        
    }   
    
    public static int findMissingInt (int [] array) {
        // Write your code here:
        int missing = array.length;
        for (int i = 0; i < missing; i++) {
            boolean found = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i){
                    found = true;
                    break;
                }
            }
            if (!found) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int second_max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int maxCounter = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == max)
                maxCounter++;
            if (array[i] > second_max && (array[i] != max || maxCounter > 1))
                second_max = array[i];
            
        }
        return second_max;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        // Write your code here:
        boolean containsSame = true;
        for (int i = 0; i < array1.length; i++) {
            boolean found = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                containsSame = false;
                break;
            }
        }
        return containsSame;
    }

    public static boolean isSorted(int [] array) {
        // Write your code here:
        if (array.length < 3)
             return true;
        boolean sorted = true;
        for (int i = 1; i < array.length-1; i++) {
            if (array[i-1] < array[i] && array[i] > array[i+1]){
                sorted = false;
                break;
            }
            else if (array[i-1] > array[i] && array[i] < array[i+1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

}
