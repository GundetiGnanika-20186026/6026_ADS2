/**
 * Class for quick 3 string.
 */
class Quick3string {
    /**
     * // cutoff to insertion sort.
     */
    private static final int CUTOFF =  15;

    // do not instantiate

    /**
     * Constructs the object.
     */
    Quick3string() { }

    /**
     * Rearranges the array of strings in ascending order.
     * its complexity is 1.39WNlog(N)*.
     *
     * @param a the array to be sorted
     */
    public  void sort(final String[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);
       // assert isSorted(a);
    }



    /**
     * // return the dth character of s, -1 if d = length of s.
     * its complexity is O(1).
     *
     * @param      s     { string }.
     * @param      d     { row }.
     *
     * @return     {dth character of s }
     */
    private  int charAt(final String s, final int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) {
            return -1;
        }
        return s.charAt(d);
    }




    /**
     *  // 3-way string quicksort a[lo..hi] starting at dth character.
     *  its complexity is 1.39WNlog(N)*.
     *
     * @param      a     { String array}
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      d     { the row in string }
     */
    private  void sort(final String[] a, final int lo,
                             final int hi, final int d) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo) {
            //insertion(a, lo, hi, d);
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
                exch(a, lt++, i++);
            } else if (t > v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }



    // /**
    //  *sort from a[lo] to a[hi], starting at the dth character.
    //  *
    //  * @param      a     { String array }
    //  * @param      lo    The lower
    //  * @param      hi    The higher
    //  * @param      d     { row in a string }
    //  */
    // private  void insertion(final String[] a, final int lo,
    //                               final int hi, final int d) {
    //     for (int i = lo; i <= hi; i++) {
    //         for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
    //             exch(a, j, j - 1);
    //         }
    //     }
    // }



    /**
     * exchange a[i] and a[j] .
     * its complexity is O(1).
     *
     * @param      a     { String array }
     * @param      i     { index1 }
     * @param      j     { index2 }
     */
    private  void exch(final String[] a,
                             final int i, final int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




    // /**
    //  *  is v less than w, starting at character d.
    //  *
    //  * @param      v     { String }
    //  * @param      w     { String }
    //  * @param      d     { row  }
    //  *
    //  * @return     { true or false }
    //  */
    // private  boolean less(final String v, final String w, final int d) {
    //     assert v.substring(0, d).equals(w.substring(0, d));
    //     for (int i = d; i < Math.min(v.length(), w.length()); i++) {
    //         if (v.charAt(i) < w.charAt(i)) {
    //             return true;
    //         }
    //         if (v.charAt(i) > w.charAt(i)) {
    //             return false;
    //         }
    //     }
    //     return v.length() < w.length();
    // }



    // /**
    //  * Determines if sorted.
    //  *  // is the array sorted
    //  *
    //  * @param      a     { string array }
    //  *
    //  * @return     True if sorted, False otherwise.
    //  */
    // private  boolean isSorted(final String[] a) {
    //     for (int i = 1; i < a.length; i++) {
    //         if (a[i].compareTo(a[i - 1]) < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

