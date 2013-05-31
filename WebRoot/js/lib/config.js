
var g_SERVICE_URL="http://localhost:8080/nj_dbd_platform/";


function g_getServiceUrl(uri)
{
	return g_SERVICE_URL + uri;
}


function getUrl()
{
  var currenturl=window.location.href;
  var para=getParameter("gourl",currenturl);
  if(para!=null && para!="" && para!="无此参数")
	 {
	 	 var pValue = para.split("=")[1]; 
 		document.getElementById('contentFrame').src=pValue;
	 }
}

function getParameter(paraStr, url)   
{   
    var result = "";   
    //获取URL中全部参数列表数据   
    var str = "&" + url.split("?")[1];   
    var paraName = paraStr + "=";   
    //判断要获取的参数是否存在   
    if(str.indexOf("&"+paraName)!=-1)   
    {   
        //如果要获取的参数到结尾是否还包含“&”   
        if(str.substring(str.indexOf(paraName),str.length).indexOf("&")!=-1)   
        {   
            //得到要获取的参数到结尾的字符串   
            var TmpStr=str.substring(str.indexOf(paraName),str.length);   
            //截取从参数开始到最近的“&”出现位置间的字符   
            result=TmpStr.substr(TmpStr.indexOf(paraName),TmpStr.indexOf("&")-TmpStr.indexOf(paraName));     
        }   
        else   
        {     
            result=str.substring(str.indexOf(paraName),str.length);     
        }   
    }     
    else   
    {     
        result="无此参数";     
    }     
    return (result.replace("&",""));     
}   


