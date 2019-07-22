public class Test{

  public static void main(String [] args){

     int [] list = new int[]{5,6,7,8};
     int c = 0;

     System.out.println(sumOdd(list,c));
     System.out.println(lastOccurence(list,1,list.length-1));

     int[] subarray = sumArray(list,15);
     for(int i = 0; i < subarray.length;i++){
       System.out.print(subarray[i] + " ");
     }
  }

  public static int sumOdd(int[] t, int i){


    if(i >= t.length){
      return 0;
    }
    if(t[i]%2 !=0){
      return sumOdd(t,i+1) + t[i];
    }
    else{
      return sumOdd(t,i+1);
    }
  }

  public static int lastOccurence(int[] t, int n, int i){

    if(i < 0){
      return -1;
    }
    if(t[i] == n){
      return i;
    }
    else{
      return lastOccurence(t, n, i-1);
    }

  }

  public static int[] sumArray(int[] t , int value){

    int sum, i, j , a , b;

    for (i = 0; i < t.length; i++){
      sum = t[i];
      // traverse from i+1 till the last element
      for (j = i + 1; j <= t.length - 1; j++){
        // if the subarray is found
        if (sum == value){
          // set the bounds of subarray
          a = i;
          b = j - 1;
          // create an array of desired output
          int[] ans = new int[ b - a + 1 ];
          int k, index = 0;
          // copy the contents of required subset to ans
          for( k = a ; k <= b ; k++ )
          ans[index++] = t[k];
          return ans;
        }

        // if sum has exceeded the required sum or the subarray is found
        if (sum > value || j == value)
        break;
        // add current element to current sum
        
        sum += t[j];
      }
    }
    return new int[0];
  }

}
