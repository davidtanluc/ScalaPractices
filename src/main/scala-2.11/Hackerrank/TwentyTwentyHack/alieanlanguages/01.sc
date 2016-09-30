/*
https://www.hackerrank.com/contests/monthly/challenges/alien-languages

Sophia has discovered several alien languages. Surprisingly, all of these languages have an alphabet, and each
of them may contain thousands of characters! Also, all the words in a language have the same number of characters in it.

However, the aliens like their words to be aesthetically pleasing, which for them means that for the

ith letter of an n letter alphabet (letters are indexed at 1): //starting index 1

if 2 * i > n
the ith letter may be the last letter of a word, and it may be immediately followed by any letter including itself.


if 2 * i ≤ n
the ith letter can not be the last letter of a word and also can only be immediately followed by jth letter iff j ≥ 2 * i.

Sophia wants to know how many different words exist in this language. ( how many words??)

Since the result may be large, she wants to know this number, modulo 100000007.

----------------
Input
----------------

The first line contains t, the number of test cases. The first line is followed by t lines,
each line denoting a test case. Each test case will have two space separated integers n,*m* which denote the number of
letters in the language and the length of words in this language respectively.

----------------
Output
----------------


For each testcase output the number of possible words modulo 100000007.

Constraints

1 ≤ t ≤ 5
1 ≤ n ≤ 105
1 ≤ m ≤ 5*105

Sample Input

3
1 3
2 3
3 2
Sample Output

1
3
6
Explanation
For the first test-case, there's one letter and all the words consist of 3 letters. There's only one possibility which
is "aaa"

For the second test-case, there are two letters (a & b) and all the words are of 3 letters. The possible ones
are "abb", "bab", & "bbb". The words can end only with 'b' because 2 * index(b) = 2 * 2 > 2 and for 'a',
it's 2 * index(a) = 2 * 1 <= 2. "aab" is not allowed because 'a' can not be followed immediately by 'a'.
For a word of length 4 and alphabet of size 2, "abab" would be allowed.

For the third test-case, there are three letters (a, b & c) and all of the words are 2 letters.
The words can end only with 'b' or 'c'. The possible words are "ab", "ac", "bb", "cc", "bc", "cb"


 */