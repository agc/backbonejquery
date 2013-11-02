
(function($){
  var ListView = Backbone.View.extend({
    el: $('body'), 
    
    events: {
      'click button#nuevo': 'ponerItem'
    },
    initialize: function(){
      _.bindAll(this, 'render', 'ponerItem'); 

      this.counter = 0; 
      this.render();
    },
    
    render: function(){
      $(this.el).append("<button id='nuevo'>Añadir un item a la  lista</button>");
      $(this.el).append("<ul></ul>");
    },
    
    ponerItem: function(){
      this.counter++;
      $('ul', this.el).append("<li>hola mundo "+this.counter+"</li>");
    }
  });

  var listView = new ListView();
})(jQuery);

// Enlace (binding) de eventos DOM a métodos de View
// la propiedad events designa un objeto donde los eventos DOM son enlazados a metodos View
// No existe en Backbone un controlador separado para tales bindings, todo ocurre en la vista
// click button#add evento producida en el boton con id add
// se crea una nueva propiedad this.counter en la función initializce
// ahora el método render añade elementos DOM, entre otros el botón que dispara los eventos 
// la función que responde al evento se define aquí en la vista ponerItem
