package com.githubyss.mobile.experiment.app.datastructure.digraph.model

class Node constructor(var name: String, var weight: Int, var edgeList: ArrayList<Edge>) {
    fun addEdge(endNodeId: String) {
        val edge = Edge(name, endNodeId)
        edgeList.add(edge)
    }
}
