package com.astashin.pair_matching

const val NUMBER_OF_EMPLOYERS = 5
const val NUMBER_OF_CANDIDATES = 15
const val NUMBER_OF_VACANCIES = 2

fun main() {
    val listOfCandidates: Set<Candidate> = getCandidates(NUMBER_OF_CANDIDATES)
    val listOfEmployers: Set<Employer> = getEmployers(NUMBER_OF_EMPLOYERS, NUMBER_OF_VACANCIES)

    listOfCandidates.buildListOfPreferencesForCandidates(listOfEmployers)
    listOfEmployers.buildListOfPreferencesForEmployers(listOfCandidates)

    val algorithm = PairMatching(listOfEmployers, listOfCandidates)
    algorithm.run()
}