package academy.learnprogramming.oochallenge

fun main(args: Array<String>) {
    val kb = KotlinBicycle(1,1,1)
    val mb = KotlinMountainBike(1,1,1,1)
    val rb = KotlinRoadBike(1,1,1,1)
    kb.printDescription()
    mb.printDescription()
    rb.printDescription()
    val kb2 = KotlinBicycle(1,1)
    val mb2 = KotlinMountainBike(1,1,1)
    val rb2 = KotlinRoadBike(1,1,1)
    kb.printDescription()
    mb.printDescription()
    rb.printDescription()

    val mb3 = KotlinMountainBike("Blue", 1,1,1)
    mb.printDescription()
    KotlinMountainBike.availableColors.forEach{println(it)}
}


open class KotlinBicycle(var cadence: Int,var speed: Int,var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription(){
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }


}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int):KotlinBicycle(cadence, speed, gear) {

    constructor(color:String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 20):
            this(seatHeight, cadence, speed, gear){
        println("This is the color $color")
    }

    companion object {
        val availableColors = listOf("blue", "Black", "brown", "red", "white", "green")
    }

    override fun printDescription() {
        super.printDescription()
        println("The Mountain Bike has a seatHeight of $seatHeight")
    }

}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int):KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The Road Bike has a tireWidth of $tireWidth")
    }
}