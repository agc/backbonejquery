// @SOURCE:/Users/agc/Central/BackboneJQuery/repositorios/aprendizaje/play/play-scala-backbone-todo/conf/routes
// @HASH:2fb6ec1778d40b0ae1ce7530b8a9b5697b7a6b59
// @DATE:Mon Nov 04 00:08:28 CET 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseTodoController {
    

// @LINE:12
def createTodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "todos")
}
                                                

// @LINE:13
def deleteTodo(id:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "todos/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:10
def todoList(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "todos/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:11
def updateTodo(id:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "todos/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:9
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "todos")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseTodoController {
    

// @LINE:12
def createTodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TodoController.createTodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "todos"})
      }
   """
)
                        

// @LINE:13
def deleteTodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TodoController.deleteTodo",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "todos/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:10
def todoList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TodoController.todoList",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "todos/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def updateTodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TodoController.updateTodo",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "todos/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TodoController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "todos"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseTodoController {
    

// @LINE:12
def createTodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TodoController.createTodo(), HandlerDef(this, "controllers.TodoController", "createTodo", Seq(), "POST", """""", _prefix + """todos""")
)
                      

// @LINE:13
def deleteTodo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TodoController.deleteTodo(id), HandlerDef(this, "controllers.TodoController", "deleteTodo", Seq(classOf[Long]), "DELETE", """""", _prefix + """todos/$id<[^/]+>""")
)
                      

// @LINE:10
def todoList(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TodoController.todoList(id), HandlerDef(this, "controllers.TodoController", "todoList", Seq(classOf[Long]), "GET", """""", _prefix + """todos/$id<[^/]+>""")
)
                      

// @LINE:11
def updateTodo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TodoController.updateTodo(id), HandlerDef(this, "controllers.TodoController", "updateTodo", Seq(classOf[Long]), "PUT", """""", _prefix + """todos/$id<[^/]+>""")
)
                      

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TodoController.index(), HandlerDef(this, "controllers.TodoController", "index", Seq(), "GET", """ Todos""", _prefix + """todos""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      