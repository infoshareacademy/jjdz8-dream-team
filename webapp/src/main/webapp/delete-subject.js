$("#delete-subject").each(function () {
    $(this).on('click', function () {
        const id = $('#delete-subject').val();
        console.log(id);
        $.ajax({
            "url": '/subject?id='+id,
            "method": 'DELETE',
            success: function () {
                location.replace("http://localhost:8080/teacher-account-information");
            },
        })
    });
})
