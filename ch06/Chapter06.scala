object Chapter06 extends App {
    object Conversions  {
        def inchesToCentimeters(inches: Double) = {
            inches / 2.54
        }

        def gallonsToLiters(gallons: Double) = {
            gallons * 4.54609
        }

        def milesToKilometers(miles: Double) = {
            miles * 1.609344
        }
    }

    println(Conversions.inchesToCentimeters(12.0))
    println(Conversions.gallonsToLiters(5.0))
    println(Conversions.milesToKilometers(9.0))

    abstract class UnitConversion {
        def convert(in: Double): Double
    }

    object InchesToCentimeters extends UnitConversion {
        def convert(inches: Double) = {
            inches / 2.54
        }
    }

    object GallonsToLiters extends UnitConversion {
        def convert(gallons: Double) = {
            gallons * 4.54609
        }
    }

    object MilesToKilometers extends UnitConversion {
        def convert(miles: Double) = {
            miles * 1.609344
        }
    }

    println(InchesToCentimeters.convert(12.0))
    println(GallonsToLiters.convert(5.0))
    println(MilesToKilometers.convert(9.0))

    // bad idea because java.awt.Point is mutable but you wouldn't want to allow moving the origin?
    object Origin extends java.awt.Point {
    }

    class Point(x: Int = 0, y: Int = 0) {
        override def toString(): String = {
            "(" + x + ", " + y + ")"
        }
    }

    object Point {
        def apply(x: Int = 0, y: Int = 0) = {
            new Point(x, y)
        }
    }

    println(Point(3, 4))

}