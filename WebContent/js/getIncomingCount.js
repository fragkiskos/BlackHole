function getUnreaded(userId){
        	   $.ajax({
                   type: "get",
                   url: "/itstock/getIncomingCount", //this is my servlet
                   data: "userId="+userId,
                   success: function(msg){   
                	   
                	   if(msg>0){
                		   //alert(document.getElementById("bubble").getAttribute("class"));
                    	   document.getElementById("bubble").setAttribute("style", "visibility:visible");
                    	   document.getElementById("bubble").innerHTML=msg; 
                       }else{
                    	   
                    	   document.getElementById("bubble").setAttribute("style", "visibility:hidden");
                    	   //document.getElementById("bubble").TEXT_NODE=msg; 
                       }
                   }
               }); 
           }
function getUnreadedNotifications(userId){
	   $.ajax({
        type: "get",
        url: "/itstock/getUnreadedNotifications", //this is my servlet
        data: "userId="+userId,
        success: function(msg){   
     	   
     	   if(msg>0){
     		   //alert(document.getElementById("bubble").getAttribute("class"));
         	   document.getElementById("noti").setAttribute("style", "visibility:visible");
         	   document.getElementById("noti").innerHTML=msg; 
            }else{
         	   
         	   document.getElementById("noti").setAttribute("style", "visibility:hidden");
         	   //document.getElementById("bubble").TEXT_NODE=msg; 
            }
        }
    }); 
}