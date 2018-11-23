function selectUser(userId, userName) {
	$('#_userbadgelist_userId').val(userId);
	$('#dropdownListUserMenu').text(userName);
	$('#_userbadgelist_userForm').submit();
}

$(document).ready(function(){
	userName = $('#_userbadgelist_userName').val();
	$('#dropdownListUserMenu').text(userName);
});