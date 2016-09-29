/**
 * 
 */
package c388.longest.absolute.file.path;


import java.util.Stack;

/**
 * Suppose we abstract our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 * <blockquote>
 * 
 * <pre>
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * </pre>
 * 
 * </blockquote>
 * 
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory
 * subdir2 containing a file file.ext.
 * <p>
 * The string
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * represents:
 * 
 * <blockquote>
 * 
 * <pre>
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 * </pre>
 * 
 * </blockquote>
 * 
 * 
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1
 * contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file
 * file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path
 * to a file within our file system. For example, in the second example above,
 * the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its
 * length is 32 (not including the double quotes).
 * <p>
 * Given a string representing the file system in the above format, return the
 * length of the longest absolute path to file in the abstracted file system. If
 * there is no file in the system, return 0.
 * <p>
 * Note:<br>
 * The name of a file contains at least a . and an extension.<br>
 * The name of a directory or sub-directory will not contain a ..<br>
 * Time complexity required: O(n) where n is the size of the input string.
 * <p>
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is
 * another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {

	public int lengthLongestPath(String input) {

		if (input == null || input.length() == 0) {
			return 0;
		}

		Stack<Integer> path = new Stack<Integer>();
		input = input.replace("\t", "/");
		int max = 0;
		int cur = 0;
		int depth = 0;

		String[] array = input.split("\n");

		for (String s : array) {
			depth = getDepth(s);
			while (depth < path.size()) {
				cur -= path.pop() + 1;
			}

			if (s.contains(".")) {
				max = ((cur + s.length() - depth) > max) ? (cur + s.length() - depth)
						: max;
//				System.out.println(path + "\ncount--cur:" + cur + " max:" + max
//						+ " s.length:" + (s.length() - depth) + " s:" + s);
			} else {
				path.push(s.length() - depth);
				cur += path.peek() + 1;
//				System.out.println(path + "\npush--cur:" + cur + " max:" + max
//						+ " s.length:" + (s.length() - depth) + " s:" + s);
			}

		}

		return max;
	}

	public int getDepth(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '/') {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		Solution sln = new Solution();
		System.out.println(sln.lengthLongestPath(s));
		
		
		System.out.println(sln.lengthLongestPath("afile"));
		System.out.println(sln.lengthLongestPath("a.file"));
	}
}
