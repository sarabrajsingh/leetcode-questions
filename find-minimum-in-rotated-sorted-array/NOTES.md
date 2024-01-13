-> it seems like it doesn't matter how many times the array is rotated, the min element will always be the min element, because the rotations are not destructive
-> the question is asking for basically a min search algorithmn that works in O(log (n)) time which automatically is binary search
  -> im concluding that we need to use binary search right away because of the fact that the data elements are sorted for us already
-> can we just find the min elem in the un-rotated array and just return that as the answer?


-> the array can be rotated (n) times
-> the array elements are sorted in ascending order
-> our goal is O(log (n)) time (hint hint towards Binary Search)
-> rotations usually involve some sort of inflextion point
  -> our goal is to find the inflextion point; and find the smallest value at (inflex_point + 1)