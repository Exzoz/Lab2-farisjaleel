# Lab 2 Questions

#

1. _1)__What is the complexity of each of the four search methods in terms of array or list size n?_

      - 0(n) would be the complexity for the first three methods. However for the last one we have a binary search. With this we eliminate half the possible entries in each iteration. This is what is so good or powerful about binary search. The time complexity of a binary search algorithm would be 0(log n).

_2)   What happens in the case of binary search if the array is not sorted?_

     -  Binary search assumes that the array would be sorted and thus most likely we would miss the element we are searching for. Binary search eliminates the possibilities so this would be problematic.

_3)    What is the purpose of constructor argument validity checking?_

     - We need to be able to validate the constructor arguments by making sure they have valid objects otherwise the searches would end up failing.

_4)    What is the purpose of using the keyword &quot;final&quot; with variables and arguments?_

      -  By setting the term final first for a variable or argument, it sets the precedent technically that the value will not change throughout the code and thus we do not have to keep redefining or assuming that it is different in different parts of the code. By doing this we specify that variables or arguments are not to be changed

_5)     What are the alternatives to using &quot;Optional&quot; and how do they compare?_

      -  We could have it return null of -1 in a certain case of not found but in doing so those values will have to be null checked prior to using them
