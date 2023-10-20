package com.example.kotlincollectionstp


//Parte 1
//Q1 //Parte 1
data class Player(var name: String, var number: Int, var team: Teams , var points: Int)
//We mentioned the class as a data class because it has no methods just there attributes

//The main program
fun main() {
    //Q2 //Parte 1
    val players = mutableListOf<Player>(
        Player("Ahmed", 1, Teams.OCS, 0),
        Player("Oussama", 2, Teams.OCK, 0),
        Player("Rachid", 3, Teams.RCA, 0))
    //Q3 //Parte 1
    players.add(Player("Kamal", 4, Teams.OCS, 0))

    //a //Q5 //Parte 3
    val teams = mutableListOf<Team>(
        Team(Countries.MOROCCO,Teams.OCS),
        Team(Countries.EGYPT,Teams.OCK),
        Team(Countries.TUNISIA,Teams.RCA),
        Team(Countries.MORITANIE,Teams.WAC)
    )

    //b //Q5 //Parte 3
    teams[1].AddPlayer(players[0])
    teams[2].AddPlayer(players[1])
    teams[1].RemovePlayer(players[0])
    teams[2].setPoints(players[1],5)
}

//Parte 2
enum class Teams(var color:String){
    OCS("Blue"),
    OCK("Yellow"),
    RCA("Green"),
    WAC("Red"),
}

//Parte 3
//Q1
enum class Countries(){
    MOROCCO,
    EGYPT,
    ALGERIA,
    TUNISIA,
    MORITANIE
}
//Q3
class Team(var country:Countries ,var team:Teams){
    val playersList = mutableListOf<Player>()

    fun SearchPlayer(p:Player): Int {
        for (i in 0 until playersList.size){
            if (playersList[i].name == p.name){
                return i
            }
        }
        return -1
    //(returner l’indice du joueur dans la liste si le joueur existe et -1 sinon)
    }
    fun AddPlayer(p:Player) :Boolean{
        ////val PlayerExiste = playersList.any { it.name == p.name }
        if (SearchPlayer(p)==-1){
            playersList.add(p)
            return true
        }
        return false
    //(retourne vraie si l’ajout et ok et faux si le joueur existe déjà dans la liste)
    }

    fun RemovePlayer(p:Player):Boolean{
        if (SearchPlayer(p)!=-1) {
            playersList.remove(p)
            return true
        }
        return false
    //(retourne vraie sile joueur est supprimé et faux s’il n’existe pas dans la liste)
    }

    //Q4
    fun setPoints(p:Player,points:Int){
        val indx = SearchPlayer(p)
        if (indx != -1) {
            playersList[indx].points = points
        }
    }
}