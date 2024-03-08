/******************************************************************************
 *  Name: Nate Heim
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

The method takes the parameters a[], the search key, and a Comparator
that defines the ordering of the elements in the array. It then uses binary search
to find the first occurance of the key. It then uses variables lo and hi to keep
track of the current search range. Lo is set first to 0 and hi is set to the last array
index. Then using a while loop the method compares the search key with the middle 
element of the current search range. If the key is less than the middle element, it
decrements hi, if the key is greater than the middle element, it increments lo. This
continues until the first occurance of the key is found or lo becomes greater than hi.


/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: Nlog(N)

allMatches(): (N+M)log(M)

numberOfMatches(): log(N)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
As a standalone its not functional, but included in a project since its a tool it would be great.


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Kyle and Abby helped me

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/


N/A


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


