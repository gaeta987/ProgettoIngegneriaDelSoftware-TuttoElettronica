
function ValidateForm(form)
{
	var valid=true;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var letters = /^[a-zA-Z]+$/;
	var cf = /^([A-Z]{6})?([0-9]{2})?([A-Z]{1})?([0-9]{2})?([A-Z]{1})?([0-9]{3})?([A-Z]{1})+$/;
	var date=/\d{1,2}\/\d{1,2}\/\d{4}/;
	
	if(form.username.value == ""){
		form.username.style.backgroundColor = "red";
		alert("username non valido!");
		valid = false;
	}
	if(form.email.value.match(mailformat)) {
		form.email.style.backgroundColor="white";
	}
	else {
		form.email.style.backgroundColor = "red";
		alert("email non valida!");
		valid = false;
	}
	
	if(form.nome.value.match(letters)) {
		form.nome.style.backgroundColor = "white";
	}
	else
		{
		form.nome.style.backgroundColor = "red";
		alert("nome non valido!");
		valid=false;
	}
	
	if(form.cognome.value.match(letters)){
		form.cognome.style.backgroundColor = "white";
		
	}
	else
	{
		form.cognome.style.backgroundColor = "red";
		alert("cognome non valido!");
		valid=false;
	}
	
	if(form.cf.value.match(cf)){
		form.cf.style.backgroundColor = "white";
	}
	else
	{
		form.cf.style.backgroundColor = "red";
		alert("codice fiscale non valido!");
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
	
	if(form.indirizzo.value == ""){
		alert("indirizzo non valido!");
		form.indirizzo.style.backgroundColor = "red";
		valid = false;
	}

	return valid;
}


function ValidateLogin(form){
	
	var valid = true;
	
	if(form.username.value == ""){
		alert("username non valido");
		form.username.style.backgroundColor = "red";
		valid = false;
	}
	
	if(form.password.value == ""){
		valid = false;
		alert("password non valida");
		form.password.style.backgroundColor = "red";
	}
	
	return valid;
}

function validateSearch(form){
	var valid = true;
	
	if(form.search.value == ""){
		valid = false;
		alert("nessun prodotto o categoria inserito");
	}
	return valid;
}

function prenota(form){
	var valid = true;
	
	if(form.sizeCarrello.value == 0){
		valid = false;
		alert("nessun prodotto presente nel carrello");
	}
	
	return valid;
}

function validateRiparazione(form){
	var valid = true;
	
	if(form.categoria.value == ""){
		valid = false;
		alert("categoria non valida");
	}
	
	if(form.descrizione.value == ""){
		valid = false;
		alert("descrizione non valida");
	}
	
	if(form.descrizione.value == "" && form.categoria.value == ""){
		valid = false;
		alert("categoria e descrizione non valide");
	}
	
	return valid;
}

function validateProduct(form){
	var valid = true;
	
	if(form.categoria.value == ""){
		form.categoria.style.backgroundColor = "red";
		valid = false;
		alert("categoria non valida");
	}
	
	if(form.descrizione.value == ""){
			form.descrizione.style.backgroundColor = "red";
			valid = false;
			alert("descrizione non valida");
	}
	
	if(form.quantitaMagazzino.value == 0){
		form.quantitaMagazzino.style.backgroundColor = "red";
		valid = false;
		alert("quantita non valida");
	}
	
	if(form.nome.value == ""){
		form.nome.style.backgroundColor = "red";
		valid = false;
		alert("nome non valido");
	}
	
	if(form.marca.value == 0){
		form.marca.style.backgroundColor = "red";
		valid = false;
		alert("marca non valida");
	}
	
	if(form.prezzo.value <= 0){
		form.prezzo.style.backgroundColor = "red";
		valid = false;
		alert("prezzo non valido");
	}
	
	if(form.immagine.value == ""){
		form.immagine.style.backgroundColor = "red";
		valid = false;
		alert("path immagine non valido");
	}
	
	return valid;
}





	