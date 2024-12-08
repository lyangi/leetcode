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

## 26. Remove Duplicates from Sorted Array
    Type: array, two pointer
    Begin to the index 1, because the first number is unique. Remove element also can move the others to the front, the element to the end.
    Time complexity is O(n)

## 80. Remove Duplicates from Sorted Array II
    Type: array, two pointer
    My solution is use a variable to count whether the number reaches 2
    Another solution is similar to No.26
    Begin to the index 1, because the first and second number is unique(whether is same or not). compare the current number with k - 2 number, Remove element also can move the others to the front, the element to the end.
    Time complexity is O(n)

## 169. Majority Element
    Type: array
    Boyer-Moore Voting Algorithm
    Set a candidate number and a count, traversal the array, if the candidate number is equal to the number in the array then count + 1, if not count - 1, the return is candidate.
    Time complexity is O(n)

## 189. Rotate Array
    Type: array
    Reverse array can use two points, while left < right, change the array value, and in this problem, we need reverse 3 times, reverse(0, len-1), reverse(0, k-1), reverse(k, len-1).
    Time complexity is O(n)
    space complexity is O(1)

## 121. 122 Best time to buy and sell stock I II
    Type: array greedy
    Set the start is array[0], if profit more than max, add the profit.
    Time complexity is O(n)

## 55. 45 Jump Game I II
    Type: array greedy
    I: Reverse thinking, set goal on the last index, if the forward index can reach to goal, it can jump, iteration to the first index.
    II: Set a range near to far, and for loop in the range, find the farthest and update the near far value.
    Time complexity is O(n)