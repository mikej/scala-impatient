object Chapter03 extends App {

    import util.Random

    // 1.

    // creating the array and populating using for loop
    def randomArray(n: Int) = {
        val a = new Array[Int](n);
        for (i <- 0 until a.size) {
            a(i) = Random.nextInt(n)
        }
        a
    }
    println(randomArray(10).mkString(", "))

    // or

    // using yield and converting to list of args to be passed to Array
    def randomArrayWithYield(n: Int) = {
        Array((for (i <- 1 to 3) yield Random.nextInt(3)):_*)
    }
    println(randomArrayWithYield(5).mkString(", "))

    // 2.
    def swapInPlace(arr: Array[Int]) {
        val end = if (arr.length % 2 == 0) arr.length else arr.length - 1
        for (i <- 0 until end by 2) {
            val temp = arr(i + 1)
            arr(i + 1) = arr(i)
            arr(i) = temp
        }
    }
    val toBeSwapped = Array(1, 2, 3, 4, 5)
    val toBeSwapped2 = Array(1, 2, 3, 4, 5, 6)
    swapInPlace(toBeSwapped)
    swapInPlace(toBeSwapped2)
    println(toBeSwapped.mkString(", "))
    println(toBeSwapped2.mkString(", "))

    // 3.
    def swapped(arr: Array[Int]) = {
        (for (i <- 0 until arr.length)
            yield if (i % 2 == 0)
                if (i == arr.length - 1) arr(i)
                else arr(i + 1)
            else arr(i - 1)).toArray
    }
    println(swapped(toBeSwapped).mkString(", "))
    println(swapped(toBeSwapped2).mkString(", "))

    // 4.

    // using filter
    def positiveThenZeroOrNegative(arr: Array[Int]) = {
        arr.filter(_ > 0) ++ arr.filter(_ <= 0)
    }
    println(positiveThenZeroOrNegative(Array(1, -2, 4, 0, 2, -6)).mkString(", "))

    // or using for/if and yield
    def positiveThenZeroOrNegative2(arr: Array[Int]) = {
        (for (i <- arr if i > 0) yield i) ++ (for (i <- arr if i <= 0) yield i)
    }
    println(positiveThenZeroOrNegative2(Array(1, -2, 4, 0, 2, -6)).mkString(", "))

    // 5.
    val doubles = Array(1.0, 2.0, 3.0, 4.0, 5.0)
    println(doubles.sum / doubles.length)

    // 6.
    // TODO not sure if this question is asking about sorting in place
    // these approaches return a new Array/ArrayBuffer
    val toSortInReverse = Array(1, 2, 3, 4, 5)
    println(toSortInReverse.sortWith(_ > _).mkString(", "))

    import scala.collection.mutable.ArrayBuffer
    val bufferToSortInReverse = ArrayBuffer(1, 2, 3, 4, 5)
    println(bufferToSortInReverse.sortWith(_ > _).mkString(", "))

    // 7.
    val withDupes = Array(2, 1, 2, 3, 5, 2, 4, 4, 1)
    println(withDupes.distinct.mkString(", "))

    // 8. TODO

    // 9.
    println((for (id <- java.util.TimeZone.getAvailableIDs() if id.startsWith("America/")) yield id.stripPrefix("America/")).mkString(", "))

    // 10.
    import java.awt.datatransfer._ 
    import collection.JavaConversions.asScalaBuffer
    import collection.mutable.Buffer
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    val natives: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    println(natives) 
}