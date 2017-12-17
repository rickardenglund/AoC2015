package app

import days.day1.day1
import days.day2.day2
import days.day3.day3
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

interface MenuState: RState {
    var activeDay: Day
}

data class Day(val id: Int, val name: String, val el : (b: RBuilder) -> ReactElement)

class Menu : RComponent<RProps, MenuState>() {
    override fun componentWillMount() {
        setState{ activeDay = days.last()}
    }

    val days = listOf(
            Day(1, "Day 1", {b -> b.day1()}),
            Day(2, "Day 2", {b -> b.day2()}),
            Day(3, "Day 3", {b -> b.day3()})
    )

    override fun RBuilder.render() {
        div {
            days.map { day ->
                div("menu-item") { +day.name; attrs.onClickFunction = { setState{activeDay = day} }}
            }
            state.activeDay.el(this)
        }
    }

}

fun RBuilder.menu() = child(Menu::class) {}