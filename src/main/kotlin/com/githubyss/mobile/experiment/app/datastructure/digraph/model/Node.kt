package com.githubyss.mobile.experiment.app.datastructure.digraph.model

/**
 * Node
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class Node constructor(var name: String, var weight: Int, var edgeList: ArrayList<Edge>) {
    fun addEdge(endNodeId: String) {
        val edge = Edge(name, endNodeId)
        edgeList.add(edge)
    }
}
