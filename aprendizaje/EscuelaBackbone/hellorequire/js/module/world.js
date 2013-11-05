define(['module/hello'], function (helloref) {
    var hello = new helloref();
	var _name = 'World !';
	
    var worldModule = function () {	
        this.getName = function () {
            return hello.getName()+' '+ _name;
        }
    };
    return worldModule;  
});