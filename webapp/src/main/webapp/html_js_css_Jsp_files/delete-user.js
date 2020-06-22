$("#delete-user").each(function () {
    $(this).on('click', function () {
        const id = $('#delete-user').val();
        $.ajax({
            "url": '/user?id='+id,
            "method": 'DELETE',
            "success": function () {
                 location.replace("/logout");
            }
        })
    });
})
