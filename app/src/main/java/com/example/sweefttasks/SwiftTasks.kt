package com.example.sweefttasks


fun main() {
//    println(singleNumber)
//    calculateMinimumCoins(24)
//    findMinimumMissingNumber(listofNumber)
//    println(addBinary("1010", "1011"))
//    println(countWaysToReachNthStair(3))
//    removeItem()
}


//1. გვაქვს მთელი რიცხვების ჩამონათვალი სადაც  ერთის გარდა ყველა რიცხვი მეორდება, იპოვეთ
//ის რიცხვი რომელიც არ მეორდება.int singleNumber(int[] nums)
val numbers = listOf(2, 2, 3, 4, 4, 5, 5)
val singleNumber = findNumber(numbers)

fun findNumber(numbers: List<Int>): Int {
    var x = 0
    for (i in numbers) {
        x = x xor i
    }
    return x

}

//2. გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა თანხა
//(თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია ეს თანხა
//დავახურდაოთ.
//Int minSplit(Int amount);

fun calculateMinimumCoins(coin: Int) {
    var currentCoins = coin
    var numCoins = 0

    numCoins += currentCoins / 50
    currentCoins %= 50

    numCoins += currentCoins / 20
    currentCoins %= 20

    numCoins += currentCoins / 10
    currentCoins %= 10

    numCoins += currentCoins / 5
    currentCoins %= 5

    numCoins += currentCoins

    println(numCoins)
}

//3. მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც
//გადაეცემა ეს მასივი და აბრუნებს მინიმალურ მთელ რიცხვს, რომელიც 0-ზე მეტია და ამ მასივში
//არ შედის.
//Int notContains(Int[] array);

val listofNumber = mutableListOf<Int>(2, 4, 5, 6, 7, 8)
fun findMinimumMissingNumber(list: List<Int>) {
    val set = list.toSet()
    var i = 1
    while (set.contains(i)) {
        i++
    }
    println(i)
}

//4.მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.
//მაგ: a = 1010; b = 1011; , მათი ჯამი იქნება 10101.

fun addBinary(a: String, b: String): String {


    var carry = 0
    var i = a.length - 1
    var j = b.length - 1
    val result = StringBuilder()

    while (i >= 0 || j >= 0 || carry > 0) {
        val sum = carry + (if (i >= 0) a[i--] - '0' else 0) + (if (j >= 0) b[j--] - '0' else 0)
        carry = sum / 2
        result.append(sum % 2)
    }
    return result.reverse().toString()
}


//5. გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით. დაწერეთ
//ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.
//Int countVariants(Int stearsCount);

fun countWaysToReachNthStair(n: Int): Int {
    if (n <= 1) {
        return 1
    }
    var step1 = 1
    var step2 = 1
    var ways = 0
    for (i in 2..n) {
        ways = step1 + step2
        step2 = step1
        step1 = ways
    }
    return ways
}

//6. დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში
//წავშალოთ ელემენტი.
fun removeItem() {
    val myMap = LinkedHashMap<String, Int>()
    myMap["one"] = 1
    myMap["two"] = 2
    myMap["three"] = 3
    myMap["four"] = 4

    myMap.remove("three")

    for (i in myMap) {
        println("${i.key}, ${i.value}")
    }
}




