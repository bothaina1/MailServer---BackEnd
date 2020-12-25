package com.example.mail_server.Model.Sort;

import java.util.Arrays;

public class mergeSort
{
    void merge(int arr[], int beg, int mid, int end)
    {

        int l = mid - beg + 1;
        int r = end - mid;

        int[] LeftArray = new int [l];
        int[] RightArray = new int [r];

        System.arraycopy(arr, beg, LeftArray, 0, l);

        for (int j=0; j<r; ++j)
            RightArray[j] = arr[mid + 1+ j];


        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));;
    }

    void sort(int arr[], int beg, int end)
    {
        if (beg<end)
        {
            int mid = (beg+end)/2;
            sort(arr, beg, mid);
            sort(arr , mid+1, end);
            merge(arr, beg, mid, end);
        }
    }
    public static void main(String args[])
    {
        int arr[] = {3,2,1,0};
        mergeSort ob = new mergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        for(int i =0; i<arr.length;i++)
        {
            System.out.println(arr[i]+"");
        }
    }
}