
	/*checking two password field*/
	function checkPass(){
	    //Store the password field objects into variables ...
	    var pass1 = document.getElementById('txtNewPassword');
	    var pass2 = document.getElementById('txtConfirmPassword');
	    //Store the Confimation Message Object ...
	    var message = document.getElementById('confirmMessage');
	    //Set the colors we will be using ...
	    var goodColor = "#66cc66";
	    var badColor = "#ff6666";
	    //Compare the values in the password field 
	    //and the confirmation field
	    if(pass1.value == pass2.value){
	        //The passwords match. 
	        //Set the color to the good color and inform
	        //the user that they have entered the correct password 
	        //pass2.style.backgroundColor = goodColor;
	        message.style.color = goodColor;
	        message.innerHTML = "Passwords Match!"
	        document.getElementById('submit').disabled = false;
	    }else{
	        //The passwords do not match.
	        //Set the color to the bad color and
	        //notify the user.
	        //pass2.style.backgroundColor = badColor;
	        message.style.color = badColor;
	        message.innerHTML = "Passwords Do Not Match!"
	       	document.getElementById('submit').disabled = true;
	    }
	}  
	
	
	/*checking confirm Id*/
	$(document).ready(function(){
		
        $("#submit").click(function(){
            var text = $("#comId").val();
            var comparingText = "12";
            if (text == comparingText){
                //alert( $("#comId").val());
                return true;
            }else if(text == ""){
            	$("#confirmIdMsg").html("<strong>Warning!</strong> Confirm id field is empty");
            	return false;
            }else{
            	$("#confirmIdMsg").html("<strong>Warning!</strong> Invalid confirm Id");
            	return false;
            }

        });
        
        //clear
        $("#comId").keyup(function(){
            $("#confirmIdMsg").html("");
            return false;
        });
        
        $("#loginuser").keyup(function(){
            $("#loginMsg").html("");
        });
        $("#loginpass").keyup(function(){
            $("#loginMsg").html("");
        });
        
        $("#genericName").keyup(function(){
            $("#MSG").html("");
        });
    });
