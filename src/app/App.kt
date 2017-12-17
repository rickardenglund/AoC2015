package app

import react.*
import react.dom.*
import logo.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        menu()
    }
}

fun RBuilder.app() = child(App::class) {}
