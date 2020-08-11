package com.hfad.myshipsapplication.shipslootprogramminginkotlin

class LootShipsinKotlin {
    companion object {
        var days = 0
        lateinit var newArray: IntArray

        public fun checkforLootedArrays(array: IntArray): IntArray {
            newArray = array
            var traverse = false
            for (i in array.indices) {
                if (i + 1 < newArray.size && newArray[i] < newArray[i + 1]) {
                    traverse = true
                    newArray = removeTheElement(i + 1, newArray)
                }
            }
            if (traverse){
                days++
            }
            return newArray
        }

        private fun removeTheElement(index: Int, array: IntArray): IntArray {
            if (array == null || index < 0 || index >= array.size) {
                return array
            }
            var k=0
            var anotherArray= IntArray(array.size - 1)
           for (i in array.indices){
               if (i==index){
                   continue
               }
anotherArray[k++]=array[i]
           }

            return anotherArray
        }
    }

    fun main(args: Array<String>) {
        var array = intArrayOf(3, 6, 2, 7, 5, 9, 4, 8)
        var k: Int = array.size

        while (k>1){
            array= LootShipsinKotlin.checkforLootedArrays(array)
            k--
        }
        println("After $days Days Looting will Stop")
    }
}