object Chapter01 extends App {

    // 1.
    // scala> 3.
    // !=             ##             %              &              *              +
    // -              /              <              <<             <=             <init>
    // ==             >              >=             >>             >>>            ^
    // asInstanceOf   equals         getClass       hashCode       isInstanceOf   toByte
    // toChar         toDouble       toFloat        toInt          toLong         toShort
    // toString       unary_+        unary_-        unary_~        |

    // 2.
    // scala> Math.sqrt(3)
    // res6: Double = 1.7320508075688772

    println(3 - Math.pow(Math.sqrt(3), 2))

    // 3.
    // vals

    // 4.
    println("crazy" * 3)
    // In Scaladoc it can be found in the documentation for StringOps

    // 5. 
    // return the higher of 10 and 2 (calls max on 10 with 2 as a parameter). max is defined in RichInt

    // 6.
    println(BigInt(2).pow(1024))

    // 7.
    import BigInt.probablePrime, util.Random
    println(probablePrime(100, Random))

    // 8.
    println(BigInt(100, Random).toString(36))

    // 9.
    println("hello"(0))
    println("hello".last)

    // 10.
    // take - Returns first n characters
    // drop - Returns all characters except first n ones
    // takeRight - Returns last n characters
    // dropRight - Returns all characters except last n ones

}