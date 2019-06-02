package com.salnikov.epam

import spock.lang.Specification

class ApplicationTest extends Specification {

    def "Name"() {
        given:
        def input = this.class.getResource("input.txt").path
        def output = this.class.getResource("output.txt").path
        String[] args = [input, output].toArray()

        when:
        def result = Application.main(args)

        then:
        noExceptionThrown()
    }
}
