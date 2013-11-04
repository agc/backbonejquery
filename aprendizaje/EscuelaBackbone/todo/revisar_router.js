(function() {
  var __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
    for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; }
    function ctor() { this.constructor = child; }
    ctor.prototype = parent.prototype;
    child.prototype = new ctor;
    child.__super__ = parent.prototype;
    return child;
  };
  define(["app", "modules/todo"], function(app) {
    var Router;
    return Router = (function() {
      __extends(Router, Backbone.Router);
      function Router() {
        Router.__super__.constructor.apply(this, arguments);
      }
      Router.prototype.routes = {
        "": "index"
      };
      Router.prototype.index = function() {
        return new app.Views.TodoListView;
      };
      return Router;
    })();
  });
}).call(this);
