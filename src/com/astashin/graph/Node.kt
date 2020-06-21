package com.astashin.graph

class Node(val id: Int) {

    val edges = ArrayList<Node>()

    var isVisited = false
}