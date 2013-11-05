// Load modules and use them

require.config(
	{
		paths: {
			'jquery':'thirdparty/jquery-1.9.0.min'
		}
	}
);
require(
['jquery','module/hello', 'module/world'], 

function($, helloref, worldref){
   
    
  var hello = new helloref(),world = new worldref();
  
   
   
   $("#req_click").click(function(){
      alert("I'm clicked");
    });
    
    $("#result").html(world.getName());
}
);