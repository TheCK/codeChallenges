# Challenges (1/1)

## Greeks (1/1)

|    # | Name                   | Description                                                                                                                                                             | Solution                         | Test                          |
|-----:|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------:|:-----------------------------:|
| 1001 | Alpha 2010 (PrefixSet) | [Given a table A of N integers from 0 to N-1 calculate the smallest such index P, that that {A&#91;0&#93;,...,A&#91;N-1&#93;} = {A&#91;0&#93;,...,A&#91;P&#93;}.][1001] | &#9989;[&#128190;][1001solution] | &#9989;[&#128190;][1001tests] |

[1001]: https://codility.com/programmers/challenges/alpha2010

[1001solution]: src/main/java/org/ck/codility/challenges/alpha2010/Solution.java

[1001tests]: src/test/java/org/ck/codility/challenges/alpha2010/SolutionTest.java

# Lessons (8/10)

## 1. Time Complexity (3/3)

|  # | Name            | Description                                                                                                         | Solution                       | Test                        |
|---:|-----------------|---------------------------------------------------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
|  1 | TapeEquilibrium | [Minimize the value &#124;(A&#91;0&#93; + ... + A&#91;P-1&#93;) - (A&#91;P&#93; + ... + A&#91;N-1&#93;)&#124;.][1]  | &#9989;[&#128190;][1solution]  | &#9989;[&#128190;][1tests]  |
|  2 | PermMissingElem | [Find the missing element in a given permutation.][2]                                                               | &#9989;[&#128190;][2solution]  | &#9989;[&#128190;][2tests]  |
|  3 | FrogJmp         | [Count minimal number of jumps from position X to Y.][3]                                                            | &#9989;[&#128190;][3solution]  | &#9989;[&#128190;][3tests]  |

[1]: https://codility.com/programmers/lessons/1
[2]: https://codility.com/programmers/lessons/1
[3]: https://codility.com/programmers/lessons/1

[1solution]: src/main/java/org/ck/codility/lessons/timeComplexity/tapeEquilibrium/Solution.java
[2solution]: src/main/java/org/ck/codility/lessons/timeComplexity/permMissingElem/Solution.java
[3solution]: src/main/java/org/ck/codility/lessons/timeComplexity/frogJmp/Solution.java

[1tests]: src/test/java/org/ck/codility/lessons/timeComplexity/tapeEquilibrium/SolutionTest.java
[2tests]: src/test/java/org/ck/codility/lessons/timeComplexity/permMissingElem/SolutionTest.java
[3tests]: src/test/java/org/ck/codility/lessons/timeComplexity/frogJmp/SolutionTest.java


## 2. Counting Elements (4/4)

|  # | Name           | Description                                                                                                                                            | Solution                       | Test                        |
|---:|----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
| 11 | FrogRiverOne   | [Find the earliest time when a frog can jump to the other side of a river.][11]                                                                        | &#9989;[&#128190;][11solution] | &#9989;[&#128190;][11tests] |
| 12 | PermCheck      | [Check whether array A is a permutation.][12]                                                                                                          | &#9989;[&#128190;][12solution] | &#9989;[&#128190;][12tests] |
| 13 | MissingInteger | [Find the minimal positive integer not occurring in a given sequence.][13]                                                                             | &#9989;[&#128190;][13solution] | &#9989;[&#128190;][13tests] |
| 14 | MaxCounters    | [Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.][14] | &#9989;[&#128190;][14solution] | &#9989;[&#128190;][14tests] |

[11]: https://codility.com/programmers/lessons/2
[12]: https://codility.com/programmers/lessons/2
[13]: https://codility.com/programmers/lessons/2
[14]: https://codility.com/programmers/lessons/2

[11solution]: src/main/java/org/ck/codility/lessons/countingElements/frogRiverOne/Solution.java
[12solution]: src/main/java/org/ck/codility/lessons/countingElements/permCheck/Solution.java
[13solution]: src/main/java/org/ck/codility/lessons/countingElements/missingInteger/Solution.java
[14solution]: src/main/java/org/ck/codility/lessons/countingElements/maxCounters/Solution.java

[11tests]: src/test/java/org/ck/codility/lessons/countingElements/frogRiverOne/SolutionTest.java
[12tests]: src/test/java/org/ck/codility/lessons/countingElements/permCheck/SolutionTest.java
[13tests]: src/test/java/org/ck/codility/lessons/countingElements/missingInteger/SolutionTest.java
[14tests]: src/test/java/org/ck/codility/lessons/countingElements/maxCounters/SolutionTest.java


## 3. Prefix Sums (1/3)

|  # | Name           | Description                                                                   | Solution                       | Test                        |
|---:|----------------|-------------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
| 21 | CountDiv       | [Compute number of integers divisible by k in range &#91;a..b&#93;.][21]      | [&#128190;][21solution]        | [&#128190;][21tests]        |
| 22 | PassingCars    | [Count the number of passing cars on the road.][22]                           | &#9989;[&#128190;][22solution] | &#9989;[&#128190;][22tests] |
| 23 | MinAvgTwoSlice | [Find the minimal average of any slice containing at least two elements.][23] | [&#128190;][23solution]        | [&#128190;][23tests]        |

[21]: https://codility.com/programmers/lessons/3
[22]: https://codility.com/programmers/lessons/3
[23]: https://codility.com/programmers/lessons/3

[21solution]: src/main/java/org/ck/codility/lessons/prefixSums/countDiv/Solution.java
[22solution]: src/main/java/org/ck/codility/lessons/prefixSums/passingCars/Solution.java
[23solution]: src/main/java/org/ck/codility/lessons/prefixSums/minAvgTwoSlice/Solution.java

[21tests]: src/test/java/org/ck/codility/lessons/prefixSums/countDiv/SolutionTest.java
[22tests]: src/test/java/org/ck/codility/lessons/prefixSums/passingCars/SolutionTest.java
[23tests]: src/test/java/org/ck/codility/lessons/prefixSums/minAvgTwoSlice/SolutionTest.java

