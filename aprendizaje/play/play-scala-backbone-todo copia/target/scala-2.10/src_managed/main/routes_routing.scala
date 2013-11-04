// @SOURCE:/Users/agc/Central/BackboneJQuery/repositorios/aprendizaje/play/play-scala-backbone-todo/conf/routes
// @HASH:2fb6ec1778d40b0ae1ce7530b8a9b5697b7a6b59
// @DATE:Mon Nov 04 00:08:28 CET 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_TodoController_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("todos"))))
        

// @LINE:10
private[this] lazy val controllers_TodoController_todoList2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("todos/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_TodoController_updateTodo3 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("todos/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_TodoController_createTodo4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("todos"))))
        

// @LINE:13
private[this] lazy val controllers_TodoController_deleteTodo5 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("todos/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_Assets_at6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """todos""","""controllers.TodoController.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """todos/$id<[^/]+>""","""controllers.TodoController.todoList(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """todos/$id<[^/]+>""","""controllers.TodoController.updateTodo(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """todos""","""controllers.TodoController.createTodo"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """todos/$id<[^/]+>""","""controllers.TodoController.deleteTodo(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_TodoController_index1(params) => {
   call { 
        invokeHandler(controllers.TodoController.index, HandlerDef(this, "controllers.TodoController", "index", Nil,"GET", """ Todos""", Routes.prefix + """todos"""))
   }
}
        

// @LINE:10
case controllers_TodoController_todoList2(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.TodoController.todoList(id), HandlerDef(this, "controllers.TodoController", "todoList", Seq(classOf[Long]),"GET", """""", Routes.prefix + """todos/$id<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_TodoController_updateTodo3(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.TodoController.updateTodo(id), HandlerDef(this, "controllers.TodoController", "updateTodo", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """todos/$id<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_TodoController_createTodo4(params) => {
   call { 
        invokeHandler(controllers.TodoController.createTodo, HandlerDef(this, "controllers.TodoController", "createTodo", Nil,"POST", """""", Routes.prefix + """todos"""))
   }
}
        

// @LINE:13
case controllers_TodoController_deleteTodo5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.TodoController.deleteTodo(id), HandlerDef(this, "controllers.TodoController", "deleteTodo", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """todos/$id<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_Assets_at6(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        