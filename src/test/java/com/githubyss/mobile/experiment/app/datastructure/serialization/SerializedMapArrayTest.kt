package com.githubyss.mobile.experiment.app.datastructure.serialization

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SerializedMapArrayTest {
    private var emptyArray = emptyArray<Map<String, String>>()
    private var emptyArrayText = ""

    private var oneArrayEmptyMap = Array<Map<String, String>>(1) { emptyMap() }
    private var oneArrayEmptyMapText = ""
    private var oneArrayOneMap = Array<Map<String, String>>(1) { emptyMap() }
    private var oneArrayOneMapText = ""
    private var oneArrayTwoMap = Array<Map<String, String>>(1) { emptyMap() }
    private var oneArrayTwoMapText = ""

    private var twoArrayEmptyMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArrayEmptyMapText = ""
    private var twoArrayOneMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArrayOneMapText = ""
    private var twoArrayTwoMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArrayTwoMapText = ""

    private var twoArrayOneTwoMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArrayOneTwoMapText = ""
    private var twoArrayTwoOneMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArrayTwoOneMapText = ""

    private var threeArrayFiveOneSixMap = Array<Map<String, String>>(3) { emptyMap() }
    private var threeArrayFiveOneSixMapText = ""

    private var oneArraySpSingleMap = Array<Map<String, String>>(1) { emptyMap() }
    private var oneArraySpSingleMapText = ""

    private var twoArraySpSingleMap = Array<Map<String, String>>(2) { emptyMap() }
    private var twoArraySpSingleMapText = ""

    private var threeArraySpSingleMap = Array<Map<String, String>>(3) { emptyMap() }
    private var threeArraySpSingleMapText = ""

    @Before
    fun setUp() {
        val map0 = emptyMap<String, String>()

        val map1 = LinkedHashMap<String, String>(1)
        map1.put("A", "XXX")

        val map2 = LinkedHashMap<String, String>(2)
        map2.put("kt0", "vt0")
        map2.put("kt1", "vt1")

        val map5 = LinkedHashMap<String, String>(5)
        map5.put("kf0", "vf0")
        map5.put("kf1", "vf1")
        map5.put("kf2", "vf2")
        map5.put("kf3", "vf3")
        map5.put("kf4", "vf4")

        val map6 = LinkedHashMap<String, String>(6)
        map6.put("ks0", "vs0")
        map6.put("ks1", "vs1")
        map6.put("ks2", "vs2")
        map6.put("ks3", "vs3")
        map6.put("ks4", "vs4")
        map6.put("ks5", "vs5")

        val mapSpSingle1 = LinkedHashMap<String, String>(3)
        mapSpSingle1.put("=", "=")
        mapSpSingle1.put(";", ";")
        mapSpSingle1.put("\n", "\n")

        val mapSpSingle2 = LinkedHashMap<String, String>(3)
        mapSpSingle2.put("=", ";")
        mapSpSingle2.put(";", "\n")
        mapSpSingle2.put("\n", "=")

        val mapSpSingle3 = LinkedHashMap<String, String>(3)
        mapSpSingle3.put("=", "\n")
        mapSpSingle3.put(";", "=")
        mapSpSingle3.put("\n", ";")

        emptyArray = emptyArray()
        emptyArrayText = ""

        oneArrayEmptyMap[0] = map0
        oneArrayEmptyMapText = ""

        oneArrayOneMap[0] = map1
        oneArrayOneMapText = "A=XXX"

        oneArrayTwoMap[0] = map2
        oneArrayTwoMapText = "kt0=vt0;kt1=vt1"

        twoArrayEmptyMap[0] = map0
        twoArrayEmptyMap[1] = map0
        twoArrayEmptyMapText = ""

        twoArrayOneMap[0] = map1
        twoArrayOneMap[1] = map1
        twoArrayOneMapText = "A=XXX\nA=XXX"

        twoArrayTwoMap[0] = map2
        twoArrayTwoMap[1] = map2
        twoArrayTwoMapText = "kt0=vt0;kt1=vt1\nkt0=vt0;kt1=vt1"

        twoArrayOneTwoMap[0] = map1
        twoArrayOneTwoMap[1] = map2
        twoArrayOneTwoMapText = "A=XXX\nkt0=vt0;kt1=vt1"

        twoArrayTwoOneMap[0] = map2
        twoArrayTwoOneMap[1] = map1
        twoArrayTwoOneMapText = "kt0=vt0;kt1=vt1\nA=XXX"

        threeArrayFiveOneSixMap[0] = map5
        threeArrayFiveOneSixMap[1] = map1
        threeArrayFiveOneSixMap[2] = map6
        threeArrayFiveOneSixMapText = "kf0=vf0;kf1=vf1;kf2=vf2;kf3=vf3;kf4=vf4\nA=XXX\nks0=vs0;ks1=vs1;ks2=vs2;ks3=vs3;ks4=vs4;ks5=vs5"

        oneArraySpSingleMap[0] = mapSpSingle1
        oneArraySpSingleMapText = "===;;=;;\n=\n"

        twoArraySpSingleMap[0] = mapSpSingle1
        twoArraySpSingleMap[1] = mapSpSingle2
        twoArraySpSingleMapText = "===;;=;;\n=\n\n==;;;=\n;\n=="

        threeArraySpSingleMap[0] = mapSpSingle1
        threeArraySpSingleMap[1] = mapSpSingle2
        threeArraySpSingleMap[2] = mapSpSingle3
        threeArraySpSingleMapText = "===;;=;;\n=\n\n==;;;=\n;\n==\n==\n;;==;\n=;"

//        "= = ==; ;   ; = ;"
//        "{=, ==;}"
//        "== = =; ;   ; = ;"
    }

    @After
    fun tearDown() {
    }

    @Test
    fun store() {
        Assert.assertEquals(emptyArrayText, SerializedMapArray(emptyArray).text)

        Assert.assertEquals(oneArrayEmptyMapText, SerializedMapArray(oneArrayEmptyMap).text)
        Assert.assertEquals(oneArrayOneMapText, SerializedMapArray(oneArrayOneMap).text)
        Assert.assertEquals(oneArrayTwoMapText, SerializedMapArray(oneArrayTwoMap).text)

        Assert.assertEquals(twoArrayEmptyMapText, SerializedMapArray(twoArrayEmptyMap).text)
        Assert.assertEquals(twoArrayOneMapText, SerializedMapArray(twoArrayOneMap).text)
        Assert.assertEquals(twoArrayTwoMapText, SerializedMapArray(twoArrayTwoMap).text)

        Assert.assertEquals(twoArrayOneTwoMapText, SerializedMapArray(twoArrayOneTwoMap).text)
        Assert.assertEquals(twoArrayTwoOneMapText, SerializedMapArray(twoArrayTwoOneMap).text)

        Assert.assertEquals(threeArrayFiveOneSixMapText, SerializedMapArray(threeArrayFiveOneSixMap).text)

        Assert.assertEquals(oneArraySpSingleMapText, SerializedMapArray(oneArraySpSingleMap).text)
        Assert.assertEquals(twoArraySpSingleMapText, SerializedMapArray(twoArraySpSingleMap).text)
        Assert.assertEquals(threeArraySpSingleMapText, SerializedMapArray(threeArraySpSingleMap).text)
    }

    @Test
    fun load() {
        Assert.assertArrayEquals(emptyArray, SerializedMapArray(emptyArrayText).mapArray)

        Assert.assertArrayEquals(emptyArray, SerializedMapArray(oneArrayEmptyMapText).mapArray)
        Assert.assertArrayEquals(oneArrayOneMap, SerializedMapArray(oneArrayOneMapText).mapArray)
        Assert.assertArrayEquals(oneArrayTwoMap, SerializedMapArray(oneArrayTwoMapText).mapArray)

        Assert.assertArrayEquals(emptyArray, SerializedMapArray(twoArrayEmptyMapText).mapArray)
        Assert.assertArrayEquals(twoArrayOneMap, SerializedMapArray(twoArrayOneMapText).mapArray)
        Assert.assertArrayEquals(twoArrayTwoMap, SerializedMapArray(twoArrayTwoMapText).mapArray)

        Assert.assertArrayEquals(twoArrayOneTwoMap, SerializedMapArray(twoArrayOneTwoMapText).mapArray)
        Assert.assertArrayEquals(twoArrayTwoOneMap, SerializedMapArray(twoArrayTwoOneMapText).mapArray)

        Assert.assertArrayEquals(threeArrayFiveOneSixMap, SerializedMapArray(threeArrayFiveOneSixMapText).mapArray)

//        Assert.assertArrayEquals(oneArraySpSingleMap, SerializedMapArray(oneArraySpSingleMapText).mapArray)
//        Assert.assertArrayEquals(twoArraySpSingleMap, SerializedMapArray(twoArraySpSingleMapText).mapArray)
//        Assert.assertArrayEquals(threeArraySpSingleMap, SerializedMapArray(threeArraySpSingleMapText).mapArray)
    }
}
