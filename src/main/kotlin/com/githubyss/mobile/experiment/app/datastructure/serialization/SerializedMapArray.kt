package com.githubyss.mobile.experiment.app.datastructure.serialization

/**
 * SerializedMapArray.kt
 * <Description> Data structure of Serialized MapArray.
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class SerializedMapArray {
    var text = ""
    var mapArray = emptyArray<Map<String, String>>()

    constructor(mapArray: Array<Map<String, String>>) {
        text = store(mapArray)
    }

    constructor(text: String) {
        mapArray = load(text)
    }

    /**
     * SerializedMapArray.store(mapArray)
     * <Description> Convert array(Array<Map<String,String>>) to text(String).
     * <Details>
     *
     * @param mapArray
     * @return
     * @author Ace Yan
     * @github githubyss
     */
    fun store(mapArray: Array<Map<String, String>>): String {
        if (mapArray.isEmpty()) return ""

        val text = StringBuilder()
        for ((idxArray, map) in mapArray.withIndex()) {
            if (map.isEmpty()) continue

            var idxMap = 0
            for (entry in map) {
                text.append(entry.key)
                text.append("=")
                text.append(entry.value)
                if (idxMap < map.size - 1) {
                    text.append(";")
                }
                idxMap++
            }

            if (idxArray < mapArray.size - 1) text.append("\n")
        }

        return text.toString()
    }

    /**
     * SerializedMapArray.load(text)
     * <Description> Convert text(String) to array(Array<Map<String,String>>).
     * <Details> The key and value of map must not contain '=', ';', '\n'.
     *
     * @param text
     * @return
     * @author Ace Yan
     * @github githubyss
     */
    fun load(text: String): Array<Map<String, String>> {
        if (text.isEmpty()) return emptyArray()

        val mapArrayList = ArrayList<Map<String, String>>()
        var reachKey = true
        var reachValue = false
        val key = StringBuilder()
        val value = StringBuilder()
        val map = HashMap<String, String>(10)
        for (char in text) {
            when (char) {
                '=' -> {
                    reachKey = false
                    reachValue = true
                }

                ';' -> {
                    reachKey = true
                    reachValue = false

                    map.put(key.toString(), value.toString())
                    key.setLength(0)
                    value.setLength(0)
                }

                '\n' -> {
                    reachKey = true
                    reachValue = false

                    map.put(key.toString(), value.toString())
                    key.setLength(0)
                    value.setLength(0)

                    mapArrayList.add(HashMap(map))
                    map.clear()
                }

                else -> {
                    if (reachKey) key.append(char)
                    if (reachValue) value.append(char)
                }
            }
        }

        map.put(key.toString(), value.toString())
        mapArrayList.add(map)

        return mapArrayList.toArray(Array<Map<String, String>>(mapArrayList.size) { emptyMap() })
    }

    fun syncStore(mapArray: Array<Map<String, String>>): String {
        synchronized(SerializedMapArray::class.java) {
            return store(mapArray)
        }
    }

    fun syncLoad(text: String): Array<Map<String, String>> {
        synchronized(SerializedMapArray::class.java) {
            return load(text)
        }
    }
}
