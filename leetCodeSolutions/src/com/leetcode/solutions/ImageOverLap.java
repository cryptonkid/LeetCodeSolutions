package com.leetcode.solutions;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 835. Image Overlap
 * https://leetcode.com/problems/image-overlap/
 * @author viveksingh
 *
 */
public class ImageOverLap {
	/**
	 * Space: O(1)
	 * Time : O(N^4)
	 * Approach 1: Shift and Count
	 *
	 */
	public int largestOverlap1(int[][] A, int[][] B) {
        int maxCount = 0;
        for(int rowShift=0;rowShift<A.length;rowShift++){
            for(int colShift = 0 ; colShift < A.length; colShift++){
                maxCount = Math.max(maxCount,getShift(rowShift,colShift,A,B));
                maxCount = Math.max(maxCount,getShift(rowShift,colShift,B,A));
                //One important insight is that shifting one matrix to a direction is equivalent 
                //to shifting the other matrix to the opposite direction, 
                //in the sense that we would have the same overlapping zone at the end.
                //Hence B,A is also done. 
            }
        }
        return maxCount;
    }
	/**
	 *	 First we define the function shift_and_count(x_shift, y_shift, M, R) where we shift the matrix M with reference to the matrix R with the shifting coordinate (x_shift, y_shift) and then we count the overlapping ones in the overlapping zone.

	 *	T	 	he algorithm is organized as a loop over all possible combinations of shifting coordinates (x_shift, y_shift).

	 * M			ore specifically, the ranges of x_shift and y_shift are both [0, N-1] where NN is the width of the matrix.

	 * A			t	 each iteration, we invoke the function shift_and_count() twice to shift and count the overlapping zone, first with the matrix B as the reference and vice versa.
	 * @param rowShift
	 * @param colShift
	 * @param A
	 * @param B
	 * @return
	 */
    protected int getShift(int rowShift,int colShift,int A[][],int B[][]){
        int count = 0;
        int rRow = 0;
        for(int i = rowShift;i < A.length;i++){
            int rCol = 0;
            for(int j = colShift; j< A.length;j++){
                if(A[i][j] == 1 && A[i][j] == B[rRow][rCol]){
                    count = count + 1;
                }
                rCol = rCol + 1;
            }
            rRow = rRow + 1;
        }
        return count;
    }
    
    
    
    /**
     * Linear Transforamtion :
     * Space Complexity: O(N^2)
     * Time Complexity : O(N^4)
     * 
     *  
     */
//    Algorithm
//
//    The algorithm can be implemented in two overall steps.
//
//    First, we filter out those non-zero cells in each matrix respectively.
//
//    Second, we do a cartesian product on the non-zero cells. 
//    For each pair of the products, we calculate the corresponding linear transformation vector as
//    Vab = (Xb - Xa , Ya-Yb)
//    Then, we count the number of the pairs that have the same transformation vector, which is also the number of ones in the overlapping zone.
    protected List<Pair<Integer, Integer>> non_zero_cells(int[][] M) {
        List<Pair<Integer, Integer>> ret = new ArrayList<>();
        for (int row = 0; row < M.length; ++row)
            for (int col = 0; col < M.length; ++col)
                if (M[row][col] == 1)
                    ret.add(new Pair<>(row, col));
        return ret;
    }

    public int largestOverlap(int[][] A, int[][] B) {

        List<Pair<Integer, Integer>> A_ones = non_zero_cells(A);
        List<Pair<Integer, Integer>> B_ones = non_zero_cells(B);

        int maxOverlaps = 0;
        HashMap<Pair<Integer, Integer>, Integer> groupCount = new HashMap<>();

         for (Pair<Integer, Integer> a : A_ones)
            for (Pair<Integer, Integer> b : B_ones) {
                Pair<Integer, Integer> vec =
                    new Pair<>(b.getKey() - a.getKey(), b.getValue() - a.getValue());

                if (groupCount.containsKey(vec)) {
                    groupCount.put(vec, groupCount.get(vec) + 1);
                } else {
                    groupCount.put(vec, 1);
                }
                maxOverlaps = Math.max(maxOverlaps, groupCount.get(vec));
            }

        return maxOverlaps;
    }
	
	
}

//As the jfx pair is not part of openjdk. It is absenet in post jdk11. 
//Instead we can use AbstractMap.SimpleEntry and AbstractMap.SimpleImmutableEntry

//https://www.baeldung.com/java-pairs
//https://stackoverflow.com/questions/54677184/how-can-i-add-javafx-util-pair-to-project-compiled-with-jdk11-0-2
class TestPair{
	public static void test() {
		AbstractMap.SimpleEntry<Integer, String> entry 
		= new AbstractMap.SimpleEntry<>(1, "one");
		Integer key = entry.getKey();
		String value = entry.getValue();

	}
	
}
//ideally pair should be present. 
class Pair<T,U> {
    private final T key;
    private final U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public U getValue() {
        return this.value;
    }
}
