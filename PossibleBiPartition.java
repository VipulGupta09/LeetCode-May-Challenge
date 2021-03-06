package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PossibleBiPartition {

	public static void main(String[] args) {
		int[][] dislikes= {{1,2},{1,3},{1,4}};
		System.out.println(possibleBipartition(4, dislikes));

	}
	public static boolean possibleBipartition(int N, int[][] dislikes) {
	    // union found split two group
	    // GroupA : all hate b, GroupB: all hate a; 
	        int[] group = new int[N+1];
	        for (int i = 0; i <= N; i++) {
	            group[i] = i; // initial
	        }
	        
	        for (int[] dislike : dislikes) {
	            int a = dislike[0];
	            int b = dislike[1];
	            
	            if (group[a] == a && group[b] == b) {
	                group[a] = b;
	                group[b] = a;
	            } else if (group[a] == a && group[b] != b) {
	                // let a go to group that all hate b;
	                group[a] = group[group[b]];
	            } else if (group[b] ==b && group[a] != a) {
	                group[b] = group[group[a]];
	            } else if (group[b] == group[a]) {
	                return false;
	            }
	        }
	        return true;        
	    }
	

}
