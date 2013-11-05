// como no se definen parametros se debe acceder a ellos con arguments
// el primero será el nombre de la función los siguientes las opciones
// si hay 2 o mas se elimina el primero y se crea un array con Array.prototype.slice
// que contienen del argumento con indice 1 hasta el final
// [fn, op1,op2,....,opn] se separa [op1,op2,...,opnn] y se le pasa
// a la funcion f.call([op1,op2,....])

// var fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
// var citrus = fruits.slice(1,3);
// en slice this es el array
// Array.protype.slice(arguments,1) convierte a arguments en el this
// equivale a arguments.slice(1)

$.fn.editInPlace= function() {
	
        var method, options;
        method = arguments[0], options = 2 <= arguments.length ? Array.prototype.slice.call(arguments, 1) : [];
}


$.fn.editInPlace = (method, options...) ->
  this.each ->
    methods =
    # public methods
      init: (options) ->
        valid = (e) =>
          newValue = @input.val()
          options.onChange.call(options.context, newValue)
        cancel = (e) =>
          @$el.show()
          @input.hide()
        @$el = $(this).dblclick(methods.edit)
        @input = $("<input type='text' />")
          .insertBefore(@$el)
          .keyup (e) ->
            switch(e.keyCode)
            # Enter key
              when 13 then $(this).blur()
            # Escape key
              when 27 then cancel(e)
          .blur(valid)
          .hide()
      edit: ->
        @input
          .val(@$el.text())
          .show()
          .focus()
          .select()
        @$el.hide()
      close: (newName) ->
        @$el.text(newName).show()
        @input.hide()
    # jQuery approach: http://docs.jquery.com/Plugins/Authoring
    if ( methods[method] )
      return methods[ method ].apply(this, options)
    else if (typeof method == 'object')
      return methods.init.call(this, method)
    else
      $.error("Method " + method + " does not exist.")
