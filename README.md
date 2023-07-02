Edit distance

The code in this project measures edit distance between two words:

_Given two words word1 and word2, calculates the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character_

How to run:
- Groovy tests: `mvn test` in the project root directory
- JMH tests: `mvn jmh:benchmark` in the project root directory. Benchmark execution may take several minutes
- Executing main:
  - Compile class: `javac com.example.MinimalDistance.java` in `src/main/java/com/example` directory
  - Execute java app: `java com.example.MinimalDistance "word1" "word2"`
