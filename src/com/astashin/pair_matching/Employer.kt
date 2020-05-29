package com.astashin.pair_matching

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

data class Employer(val number: Int, val numberOfVacancies: Int) {

    val setOfVacancies: MutableSet<Vacancy> = TreeSet<Vacancy>()

    init {
        for(i in 0 until numberOfVacancies) {
            setOfVacancies.add(Vacancy(Int.MAX_VALUE - i))
        }
    }

    lateinit var listOfPreferences: List<Candidate>

    fun submitApplication(newCandidate: Candidate): Boolean {
        val vacancy = setOfVacancies.last()
        if(vacancy.candidate == null) {
            setOfVacancies.remove(vacancy)
            vacancy.candidate = newCandidate
            vacancy.priority = listOfPreferences.indexOf(newCandidate)
            setOfVacancies.add(vacancy)
            return true
        } else {
            val newPriority = listOfPreferences.indexOf(newCandidate)
            if(newPriority < vacancy.priority) {
                setOfVacancies.remove(vacancy)
                vacancy.candidate?.dismiss()
                vacancy.candidate = newCandidate
                vacancy.priority = newPriority
                setOfVacancies.add(vacancy)
                return true
            }
        }
        return false
    }


    fun buildListOfPreferences(candidates: Set<Candidate>) {
        val localCandidates = ArrayList<Candidate>(candidates)
        val listOfPreferences = ArrayList<Candidate>()
        for (i in candidates.indices) {
            listOfPreferences.add(localCandidates.removeAt(Random.nextInt(0, localCandidates.size)))
        }
        this.listOfPreferences = listOfPreferences
    }
}