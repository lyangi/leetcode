# leetcode
my leetcode 

## 88. Merge Sorted Array
    Type: Array
    merge array forward or reverse, forward need to creat a new array to store, reverse not need.
    also can use api System.arraycopy, it is a native method by memmove.
    Time complexity is O(m + n)

## 21. Merge Two Sorted Lists
    Type: LinkedList
    merge sorted list need to creat a dummy node, and compare the value of the list1 and the list2, link the smaller node to the current node, if list1 or list2 has remaining nodes, just link to current node.
    Time complexity is O(m + n)

## 21. Remove Element
    Type: array, two pointer
    Remove element also can move the others to the front, the element to the end.
    Time complexity is O(n)