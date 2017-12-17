package days

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.p

interface DayState : RState{
    var name : String
    var p1Res : String
    var p2Res : String
}

open class Day: RComponent<RProps, DayState>() {
    override fun DayState.init() {
        name = "Unnamed"
        p1Res = "Unsolved"
        p2Res = "Unsolved"
    }

    override fun RBuilder.render() {
        h1{+state.name }
        p{+"P1: ${state.p1Res}"}
        p{+"P2: ${state.p2Res}"}
    }
}

fun RBuilder.day() = child(Day::class) {}