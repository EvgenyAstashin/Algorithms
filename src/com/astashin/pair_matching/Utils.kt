package com.astashin.pair_matching

fun getCandidates(numberOfCandidates: Int): Set<Candidate> =
    HashSet<Candidate>().apply {
        for (i in 0 until numberOfCandidates) {
            this.add(Candidate(i + 1))
        }
    }

fun getEmployers(numberOfEmployers: Int, numberOfVacancies: Int): Set<Employer> =
    HashSet<Employer>().apply {
        for (i in 0 until numberOfEmployers) {
            this.add(Employer(i + 1, numberOfVacancies))
        }
    }

fun Set<Candidate>.buildListOfPreferencesForCandidates(employers: Set<Employer>) {
    this.forEach {
        it.buildListOfPreferences(employers)
    }
}

fun Set<Employer>.buildListOfPreferencesForEmployers(candidates: Set<Candidate>) {
    this.forEach {
        it.buildListOfPreferences(candidates)
    }
}