var regex = new RegExp("[a-zA-Z0-9]+@[a-zA-Z]+.[com|edu]");

function onSubmit(event){
    event.preventDefault();
    if(document.getElementById('Fname').value == ''){
    	alert('Please enter First Name');
    }
    else if(document.getElementById('Lname').value == ''){
    	alert('Please enter Last Name');
    }
    else if(document.getElementById('g').value == ''){
    	alert('Please enter Gender');
    }
    else if(document.getElementById('email').value == ''){
    	alert('Please enter Email Address');
    }
    else if(document.getElementById('location').value == ''){
    	alert('Please enter location');
    }
    else{
	    if(regex.test(document.getElementById('email').value)){
	    var JSON_obj = JSON.parse(JSON.stringify(`{FirstName: ${document.getElementById('Fname').value}, LastName: ${document.getElementById('Lname').value}, Gender: ${document.getElementById('g').value}, E-mail: ${document.getElementById('email').value}, Location: ${document.getElementById('location').value}}`));
	    // console.log(document.getElementById("name").value);  
	    console.log(JSON_obj);
	    }
	    else{
	        alert('Enter Valid E-mail Address!!')
	    }
	}
}