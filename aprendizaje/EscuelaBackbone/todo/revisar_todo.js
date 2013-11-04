(function() {
  var __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
    for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; }
    function ctor() { this.constructor = child; }
    ctor.prototype = parent.prototype;
    child.prototype = new ctor;
    child.__super__ = parent.prototype;
    return child;
  }, __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };
  define(["app", "../../templates/todoitem"], function(app) {
    app.Models.TodoModel = (function() {
      __extends(TodoModel, Backbone.Model);
      function TodoModel() {
        TodoModel.__super__.constructor.apply(this, arguments);
      }
      TodoModel.prototype.urlRoot = "/todos";
      return TodoModel;
    })();
    app.Collections.TodoCollection = (function() {
      __extends(TodoCollection, Backbone.Collection);
      function TodoCollection() {
        TodoCollection.__super__.constructor.apply(this, arguments);
      }
      TodoCollection.prototype.model = app.Models.TodoModel;
      TodoCollection.prototype.url = "/todos";
      TodoCollection.prototype.comparator = function(todo) {
        return todo.get("id");
      };
      return TodoCollection;
    })();
    app.Views.TodoItemView = (function() {
      __extends(TodoItemView, Backbone.View);
      function TodoItemView() {
        TodoItemView.__super__.constructor.apply(this, arguments);
      }
      TodoItemView.prototype.tagName = "li";
      TodoItemView.prototype.initialize = function() {
        _.bindAll(this);
        this.model.bind("sync", this.render);
        return this.model.bind("remove", this.unrender);
      };
      TodoItemView.prototype.render = function() {
        var that;
        that = this;
        dust.render("templates/todoitem", this.model.toJSON(), function(err, out) {
          that.$el.html(err ? err : out).data("item-id", that.model.toJSON().id);
          return $(".edit", that.$el).editInPlace({
            context: that,
            onChange: that.editTodo
          });
        });
        return this;
      };
      TodoItemView.prototype.remove = function() {
        return this.model.destroy();
      };
      TodoItemView.prototype.unrender = function() {
        return this.$el.remove();
      };
      TodoItemView.prototype.editTodo = function(content) {
        return this.model.set("content", content).save(this.model.toJSON());
      };
      return TodoItemView;
    })();
    return app.Views.TodoListView = (function() {
      __extends(TodoListView, Backbone.View);
      function TodoListView() {
        TodoListView.__super__.constructor.apply(this, arguments);
      }
      TodoListView.prototype.el = ".todos";
      TodoListView.prototype.events = {
        "submit .todoform": "addTodo",
        "click a.delete": "deleteTodo"
      };
      TodoListView.prototype.initialize = function() {
        _.bindAll(this);
        this.collection = new app.Collections.TodoCollection;
        return this.collection.fetch({
          success: this.render
        });
      };
      TodoListView.prototype.render = function() {
        var model, _fn, _i, _len, _ref;
        $(".todolist", this.el).html("<ul></ul>");
        _ref = this.collection.models;
        _fn = __bind(function(model) {
          return $(".todolist ul", this.el).append(new app.Views.TodoItemView({
            model: model
          }).render().el);
        }, this);
        for (_i = 0, _len = _ref.length; _i < _len; _i++) {
          model = _ref[_i];
          _fn(model);
        }
        return this;
      };
      TodoListView.prototype.addTodo = function(event) {
        var that, todo;
        event.preventDefault();
        if ($.trim($("#content", event.target).val()) === "") {
          return;
        }
        that = this;
        todo = new app.Models.TodoModel({
          content: $("#content", event.target).val()
        });
        return todo.save(todo.toJSON(), {
          success: function(model, response, options) {
            that.collection.add(model);
            $("#content", ".todoform").val("");
            return $(".todolist ul", that.$el).append(new app.Views.TodoItemView({
              model: model
            }).render().el);
          }
        });
      };
      TodoListView.prototype.deleteTodo = function(event) {
        var todo;
        event.preventDefault();
        todo = this.collection.get($(event.target).closest("li").data("item-id"));
        return todo.destroy();
      };
      return TodoListView;
    })();
  });
}).call(this);
