function checkPass(){
  var pass1 = document.getElementById("pwd1").value;
  var pass2 = document.getElementById("pwd2").value;
  if (pass1 == pass2){
    document.myForm.txtOutput.value = "You may proceed.";
    document.getElementById("submit_b").disabled=false;
  } else {
    document.myForm.txtOutput.value = "That is incorrect.";
  }
}

function checkLengthOfPass(pass){
	if (pass.value.length <8){
		document.myForm.txtOutput.value = "Length is <8";
	}
	
}

function isAlphanumeric(pass){
	if (!((pass.value.search(/(a-z)+/)) && (pass.value.search(/(0-9)+/)))) {
		document.myForm.txtOutput.value = "should contain at least 1 numeric character";
	}
}