package test;

/**
 * Created by AlexP on 5/25/2018.
 */
public class Sort {

    public static void main(String[] arg){
        Sort s = new Sort();
        int[] array = new int[]{17,18,19,1,2,3,4,5,6,7,8,9,10,11,13,15};
        s.splitEvenOddIndex(array);
        for(int i : array){
            System.out.print(i+" ");
        }

    }


    public void split(int[] array){
        int start = 0;
        int end = array.length-1;
        int i = start, j=end;
        while(i<j){
            while(i<=end && array[i]%2==0){
                i++;
            }
            while(j>=start && array[j]%2==1){
                j--;
            }
            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        split(array,start,i);
        split(array,i,end+1);

    }

    public void split(int[] array, int start, int end){

        for(int i=start;i<end;i++){
            int greatest = i;
            for(int j=i;j<end;j++){
                if(array[greatest]<array[j]){
                    greatest = j;
                }
            }
            int temp = array[i];
            array[i] = array[greatest];
            array[greatest] = temp;
        }
    }

    public void splitEvenOddIndex(int[] array){
        boolean swapped = true;
        int temp = 0;
        while(swapped){
            swapped = false;
            for(int i=0;i<array.length-1;i++){
                if(array[i]%2>array[i+1]%2){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
                else if(array[i]%2==array[i+1]%2){
                    if(array[i]>array[i+1]){
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }
}
