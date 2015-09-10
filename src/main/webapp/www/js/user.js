$(function() {
	$('.user-delete').click(function() {
        var $tr = $(this).closest('tr');
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
});
