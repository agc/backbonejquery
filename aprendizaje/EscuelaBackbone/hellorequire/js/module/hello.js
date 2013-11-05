define([], function () {
    var helloModule = function () {
        var _name = 'Hello';
        this.getName = function () {
            return _name;
        }
    };
     return helloModule;
 });