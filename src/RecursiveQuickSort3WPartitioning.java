import java.util.Arrays;

public class RecursiveQuickSort3WPartitioning {
    public static void main(String[] args)
    {
        int[] array = {15, 25, 4, 36, 40, 12, 5, 8, 20, 44, 38, 7, 34, 14, 29, 26, 50, 10, 37, 1, 42, 41, 13, 30, 48, 6, 33, 11, 9, 39, 31, 16, 17, 45, 49, 28, 3, 27, 19, 32, 24, 2, 47, 43, 21, 18, 46, 22, 35, 23};
        RecursiveQuickSort3WPartitioning q = new RecursiveQuickSort3WPartitioning();
        q.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public void quickSort(int[] array, int l, int r)
    {
        if (r-l < 1)
        {
            return;
        }
        else {
            int[] result = _driverPartition(array,l,r);
            quickSort(array,l,result[0]-1);
            quickSort(array,result[1]+1,r);
        }
    }

    public int[] _driverPartition(int[] array, int l, int r)
    {
        int smaller = l;
        int equals = l;
        int bigger = r;
        int pivot = array[(l+r)/2];
        return _partitioningRec(array,smaller,equals,bigger,pivot);
    }

    private int[] _partitioningRec(int[] array, int smaller, int equals, int bigger,int pivot)
    {
        if (equals > bigger)
            return new int[] {smaller,bigger};

        if (array[equals] < pivot)
        {
            swapAtIndex(array,smaller,equals);
            return _partitioningRec(array,++smaller,++equals,bigger,pivot);
        }
        else if (array[equals] == pivot)
        {
            return _partitioningRec(array,smaller,++equals,bigger,pivot);
        }
        else {
            swapAtIndex(array,equals,bigger);
            return _partitioningRec(array,smaller,equals,--bigger,pivot);
        }
    }






    public int[] _partitioning3W(int[] array, int l, int r)
    {
        int smaller = l;
        int equals = l;
        int bigger = r;
        int pivot = array[(l+r)/2];
        while (equals <= bigger)
        {
            if (array[equals] < pivot)
            {
                swapAtIndex(array,smaller++,equals++);
            }
            else if (array[equals] == pivot)
            {
                equals++;
            }
            else {
                swapAtIndex(array,equals,bigger--);
            }
        }
        return new int[] {smaller,bigger};
    }


    public void swapAtIndex(int[] array, int one, int two)
    {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;

    }
}
