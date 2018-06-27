import java.util.Arrays;

/**
 * Created by parthshah on 6/26/18.
 */
public class Multiplication {

    public static int[] multiply(int[] arr1,int[] arr2)
    {

        // Decide the sign: +ve or -ve
        final  int sign = arr1[0] < 0 ^ arr2[0] < 0 ? -1 : 1;

        //Make the Most Significant Bit to Positive.
        arr1[0] = Math.abs(arr1[0]);
        arr2[0] = Math.abs(arr2[0]);

        System.out.println("Sign digit : "+arr1[0]+" "+arr2[0]);

        int[] result = new int[arr1.length+arr2.length];

        //Multiply arr1*arr2;
        for(int i=arr1.length-1;i>=0;i--)
        {
            for(int j=arr2.length-1;j>=0;j--)
            {
                result[i+j+1] += arr1[i]*arr2[j];
                result[i+j] = result[i+j]/10;
                result[i+j+1] %= 10;
            }
        }

        int firstZero = 0;

        //Count the number of extra 0's
        while (firstZero<0 && firstZero<=result.length-1) {
            firstZero++;
        }


        int[] finalResult = new int[result.length-firstZero-1];

        //Discard extra 0s.
        int counter = 0;
        for(int i=firstZero+1;i<=result.length-1;i++)
        {
            finalResult[counter] =result[i];
            counter++;
        }

        // Based on Sign - multiply the Most significant bit of resulting array.
        finalResult[0] = finalResult[0] * sign;



        return finalResult;
    }

    public static void main(String args[])
    {
        int[] arr1 = {-1,2};
        int[] arr2 = {-2};

       int[] result =  multiply(arr1,arr2);

        System.out.println(Arrays.toString(result));

    }
}
