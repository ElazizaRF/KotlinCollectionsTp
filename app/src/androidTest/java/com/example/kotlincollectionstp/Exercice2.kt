package com.example.kotlincollectionstp



//Q1 Create the class step
data class Step(var name: String, var debutDate: String, var endDate: String, var distance: Double, var difficulty: Difficulties)

//Q2 Create the data class Result
data class Result(var time: String, var ranking: Int)

//Q3 Create the class Cyclist
class Cyclist(var firstName: String, var lastName:String, var nationality:String, var age:Int){
    var stepsHistory = hashMapOf<Step,Result>()
    fun newStep(step: Step, result: Result){
        stepsHistory[step] = result
    }
    override fun toString(): String{
        return "The Cyclist : $firstName $lastName \n" +
                "Nationality : $nationality \n" +
                "Age : $age \n" +
                "Steps History : \n"
    }
}
enum class Difficulties {
    EASY,
    HARD
}
