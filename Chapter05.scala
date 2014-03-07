object Chapter05 extends App {

    // 1
    class Counter(private var value: Int = 0) {
        def increment() { if (value < Int.MaxValue) value += 1 }
        def current = value
    }

    val c = new Counter(Int.MaxValue - 1)

    println(c.current)
    c.increment()
    println(c.current)
    c.increment()
    println(c.current)

    // 2
    class BankAccount {
        private var _balance = 0
        def balance = _balance

        def deposit(amount: Int) {
            _balance = balance + amount
        }

        def withdraw(amount: Int) {
            _balance = balance - amount // allows negative balance
        }
    }

    val account = new BankAccount()
    account.deposit(100)
    println(account.balance)
    account.withdraw(75)
    println(account.balance)
    account.withdraw(50)
    println(account.balance)

    // 3
    class Time(val hrs: Int, val min: Int) {
        def before(other: Time) = {
            hrs < other.hrs || hrs == other.hrs && min < other.min
        }
    }

    val t1 = new Time(12, 0)
    val t2 = new Time(12, 15)
    val t3 = new Time(15, 0)

    println(t1.before(t2))
    println(t2.before(t1))
    println(t2.before(t3))
    println(t3.before(t2))

    // 4
    // has same public interface as Time class above
    class Time2(_hrs: Int, _min: Int) {
        private val minsSinceMidnight = (_hrs * 60) + _min
        def hrs = minsSinceMidnight / 60
        def min = minsSinceMidnight % 60
        def before(other: Time2) = {
            minsSinceMidnight < other.minsSinceMidnight
        }
    }

    val t4 = new Time2(12, 0)
    val t5 = new Time2(12, 15)
    val t6 = new Time2(15, 0)

    println(t4.before(t5))
    println(t5.before(t4))
    println(t5.before(t6))
    println(t6.before(t5))

    // 5
    import scala.reflect.BeanProperty
    class Student {
        
        @BeanProperty var name: String = _
        @BeanProperty var id: Long = 0

    }

    // 6
    class Person(name: String, var age: Int) {
        if (age < 0) age = 0
        def description = name + " is " + age + " years old"
    }

    val person = new Person("Bob", -5)
    println(person.description)

    // 7
    class Person2(fullname: String) {
        private val names = fullname.split(" ")
        val firstName = names(0)
        val lastName = names(1)
    }

    val smith = new Person2("Jim Smith")
    println("first = " + smith.firstName + ", last = " + smith.lastName)

    // 8
    class Car(val manufacturer: String, val model: String, val year: Int = -1, var license: String = "") {
        def this(manufacturer: String, model: String, _license: String) { this(manufacturer, model, license = _license) }
    }

    val car1 = new Car("Audi", "A4", 2010, "X1 ABC")
    val car2 = new Car("BMW", "M5")
    val car3 = new Car("Lotus", "Elise", 2000)
    val car4 = new Car("Ford", "Focus", "PL2 MRY")

}