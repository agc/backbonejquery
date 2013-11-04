
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[Todo],Form[Todo],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String, todos: List[Todo], todoForm: Form[Todo]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.60*/("""

"""),_display_(Seq[Any](/*3.2*/main("Todos")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""

  <h1>Todos</h1>

  <div class="todos">

    <div class="todolist"></div>

    """),_display_(Seq[Any](/*11.6*/helper/*11.12*/.form(action = routes.TodoController.createTodo, 'class -> "todoform")/*11.82*/ {_display_(Seq[Any](format.raw/*11.84*/("""
      """),_display_(Seq[Any](/*12.8*/helper/*12.14*/.inputText(todoForm("content"), '_label -> "", 'placeholder -> "What do you need to do?"))),format.raw/*12.103*/("""
      <input type="submit" value="+">
    """)))})),format.raw/*14.6*/("""

  </div>

  <p class="credits">Written by <a href="http://github.com/jmparsons" target="_blank">JMParsons</a></p>

""")))})),format.raw/*20.2*/("""
"""))}
    }
    
    def render(message:String,todos:List[Todo],todoForm:Form[Todo]): play.api.templates.Html = apply(message,todos,todoForm)
    
    def f:((String,List[Todo],Form[Todo]) => play.api.templates.Html) = (message,todos,todoForm) => apply(message,todos,todoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 04 00:08:31 CET 2013
                    SOURCE: /Users/agc/Central/BackboneJQuery/repositorios/aprendizaje/play/play-scala-backbone-todo/app/views/index.scala.html
                    HASH: 91fc0e5dfa8420da43233bf2ec6f964a99bfa1b0
                    MATRIX: 527->1|662->59|699->62|720->75|759->77|876->159|891->165|970->235|1010->237|1053->245|1068->251|1180->340|1255->384|1404->502
                    LINES: 19->1|22->1|24->3|24->3|24->3|32->11|32->11|32->11|32->11|33->12|33->12|33->12|35->14|41->20
                    -- GENERATED --
                */
            