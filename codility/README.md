# Challenges (1/1)

## Greeks (1/1)

|    # | Name                           | Description                                                                                                                                                     | Solution                         | Test                          |
|-----:|--------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------:|:-----------------------------:|
| 1001 | [Alpha 2010 (PrefixSet)][1001] | Given a table A of N integers from 0 to N-1 calculate the smallest such index P, that that {A&#91;0&#93;,...,A&#91;N-1&#93;} = {A&#91;0&#93;,...,A&#91;P&#93;}. | &#9989;[&#128190;][1001solution] | &#9989;[&#128190;][1001tests] |

[1001]: https://codility.com/programmers/challenges/alpha2010

[1001solution]: src/main/java/org/ck/codility/challenges/alpha2010/Solution.java

[1001tests]: src/test/java/org/ck/codility/challenges/alpha2010/SolutionTest.java

# Lessons (8/10)

## 1. Time Complexity (3/3)

|  # | Name                  | Description                                                                                                   | Solution                       | Test                        |
|---:|-----------------------|---------------------------------------------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
|  1 | [TapeEquilibrium][1]  | Minimize the value &#124;(A&#91;0&#93; + ... + A&#91;P-1&#93;) - (A&#91;P&#93; + ... + A&#91;N-1&#93;)&#124;. | &#9989;[&#128190;][1solution]  | &#9989;[&#128190;][1tests]  |
|  2 | [PermMissingElem][2]  | Find the missing element in a given permutation.                                                              | &#9989;[&#128190;][2solution]  | &#9989;[&#128190;][2tests]  |
|  3 | [FrogJmp][3]          | Count minimal number of jumps from position X to Y.                                                           | &#9989;[&#128190;][3solution]  | &#9989;[&#128190;][3tests]  |

[1]: https://codility.com/programmers/lessons/1
[2]: https://codility.com/programmers/lessons/1
[3]: https://codility.com/programmers/lessons/1

[1solution]: src/main/java/org/ck/codility/lessons/timecomplexity/tapeequilibrium/Solution.java
[2solution]: src/main/java/org/ck/codility/lessons/timecomplexity/permmissingelem/Solution.java
[3solution]: src/main/java/org/ck/codility/lessons/timecomplexity/frogjmp/Solution.java

[1tests]: src/test/java/org/ck/codility/lessons/timecomplexity/tapeequilibrium/SolutionTest.java
[2tests]: src/test/java/org/ck/codility/lessons/timecomplexity/permmissingelem/SolutionTest.java
[3tests]: src/test/java/org/ck/codility/lessons/timecomplexity/frogjmp/SolutionTest.java


## 2. Counting Elements (4/4)

|  # | Name                 | Description                                                                                                                                      | Solution                       | Test                        |
|---:|----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
| 11 | [FrogRiverOne][11]   | Find the earliest time when a frog can jump to the other side of a river.                                                                        | &#9989;[&#128190;][11solution] | &#9989;[&#128190;][11tests] |
| 12 | [PermCheck][12]      | Check whether array A is a permutation.                                                                                                          | &#9989;[&#128190;][12solution] | &#9989;[&#128190;][12tests] |
| 13 | [MissingInteger][13] | Find the minimal positive integer not occurring in a given sequence.                                                                             | &#9989;[&#128190;][13solution] | &#9989;[&#128190;][13tests] |
| 14 | [MaxCounters][14]    | Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum. | &#9989;[&#128190;][14solution] | &#9989;[&#128190;][14tests] |

[11]: https://codility.com/programmers/lessons/2
[12]: https://codility.com/programmers/lessons/2
[13]: https://codility.com/programmers/lessons/2
[14]: https://codility.com/programmers/lessons/2

[11solution]: src/main/java/org/ck/codility/lessons/countingelements/frogeiverone/Solution.java
[12solution]: src/main/java/org/ck/codility/lessons/countingelements/permcheck/Solution.java
[13solution]: src/main/java/org/ck/codility/lessons/countingelements/missinginteger/Solution.java
[14solution]: src/main/java/org/ck/codility/lessons/countingelements/maxcounters/Solution.java

[11tests]: src/test/java/org/ck/codility/lessons/countingelements/frogeiverone/SolutionTest.java
[12tests]: src/test/java/org/ck/codility/lessons/countingelements/permcheck/SolutionTest.java
[13tests]: src/test/java/org/ck/codility/lessons/countingelements/missinginteger/SolutionTest.java
[14tests]: src/test/java/org/ck/codility/lessons/countingelements/maxcounters/SolutionTest.java


## 3. Prefix Sums (1/3)

|  # | Name                 | Description                                                             | Solution                       | Test                        |
|---:|----------------------|-------------------------------------------------------------------------|:------------------------------:|:---------------------------:|
| 21 | [CountDiv][21]       | Compute number of integers divisible by k in range &#91;a..b&#93;.      | [&#128190;][21solution]        | [&#128190;][21tests]        |
| 22 | [PassingCars][22]    | Count the number of passing cars on the road.                           | &#9989;[&#128190;][22solution] | &#9989;[&#128190;][22tests] |
| 23 | [MinAvgTwoSlice][23] | Find the minimal average of any slice containing at least two elements. | [&#128190;][23solution]        | [&#128190;][23tests]        |

[21]: https://codility.com/programmers/lessons/3
[22]: https://codility.com/programmers/lessons/3
[23]: https://codility.com/programmers/lessons/3

[21solution]: src/main/java/org/ck/codility/lessons/prefixsums/countdiv/Solution.java
[22solution]: src/main/java/org/ck/codility/lessons/prefixsums/passingcars/Solution.java
[23solution]: src/main/java/org/ck/codility/lessons/prefixsums/minavgtwoslice/Solution.java

[21tests]: src/test/java/org/ck/codility/lessons/prefixsums/countdiv/SolutionTest.java
[22tests]: src/test/java/org/ck/codility/lessons/prefixsums/passingcars/SolutionTest.java
[23tests]: src/test/java/org/ck/codility/lessons/prefixsums/minavgtwoslice/SolutionTest.java

