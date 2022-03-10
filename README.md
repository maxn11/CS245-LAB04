# CS245-LAB04
Multisum/findFactors
- This program has a set integer, n, and will print out all factor combinations of that number. This implies that n >= 0 and of integer type.
- A few friends in class and I worked on this together and came to this result. We knew recursion would most likely be the best option since it was briefly discussed in class. The main runs multisum which creates a new array and passes it into the findFactors function. findFactors then sets a base case and then creates a subList that stores individual sets of factors. Then it adds current number i to the subList and (n / i), and when done recursivly, it provides the factors into subsets. Once the subList is added to arrList, it recurses with i + 1.
- Runtime: The best case is O(1) since if n is 1, the program will hit the basecase immediately and return 1.
