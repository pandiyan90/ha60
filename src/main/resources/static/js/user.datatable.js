$(document).ready(function(){
	var table = $('#userTable').DataTable({
		"sAjaxSource":"users",
		"sAjaxDataProp":"",
		"order":[[0, "asc"]],
		"aoColumns":[
			{"mData":"userId"},
			{"mData":"name"},
			{"mData":"isActive"}
		]
	})
});