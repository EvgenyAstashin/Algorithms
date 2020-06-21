package com.astashin.graph

fun main() {

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)

    node1.edges.add(node2)
    node2.edges.add(node1)

    node1.edges.add(node3)
    node3.edges.add(node1)

    node2.edges.add(node4)
    node4.edges.add(node2)

    node4.edges.add(node6)
    node6.edges.add(node4)

    node5.edges.add(node4)
    node4.edges.add(node5)

    node3.edges.add(node4)
    node4.edges.add(node3)

    node3.edges.add(node5)
    node5.edges.add(node3)

    val result = GraphCycleFinder(node1).run()

    if (result.isEmpty()) {
        print("нет циклов")
    } else {
        result.reversed().forEach {
            print(it.id)
            print("->")
        }
        print(result.last().id)

    }
}