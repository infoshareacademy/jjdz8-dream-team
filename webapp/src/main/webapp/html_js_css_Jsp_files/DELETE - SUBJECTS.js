$(".delete-subject").each(function () {
    $(this).on('click', function () {
        const id = $(".delete-subject").val();
        $.ajax({
            "url": '/subjects?id='+id,
            "method": 'DELETE',
            "success": function () {
                console.log('succes');
                location.replace("/subjects");
            }
        })
    });
})


