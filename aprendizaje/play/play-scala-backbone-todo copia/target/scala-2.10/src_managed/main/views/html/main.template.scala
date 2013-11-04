
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>"""),_display_(Seq[Any](/*5.17*/title)),format.raw/*5.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("stylesheets/main.css"))),format.raw/*6.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*7.59*/routes/*7.65*/.Assets.at("images/favicon.png"))),format.raw/*7.97*/("""">
        <meta name="viewport" content="width=480">
    </head>
    <body>
        """),_display_(Seq[Any](/*11.10*/content)),format.raw/*11.17*/("""
        """),_display_(Seq[Any](/*12.10*/helper/*12.16*/.requireJs(core = routes.Assets.at("javascripts/require.js").url, module = routes.Assets.at("javascripts/main").url))),format.raw/*12.132*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 04 00:08:32 CET 2013
                    SOURCE: /Users/agc/Central/BackboneJQuery/repositorios/aprendizaje/play/play-scala-backbone-todo/app/views/main.scala.html
                    HASH: 7f0e796a5a10c0e294e56f653cf849cbbc87402c
                    MATRIX: 509->1|616->31|702->82|728->87|825->149|839->155|894->189|990->250|1004->256|1057->288|1179->374|1208->381|1254->391|1269->397|1408->513
                    LINES: 19->1|22->1|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|32->11|32->11|33->12|33->12|33->12
                    -- GENERATED --
                */
            