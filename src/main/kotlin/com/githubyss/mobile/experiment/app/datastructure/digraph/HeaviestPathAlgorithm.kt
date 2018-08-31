package com.githubyss.mobile.experiment.app.datastructure.digraph

import android.util.Log
import com.githubyss.mobile.experiment.app.datastructure.digraph.model.Node

/**
 * HeaviestPathAlgorithm
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class HeaviestPathAlgorithm {
    private val TAG = javaClass.simpleName

    private val nodeMap = HashMap<String, Node>()

    fun addNode(node: Node) {
        nodeMap.put(node.name, node)
    }

    fun addEdge(startNodeName: String, endNodeName: String) {
        if (nodeMap.isNotEmpty()) nodeMap[startNodeName]?.addEdge(endNodeName)
    }

    fun getHeaviestPath(fromNodeName: String, toNodeName: String): Int {
        val fromNode = nodeMap[fromNodeName]
        val edgeList = fromNode?.edgeList ?: return -1
        var path = 0
        for (edge in edgeList) {
            var tempPath = fromNode.weight
            val endNodeName = edge.endNodeName
            if (endNodeName != toNodeName) {
                val heaviestPath = getHeaviestPath(endNodeName, toNodeName)
                if (heaviestPath == -1) continue
                tempPath += heaviestPath
            } else {
                tempPath += nodeMap[endNodeName]?.weight ?: 0
            }

            if (path < tempPath) path = tempPath
        }

        return path
    }

    fun getHeaviestPath(fromNodeName: String, toNodeName: String, pathList: LinkedHashSet<String>): Int {
        if (fromNodeName == toNodeName) {
            Log.d(TAG, "Start node is end node")
            return nodeMap[fromNodeName]?.weight ?: -1
        }

        if (!pathList.add(fromNodeName)) {
            Log.d(TAG, "Exist closed loop!")
            return -1
        }

        val fromNode = nodeMap[fromNodeName]
        val edgeList = fromNode?.edgeList ?: return -1
        var path = 0
        val temp = LinkedHashSet<String>()
        temp.addAll(pathList)
        for (edge in edgeList) {
            val temp2 = LinkedHashSet<String>()
            temp2.addAll(temp)
            var tempPath = fromNode.weight
            val endNodeName = edge.endNodeName
            if (endNodeName != toNodeName) {
                val heaviestPath = getHeaviestPath(endNodeName, toNodeName, temp2)
                if (heaviestPath == -1) continue
                tempPath += heaviestPath
            } else {
                tempPath += nodeMap[endNodeName]?.weight ?: 0
                temp2.add(toNodeName)
            }

            if (path < tempPath) {
                path = tempPath
                pathList.clear()
                pathList.addAll(temp2)
            }
        }

        return path
    }
}
