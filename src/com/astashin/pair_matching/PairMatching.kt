package com.astashin.pair_matching

class PairMatching(private val listOfEmployers: Set<Employer>, private val listOfCandidates: Set<Candidate>) {

    fun run() {
        var wasSubmited = true

        while (wasSubmited) {
            wasSubmited = false
            listOfCandidates.forEach { candidate ->
                if(!candidate.isSubmited) {
                    val submited = candidate.submitApplicationToEmployer()
                    if (submited)
                        wasSubmited = true
                }
            }
        }
    }
}