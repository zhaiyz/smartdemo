$(function() {
	$('.user-delete').click(function() {
        if (confirm('Delete User?')) {
            var url = $(this).attr('href');
            $.ajax({
                type: 'delete',
                url: url,
                dataType: 'json',
                success: function(result) {
                    if (result.success) {
                        location.reload();
                    }
                }
            });
        }
        return false;
    });
	
	$('#user_create_form').ajaxForm({
        type: 'post',
        url: '/smartdemo/user',
        dataType: 'json',
        success: function(result) {
            if (result.success) {
                location.href = '/smartdemo/users';
            }
        }
    });
	
	$('#user_edit_form').ajaxForm({
        type: 'put',
        url: '/smartdemo/user/' + $('#id').val(),
        dataType: 'json',
        success: function(result) {
            if (result.success) {
                location.href = '/smartdemo/users';
            }
        }
    });
});
