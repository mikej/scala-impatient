object Chapter04 extends App {

    // 1
    val gizmos = Map("Laptop" -> 1500, "Camera" -> 1000, "Headphones" -> 250)
    val discounted = (for ((k, v) <- gizmos) yield (k, v * 0.9))
    println(discounted.mkString(", "))

    // 2
    def countWords(filename: String): scala.collection.mutable.Map[String, Int] = {
        val in = new java.util.Scanner(new java.io.File(filename))
        val countMap = scala.collection.mutable.Map[String, Int]().withDefault(_ => 0) 
        while (in.hasNext()) {
            countMap(in.next()) += 1
        }
        return countMap
    }
    println(countWords("words.txt").mkString(", "))

    // 3
    def countWordsUsingImmutableMap(filename: String): scala.collection.immutable.Map[String, Int] = {
        val in = new java.util.Scanner(new java.io.File(filename))
        var countMap = new scala.collection.immutable.HashMap[String, Int]()
        while (in.hasNext()) {
            val word = in.next()
            countMap = countMap + (word -> (countMap.getOrElse(word, 0) + 1))
        }
        return countMap
    }
    println(countWordsUsingImmutableMap("words.txt").mkString(", "))

    // 4
    def countWordsUsingSortedMap(filename: String): scala.collection.immutable.Map[String, Int] = {
        val in = new java.util.Scanner(new java.io.File(filename))
        var countMap = scala.collection.immutable.SortedMap[String, Int]()
        while (in.hasNext()) {
            val word = in.next()
            countMap = countMap + (word -> (countMap.getOrElse(word, 0) + 1))
        }
        return countMap
    }
    println(countWordsUsingSortedMap("words.txt").mkString(", "))

    // 5
    import scala.collection.JavaConversions.mapAsScalaMap
    def countWordsUsingTreeMap(filename: String): scala.collection.mutable.Map[String, Int] = {
        val in = new java.util.Scanner(new java.io.File(filename))
        val countMap: scala.collection.mutable.Map[String, Int] = 
            new java.util.TreeMap[String, Int]
        while (in.hasNext()) {
            val word = in.next()
            if (countMap.contains(word))
                countMap(word) += 1
            else
                countMap(word) = 1
        }
        return countMap
    }
    println(countWordsUsingTreeMap("words.txt").mkString(", "))

    // 6
    import java.util.Calendar._
    val dayMap = collection.mutable.LinkedHashMap(
        "Monday" -> MONDAY,
        "Tuesday" -> TUESDAY,
        "Wednesday" -> WEDNESDAY,
        "Thursday" -> THURSDAY,
        "Friday" -> FRIDAY,
        "Saturday" -> SATURDAY,
        "Sunday" -> SUNDAY)
    println(dayMap)

    // 7
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val sysProps = propertiesAsScalaMap(System.getProperties)
    val maxLength = sysProps.keySet.maxBy(_.length).length
    println(maxLength)
    for( (k, v) <- sysProps ) printf("%-" + maxLength + "s | %s\n", k, v)

    // 8
    def minmax(values: Array[Int]) = {
        (values.min, values.max)
    }
    println(minmax(Array(1, 2, 3, 4, 5, 6)))

    // 9
    def lteqgt(values: Array[Int], v: Int) = {
        (values.count(_ < v), values.count(_ == v), values.count(_ > v))
    }
    println(lteqgt(Array(1, 2, 3, 4, 5, 6, 7), 4))

    println("Hello".zip("World"))

}