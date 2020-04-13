package com.astashin.pair_matching

const val NUMBER_OF_EMPLOYERS = 1
const val NUMBER_OF_CANDIDATES = 1
const val NUMBER_OF_CANDIDATES_FOR_EMPLOYER = 1
const val NUMBER_OF_EMPLOYERS_FOR_CANDIDATE = 1

fun main() {
    val listOfCandidates: Set<Candidate> = getCandidates(NUMBER_OF_CANDIDATES, NUMBER_OF_EMPLOYERS_FOR_CANDIDATE)
    val listOfEmployers: Set<Employer> = getEmployers(NUMBER_OF_EMPLOYERS, NUMBER_OF_CANDIDATES_FOR_EMPLOYER)

    val algorithm = PairMatching(listOfEmployers, listOfCandidates)
    algorithm.run()
}