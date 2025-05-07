@file:Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")

package pt.ulusofona.lp2.deisiJungle

enum class CommandType {
    GET,
    POST
}

fun main() {

}

fun router() : ((CommandType) -> (GameManager, List<String>) -> String?)? {
    return fun (tipo: CommandType): (GameManager, List<String>) -> String? {
        when (tipo) {
            CommandType.GET -> return fun(manager: GameManager, lista: List<String>): String? {
                if (lista[0] == "PLAYER_INFO") {
                    var dados = ""
                    if(manager.jogadores.any { it.nome == lista[1] }) {
                        when (manager.jogadores.filter { it.nome == lista[1] }[0].idEspecie) {
                            'Z' -> {
                                dados += manager.jogadores.filter { it.nome == lista[1] }
                                    .joinToString { "${it.id} | ${it.nome} | Tarzan | ${it.energia} | ${it.casaAtual}" }

                            }
                            'L' -> {
                                dados += manager.jogadores.filter { it.nome == lista[1] }
                                    .joinToString{ "${it.id} | ${it.nome} | Leao | ${it.energia} | ${it.casaAtual}"}

                            }
                            'P' -> {
                                dados += manager.jogadores.filter { it.nome == lista[1] }
                                    .joinToString { "${it.id} | ${it.nome} | Passaro | ${it.energia} | ${it.casaAtual}"}

                            }
                            'E' -> {
                                dados += manager.jogadores.filter { it.nome == lista[1] }
                                    .joinToString{ "${it.id} | ${it.nome} | Elefante | ${it.energia} | ${it.casaAtual}"}

                            }
                            'T' -> {
                                dados += manager.jogadores.filter { it.nome == lista[1] }
                                    .joinToString{"${it.id} | ${it.nome} | Tartaruga | ${it.energia} | ${it.casaAtual}"}
                            }
                        }
                    } else {
                        dados += "Inexistent player"
                    }
                    return dados
                } else if (lista[0] == "PLAYERS_BY_SPECIE") {
                    var listaNomes = ArrayList<String>(manager.jogadores.size)
                    var nomes = ""
                    if (lista[1] == "" || (lista[1] != "E" && lista[1] != "L" && lista[1] != "T" && lista[1] != "P" && lista[1] != "Z")) {
                        return ""
                    }
                      manager.jogadores.filter { it.idEspecie == lista[1][0] }.
                      sortedWith(compareByDescending { it.nome }).map { listaNomes.add(it.nome)}
                    nomes = listaNomes.joinToString(",")
                    if(nomes == ""){
                        return ""
                    }
                    return nomes

                } else if (lista[0] == "MOST_TRAVELED") {
                    var listaJogadores = ""
                    var soma = 0
                    listaJogadores += manager.jogadores.sortedWith(compareByDescending
                    { it.posicoesAndadas }).map { it }.
                    joinToString { "${it.nome}:${it.idEspecie}:${it.posicoesAndadas}\n" }.replace(", ","")
                    soma = manager.jogadores.sumOf { it.posicoesAndadas }
                    listaJogadores += "Total:$soma"
                    return listaJogadores

                } else if (lista[0] == "TOP_ENERGETIC_OMNIVORES") {
                    var listaJogadores3 = ""
                    listaJogadores3+= manager.jogadores.filter { it.idEspecie == 'T' || it.idEspecie == 'Z' ||
                            it.idEspecie == 'P'}.
                    sortedWith(compareByDescending { it.energia }).map { it }.joinToString("\n")
                    { "${it.nome}:${it.energia}" }.
                    replace(", ","")
                    if(manager.jogadores.count { it.idEspecie == 'T' || it.idEspecie == 'Z' ||
                                it.idEspecie == 'P' } > lista[1].toInt()){
                        var listaHelp = ""
                        listaHelp += manager.jogadores.filter { it.idEspecie == 'T' || it.idEspecie == 'Z' ||
                                it.idEspecie == 'P' }.
                        sortedWith(compareByDescending { it.energia }).
                        take(manager.jogadores.count { it.idEspecie == 'T' || it.idEspecie == 'Z' ||
                                it.idEspecie == 'P' } - lista[1].toInt()).map { it }.
                        joinToString("\n"){ "${it.nome}:${it.energia}" }.
                        replace(", ","")
                        return listaHelp
                    }
                    return listaJogadores3

                } else if (lista[0] == "CONSUMED_FOODS") {
                    var listaJogadores4 = ArrayList<String>(5)
                    if(manager.jogadores.any { it.bananaIngerida > 0 }){
                        listaJogadores4.add("Bananas")
                    }
                    if(manager.jogadores.any { it.cogumeloIngerido > 0 }){
                        listaJogadores4.add("Cogumelo Magico")
                    }
                    if(manager.jogadores.any { it.carneIngerida > 0 }){
                        listaJogadores4.add("Carne")
                    }
                    if(manager.jogadores.any { it.ervaIngerida > 0 }){
                        listaJogadores4.add("Erva")
                    }
                    if(manager.jogadores.any { it.aguaIngerida > 0 }){
                        listaJogadores4.add("Agua")
                    }
                    return listaJogadores4.sorted().joinToString("\n")
                } else {
                    return null
                }
            }
            CommandType.POST -> return fun(manager: GameManager, lista: List<String>): String? {
                return if(lista[0] == "MOVE"){
                    when (manager.moveCurrentPlayer(lista[1].toInt(), true).code) {
                        MovementResultCode.VALID_MOVEMENT ->"OK"
                        MovementResultCode.INVALID_MOVEMENT -> "Movimento invalido"
                        MovementResultCode.CAUGHT_FOOD -> "Apanhou comida"
                        MovementResultCode.NO_ENERGY -> "Sem energia"
                    }
                }else{
                    null
                }
            }
        }
    }
}



