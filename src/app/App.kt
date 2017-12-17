package app

import react.*
import react.dom.*
import logo.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
        }
        menu()
    }
}

fun RBuilder.app() = child(App::class) {}
