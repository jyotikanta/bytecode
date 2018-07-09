package leetcode;


public class PlusOne
{
    int[] solution(int[] arr)
    {
        int resultedArray[];

        if(arr[arr.length-1]!=9)
        {
            arr[arr.length-1]+=1;
            return arr;
        }
        else
        {
            int i = arr.length-1;
            boolean carryOver = true;

            resultedArray = new int[arr.length];

            while(i >= 0)
            {
                if(i==0 && arr[i] == 9 && carryOver)
                {
                    int[] resultedArrayExtended = new int[arr.length+1];
                    resultedArrayExtended[0]=1;
                    return resultedArrayExtended;
                }

                if(arr[i] == 9 && carryOver)
                {
                    resultedArray[i]=0;
                    carryOver=true;
                }
                else
                {
                    if(carryOver)
                    {
                        resultedArray[i]=arr[i]+1;
                        carryOver=false;
                    }
                    else
                    {
                        resultedArray[i]=arr[i];
                    }
                }

                i--;

            }
        }
        return resultedArray;
    }
}
