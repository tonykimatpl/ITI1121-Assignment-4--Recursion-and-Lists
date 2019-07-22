import java.util.*;

public class Test{

  public static int sumOdd(int[] t){
    if(t.length == 1){
      if(t[0]%2 != 0){
        return t[0];
      }
      else{
        return 0;
      }
    }
    int sum = sumOdd(Arrays.copyOfRange(t,1,t.length));
    if(t[0]%2 != 0){
      sum += t[0];
    }
    return sum;
  }


  public static int lastOccurence(int[] t, int n){
    if(t.length == 1){
      int count;
      if(t[0] == n){
        count = 0;
      }
      else{
        count = -1;
      }
      return count;
    }
    int lastCount = lastOccurence(Arrays.copyOfRange(t,1,t.length), n);
    if(lastCount == -1){
      if(t[0] == n){
        return 0;
      }
      else{
        return -1;
      }
    }
    else{
      return lastCount + 1;
    }
  }


  public static int[] sumArray(int [] t, int value){
    if(t.length==1){
      if(value==t[0]){
        int[] arr = {t[0]};
        return arr;
      }
      else{
        return null;
      }
    }
    int[] arr1 = sumArray(Arrays.copyOfRange(t, 1, t.length),value-t[0]);
    int[] arr2 = sumArray(Arrays.copyOfRange(t, 1, t.length),value);
    if(arr1!=null){
      int[] arrFinal = new int[arr1.length+1];
      arrFinal[0] = t[0];
      for(int i =1;i<arr1.length+1;i++){
        arrFinal[i]= arr1[i-1];
      }
    }
    else if(arr2!=null){
      return arr2;
    }
    return null;
  }

  public static void main(String [] args){

    int[] t = {5};

    System.out.println(sumArray(t,5));
    
    System.out.println(sumOdd(t));
    System.out.println(lastOccurence(t,6));
  }
}
