package com.astashin.graph

import java.util.*

class GraphCycleFinder(private val mainNode: Node) {

    private val stack = LinkedList<Node>()

    fun run(): List<Node> {
        val node = goNext(mainNode, null)
        return if(node != null) {
            removeNodesFromStack(node)
        } else {
            emptyList()
        }
    }

    private fun goNext(node: Node, parentNode: Node?): Node? {
        node.isVisited = true
        stack.push(node)
        node.edges.forEach {
            if(it != parentNode) {
                if(it.isVisited) {
                    return it
                } else {
                    val next = goNext(it, node)
                    if(next != null) {
                        return next
                    }
                }
            }
        }
        stack.pop()
        return null
    }

    private fun removeNodesFromStack(node: Node): List<Node> {
        while(stack.isNotEmpty()) {
            if(stack.last == node) {
                return stack
            } else {
                stack.removeLast()
            }
        }
        return emptyList()
    }
}