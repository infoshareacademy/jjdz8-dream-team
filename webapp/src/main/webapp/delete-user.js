$(".delete-user").each(function () {
    $(this).on('click', function () {
        const id = $('.delete-user').val();
        console.log(id);
        $.ajax({
            "url": '/teacher?id='+id,
            "method": 'DELETE',
            "success": function () {
                alert('your account succesfully deleted');
                location.replace("/logout");
            },
            "error": function (error) {
                alert(error);
            }
        })
    });
})
