
(function($){

  var Item = Backbone.Model.extend({
    defaults: { part1: 'hello',part2: 'world'
    }
  });

  var List = Backbone.Collection.extend({
    model: Item
  });

  // **ItemView class**:  responsable de renderinzar cada item

  var ItemView = Backbone.View.extend({
    tagName: 'li', 

    initialize: function(){
      _.bindAll(this, 'render'); // funciones que usan el objeto actual como this
    },

    render: function(){
      $(this.el).html('<span>'+this.model.get('part1')+' '+this.model.get('part2')+'</span>');
      return this; 
    }
  });

  var ListView = Backbone.View.extend({
    el: $('body'), 

    events: {
      'click button#nuevo': 'ponerItem'
    },

    initialize: function(){
      _.bindAll(this, 'render', 'ponerItem', 'itemPuesto'); 

      this.collection = new List();
      this.collection.bind('add', this.Item); 

      this.counter = 0;
      this.render();

    },

    render: function(){
      var self = this; // para que la función definida dentro de esta tenga acceso a this

      $(this.el).append("<button id='nuevo'>Añadir item a la lista </button>");
      $(this.el).append("<ul></ul>");
      _(this.collection.models).each(function(item){ // in case collection is not empty
        self.itemPuesto(item);
      }, this);
    },
    ponerItem: function(){
      this.counter++;
      var item = new Item();
      item.set({
        part2: item.get('part2') + this.counter // modify item defaults
      });
      this.collection.add(item);
    },
    // `appendItem()` is no longer responsible for rendering an individual `Item`. This is now delegated to the `render()` method of each `ItemView` instance.
    itemPuesto: function(item){
      var itemView = new ItemView({
        model: item
      });
      $('ul', this.el).append(itemView.render().el);
    }
  });

  var listView = new ListView();
})(jQuery);

// En un itemView hay un campo model que es asignado en ListView.appendItem que es la que reacciona
// al evento de añadir un modelo a la colección

