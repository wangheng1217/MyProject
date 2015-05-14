package wangheng.others.dp;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * 
 * Partition problem is to determine whether a given set can be partitioned 
 * into two subsets such that the sum of elements in both subsets is same.
 * 
 * - should be positive integers?
 * 
 * Example: {1, 5, 11, 5}
 * 
 * solution 1: (exponential complexity, work better when set size is small and integers are large
 * 1 -> 1
 * 5 -> 4, 6
 * 11 -> 7, 15, 5, 17
 * 5 -> bingo!
 * 
 * solution 2: (DP, O(sum*n), Please note that this solution will not be feasible for arrays with big sum.)
 * 
 * Let isSubsetSum(arr, n, sum/2) be the function that returns true if 
there is a subset of arr[0..n-1] with sum equal to sum/2

The isSubsetSum problem can be divided into two subproblems
 a) isSubsetSum() without considering last element 
    (reducing n to n-1)
 b) isSubsetSum considering the last element 
    (reducing sum/2 by arr[n-1] and n to n-1)
If any of the above the above subproblems return true, then return true. 
isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
                              isSubsetSum (arr, n-1, sum/2 - arr[n-1])
 * 
 * 
 */
public class PartitionProblem {

}
