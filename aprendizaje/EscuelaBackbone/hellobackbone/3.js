
(function($){
  
  var Item = Backbone.Model.extend({
    defaults: {
      part1: 'hello',
      part2: 'world'
    }
  });

  
  var List = Backbone.Collection.extend({
    model: Item
  });

  var ListView = Backbone.View.extend({
    el: $('body'),
    events: {
      'click button#nuevo': 'ponerItem'
    },
    
    initialize: function(){
      _.bindAll(this, 'render', 'ponerItem', 'itemPuesto'); // remember: every function that uses 'this' as the current object should be in here

      this.collection = new List();
      this.collection.bind('add', this.itemPuesto); //cuando se añade un modelo se invoca este metodo

      this.counter = 0;
      this.render();
    },
    render: function(){
      // Save reference to `this` so it can be accessed from within the scope of the callback below
      var self = this;
      $(this.el).append("<button id='nuevo'>Añadir un item a la lista..</button>");
      $(this.el).append("<ul></ul>");
      _(this.collection.models).each(function(item){ // in case collection is not empty
        self.ponerItem(item);
      }, this);
    },
    // `addItem()` now deals solely with models/collections. View updates are delegated to the `add` event listener `appendItem()` below.
    ponerItem: function(){
      this.counter++;
      var item = new Item();
      item.set({
        part2: item.get('part2') + this.counter // modify item defaults
      });
      this.collection.add(item); // add item to collection; view is updated via event 'add'
    },
    // `appendItem()` is triggered by the collection event `add`, and handles the visual update.
    itemPuesto: function(item){
      $('ul', this.el).append("<li>"+item.get('part1')+" "+item.get('part2')+"</li>");
    }
  });

  var listView = new ListView();
})(jQuery);

// Un modelo es un objeto , es decir pares clave- valor con algunos metodos auxiliares
// Una coleccion es basicamente, un array de modelos con métodos auxiliares
// en el ejemplo anterior la vista NO tenia un modelo: la información añadida al dom estaba explicitamente en el codigo
// la vista tiene un campo coleccion, al que se añadirán Items. La lista lanza un evento cada vez que se añade un Item.
// Como el metodo que gestiona el evento es de View la vista escucha a la coleccion 
// la respuesta consiste en insertar información en el DOM

// al pulsar el boton se dispara un evento objeto events
// la respuesta al evento incluye un item en la coleccion 
// que dispara el evento que es recibido por la vista que modifica el HTML de la página