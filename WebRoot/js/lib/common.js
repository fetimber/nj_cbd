function formatJSON(data) {
	var responseObject;
	
	if (data != undefined && data != "") 
	{
	   responseObject = eval("(" + data + ")");
	}
	
	return responseObject;
	
};