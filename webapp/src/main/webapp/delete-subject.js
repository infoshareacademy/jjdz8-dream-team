$("#delete-subject").each(function () {
    $(this).on('click', function () {
        const id = $('#delete-subject').val();
        console.log(id);
        $.ajax({
            "url": '/subject?id='+id,
            "method": 'DELETE',
            "success": function () {
                alert('user succesfully deleted');
                location.replace("/teacher");
            },
            "error": function (error) {
                alert(error);
            }
        })
    });
})
