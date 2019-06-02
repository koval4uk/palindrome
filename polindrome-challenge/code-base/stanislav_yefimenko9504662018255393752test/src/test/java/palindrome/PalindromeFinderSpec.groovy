package palindrome

import spock.lang.Specification

class PalindromeFinderSpec extends Specification {

    def palindromeFinder = new PalindromeFinder();

    def "isPalindrome"() {
        expect:
        result == palindromeFinder.isPalindrome(source)

        where:
        source          | result
        "test"          | false
        "testset"       | true
        "qwert 0 trew"  | false
        "qwert 0 trewq" | true
    }
}
