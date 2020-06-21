package com.astashin.graph

import java.lang.Exception
import kotlin.random.Random

object Utils {

    fun buildGraph(nodeCount: Int, maxEdgesForNode: Int = nodeCount - 1, directed: Boolean = false): List<Node> {
        if (maxEdgesForNode < 1 || maxEdgesForNode >= nodeCount) {
            throw Exception("incorrect edges")
        }

        val graph = createNodes(nodeCount)

        graph.forEach { node ->
            val listOfNodes = ArrayList<Node>(graph)
            listOfNodes.remove(node)
            listOfNodes.removeAll(node.edges)
            while (node.edges.size < maxEdgesForNode) {
                if(Random.nextInt(0, 10) < 3) break
                val nearNode = listOfNodes.removeAt(Random.nextInt(0, listOfNodes.size))
                if(nearNode.edges.size < maxEdgesForNode) {
                    node.edges.add(nearNode)
                    if (!directed) {
                        nearNode.edges.add(node)
                    }
                }
            }
        }

        return graph
    }

    private fun createNodes(nodeCount: Int): List<Node> {
        val result = ArrayList<Node>()
        for (i in 0 until nodeCount) {
            result.add(Node(i))
        }
        return result
    }
}