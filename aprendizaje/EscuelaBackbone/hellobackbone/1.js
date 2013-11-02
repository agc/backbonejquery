

// Self-executing wrapper
(function($){
  
  var ListView = Backbone.View.extend({
    el: $('body'),    
    initialize: function(){
      _.bindAll(this, 'render'); 
       this.render(); 
    },
    render: function(){
      $(this.el).append("<ul> <li>Hola Mundo</li> </ul>");
    }
  });

  
  var listView = new ListView();
})(jQuery);

// this.el se enlaza con un elemento existente
// la instrucción _bindAll al parecer tiene la función de evitar la perdida e contexto de this en los metodos que se enumerand
// esta vista se auto renderiza al inicializarse
// se crea una instancia de ListView
// la función se define anonimante y se hace actuar sobre el objeto jQuery por lo que dentro de la misma
// el parametro $ hace referencia a jQuery
