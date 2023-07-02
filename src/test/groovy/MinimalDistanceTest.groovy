import com.example.MinimalDistance
import spock.lang.Specification

class MinimalDistanceTest extends Specification {

    def 'It should throw on invalid input'() {
        when:
        MinimalDistance.minimalDistance(word1, word2)

        then:
        thrown(IllegalArgumentException)

        where:
        word1              | word2
        null               | 'any valid string'
        'any valid string' | null
        null               | null
    }

    def 'It should calculate levenshtein distance'() {
        expect:
        MinimalDistance.minimalDistance(word1, word2) == expectedResult

        where:
        word1           | word2            | expectedResult
        ''              | ''               | 0
        ''              | 'all insertions' | 14
        'all deletions' | ''               | 13
        's'             | 's'              | 0
        's'             | 't'              | 1
        'full match'    | 'full match'     | 0
        'sitting'       | 'kitten'         | 3
        'qwerty'        | 'asdfgh'         | 6
    }

}
