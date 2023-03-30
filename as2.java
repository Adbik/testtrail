import java.util.Arrays;
public class as2
{
    public static void main(String[] args) 
    {
        int[] num ={1,3,4,5,2} ;
       bubbl(num);
       System.out.println(Arrays.toString((num)));
    }

    public static void bubbl(int[] arr)
    {
        int temp;
        for(int i =0; i< arr.length-1;i++)
        {
            for (int j = 1; j <arr.length; j++) 
            {
                if(arr[j]<arr[j-1])
                {
                
                    //swap
                    temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }

            }
        }   
    }
}