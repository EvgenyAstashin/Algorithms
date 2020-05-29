package com.astashin.pair_matching

class Vacancy(var priority: Int) : Comparable<Vacancy> {

    var candidate: Candidate? = null

    override fun compareTo(other: Vacancy): Int {
        return  priority.compareTo(other.priority)
    }
}