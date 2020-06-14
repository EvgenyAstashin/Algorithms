package com.astashin.graph

interface INode {

    val id: Int

    val edges: List<INode>
}

class Node(override val id: Int) : INode {

    override val edges = ArrayList<INode>()
}