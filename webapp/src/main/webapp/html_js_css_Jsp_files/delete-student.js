$("#delete-user").each(function () {
    $(this).on('click', function () {
        const id = $('#delete-user').val();
        $.ajax({
            "url": '/student?id='+id,
            "method": 'DELETE',
            "success": function () {
                 location.replace("/page-after-delete-account.jsp");
            },
        })
    });
})
