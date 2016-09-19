/**
 * 
 */
package c120.triangle;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
<p>
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
<p>
Note:<br>
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
<p>
Subscribe to see which companies asked this question
<p>
Hide Tags Array Dynamic Programming
<p>
 * @author WangHaitao
 *
 */
public class Solution {
	 public int minimumTotal(List<List<Integer>> triangle) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if (triangle.size() == 0) {
				return 0;
			}
			if (triangle.size() == 1) {
				return triangle.get(0).get(0);
			}

			int i = triangle.size() - 2;
			int j, temp;
			while (i >= 0) {
				for (j = 0; j < triangle.get(i).size(); ++j) {
					if (triangle.get(i + 1).get(j) <= triangle.get(i + 1)
							.get(j + 1)) {
						temp = triangle.get(i).get(j) + triangle.get(i + 1).get(j);
					} else {
						temp = triangle.get(i).get(j)
								+ triangle.get(i + 1).get(j + 1);
					}
					triangle.get(i).remove(j);
					triangle.get(i).add(j, temp);
				}
				--i;
			}
			return triangle.get(0).get(0);
	    }
}
