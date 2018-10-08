function showBadgeDialog(userId, badgeTypeId, badgeName, userName) {
	$('#_userbadgesdisplay_userId').val(userId);
	$('#_userbadgesdisplay_badgeTypeId').val(badgeTypeId);
	$('#badgeModal .modal-title').text("Add " + badgeName + " to " + userName);
}

function addBadge() {
	$('#badgeForm').submit();
	$("#badgeModal").modal('hide');
}