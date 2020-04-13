package com.astashin.pair_matching

fun getCandidates(numberOfCandidates: Int, numberOfEmployersForCandidate: Int): Set<Candidate> =
    HashSet<Candidate>().apply {
        for (i in 0..numberOfCandidates) {
            this.add(Candidate())
        }
    }

fun getEmployers(numberOfEmployers: Int, numberOfCandidatesForEmployers: Int): Set<Employer> =
    HashSet<Employer>().apply {
        for (i in 0..numberOfEmployers) {
            this.add(Employer())
        }
    }

fun Set<Candidate>.buildListOfPreferencesForCandidates(employers: Set<Employer>) {

}

fun Set<Employer>.buildListOfPreferencesForEmployers(employers: Set<Candidate>) {

}