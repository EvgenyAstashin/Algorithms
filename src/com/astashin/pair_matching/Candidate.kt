package com.astashin.pair_matching

import kotlin.random.Random

data class Candidate(val number: Int) {

    var isSubmited = false

    lateinit var listOfPreferences: List<Employer>

    private var employerIndex = 0

    fun submitApplicationToEmployer(): Boolean {
        for (i in employerIndex until listOfPreferences.size) {
            val submitted = listOfPreferences[i].submitApplication(this)
            if (submitted) {
                employerIndex = i
                isSubmited = true
                return true
            }
        }
        return false
    }

    fun dismiss() {
        isSubmited = false
        employerIndex++
    }

    fun buildListOfPreferences(employers: Set<Employer>) {
        val localEmployers = ArrayList<Employer>(employers)
        val listOfPreferences = ArrayList<Employer>()
        for (i in employers.indices) {
            listOfPreferences.add(localEmployers.removeAt(Random.nextInt(0, localEmployers.size)))
        }
        this.listOfPreferences = listOfPreferences
    }
}