(function() {
  require.config({
    shim: {
      backbone: {
        deps: ["underscore", "jquery"],
        exports: "Backbone"
      },
      app: {
        deps: ["backbone", "dust"],
        exports: "app"
      }
    }
  });
  require(["app", "router"], function(app, Router) {
    return $(function() {
      app.router = new Router();
      return Backbone.history.start({
        pushState: true,
        root: "/"
      });
    });
  });
}).call(this);
