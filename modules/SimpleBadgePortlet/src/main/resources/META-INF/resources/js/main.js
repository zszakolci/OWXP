function showSimpleBadgeDialog(badgeTypeId, badgeName) {
	$('#_simplebadge_badgeTypeId').val(badgeTypeId);
	$('#simpleBadgeModal .modal-title').text("Add " + badgeName + " to " + $("#_simplebadge_userName").val());
}

function addSimpleBadge() {
	$('#simpleBadgeForm').submit();
	$("#simpleBadgeModal").modal('hide');
}

$(document).ready(function() {
	jQuery(document).ready(function() {
		$('select.flexselect').flexselect();
		$('#nameSelect_flexselect').attr("placeholder", "Name of colleague");
		$('#nameSelect_flexselect').prop('required', true);

		$('#nameSelect_flexselect').focusin(function() {
			$('#simpleDropdownMenu').prop('disabled', true);
		});
		$('#nameSelect_flexselect').keyup(function() {
			userName = this.value;

			$('#_simplebadge_userName').val(userName);

			if (userName != "") {
				userId = $("#nameSelect").find('option:selected').val();
				$('#_simplebadge_userId').val(userId);
				$('#simpleDropdownMenu').prop('disabled', false);
			}
			else {
				$('#_simplebadge_userId').val("");
				$('#simpleDropdownMenu').prop('disabled', true);
			}
		});
	});
})