
function showMessage(message,messageClass){
	if(message!='null')
	{
		
		document.getElementById("sessionMessage").setAttribute("class", "sessionMessage"+messageClass);
		window.setTimeout(function(){
			document.getElementById("sessionMessage").innerHTML=message;
    		document.getElementById("sessionMessage").setAttribute("style", "top:10px");
    		
    	}, 1000);
		window.setTimeout(function(){
	    	
    		document.getElementById("sessionMessage").setAttribute("style", "visibility:hidden");
    	}, 7000);
	}
}

			
