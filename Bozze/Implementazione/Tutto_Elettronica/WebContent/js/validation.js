
function ValidateForm(form)
{
	var valid=true;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var letters = /^[a-zA-Z]+$/;
	var cf = /^([A-Z]{6})?([0-9]{2})?([A-Z]{1})?([0-9]{2})?([A-Z]{1})?([0-9]{3})?([A-Z]{1})+$/;
	var date=/\d{1,2}\/\d{1,2}\/\d{4}/;
	if(form.email.value.match(mailformat)) {
		form.email.style.backgroundColor="white";
	}
	else {
		form.email.style.backgroundColor = "red";
		valid = false;
	}
	
	if(form.nome.value.match(letters)) {
		form.nome.style.backgroundColor = "white";
	}
	else
		{
		form.nome.style.backgroundColor = "red";
		valid=false;
	}
	
	if(form.cognome.value.match(letters)){
		form.cognome.style.backgroundColor = "white";
		
	}
	else
	{
		form.cognome.style.backgroundColor = "red";
		valid=false;
	}
	
	if(form.cf.value.match(cf)){
		form.cf.style.backgroundColor = "white";
	}
	else
	{
		form.cf.style.backgroundColor = "red";
		valid=false;
	}
	
	if(form.password.value.length<5){
		form.password.style.backgroundColor = "red";
		valid=false;
		alert("password non corretta, inserire almeno 5 caratteri")
	}
	else{
		form.password.style.backgroundColor = "white";
	}
	if(date.test(form.data.value)){
		form.data.style.backgroundColor = "white";
	}
	else{
		form.data.style.backgroundColor = "red";
		valid=false;
	}

	return valid;
}





	