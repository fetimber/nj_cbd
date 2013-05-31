var $j = jQuery.noConflict();

var loginModel = Backbone.Model.extend({
	
	
	
})

$j(document).ready(function($) {
	//var app = new AppRouter;   
	//Backbone.history.start();
	//#login_button
	   
    var loginBean = new loginModel();
    
    
    loginBean.fetch({
    	url:'test2.do',
    	success:function(model,response){
 
        //model为获取到的数据
        alert(model.id);
        
    },error:function(){
        //当返回格式不正确或者是非json数据时，会执行此方法
        alert('error');
    }});
});