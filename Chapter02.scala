object Chapter02 extends App {

    // 1
    def signum(x: Int) = if (x > 0) 1 else if (x < 0) -1 else 0
    println(signum(5))
    println(signum(0))
    println(signum(-5))

    // 2/
    // Unit

    // 3.
    // 3. scala> var x: Unit = None
    // x: Unit = ()

    // scala> var y: Int = 0
    // y: Int = 0

    // scala> x = y = 1
    // x: Unit = ()

    // 4.
    for (i <- 10 to 0 by -1) println(i) 

    // 5.
    def countdown(n: Int) = for (i <- n to 0 by -1) println(i)
    countdown(10)

    // 6.
    var total: Long = 1; for (c <- "Hello") total *= c.toInt; total
    println(total)

    // 7.
    val total2 = "Hello".foldLeft(1L)((totalSoFar, ch) => totalSoFar * ch)
    println(total2)

    // 8.
    def product(s: String) = { s.foldLeft(1L)((totalSoFar, ch) => totalSoFar * ch) }
    println(product("Hello"))

    // 9.
    def productRec(s: String): Long = {
        if (s.length > 0) s.head * productRec(s.tail) else 1
    }
    println(productRec("Hello"))

    // 10.
    def pow(x: Double, n: Int): Double = {
        if (n % 2 == 0 && n > 0) pow(x, n/2) * pow(x, n/2)
        else if (n > 0) x * pow(x, n - 1)
        else if (n == 0) 1
        else 1 / pow(x, -n)
    }
    println(pow(2, 2))
    println(pow(3, 4))

}