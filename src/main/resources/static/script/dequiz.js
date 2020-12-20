/**
 * 
 */
/* load header */
$(document).ready(function fistLoad(){
	$("#headerpage").load("/header.html");
	$("#footerpage").load("/footer.html");
	if ($(location).attr('href').endsWith('adminlogin')){
		$("#headerpage").load("/header2.html");
	}
});
