
$("#user-edit-form").submit(function(event){
    event.preventDefault();
    var $form = $(this);
    var userId = $form.find('input[name="id"]').val();
    var password = $form.find('input[name="password"]').val();
    var newPassword = $form.find('input[name="newPassword"]').val();
    var repeatedPassword = $form.find('input[name="repeatedPassword"]').val();
    var url = 'http://localhost:8080/user';

    $.ajax({
        type : 'PUT',
        url : url,
        contentType: 'application/json',
        data : JSON.stringify({id:userId,  password: password, newPassword:newPassword, repeatedPassword:repeatedPassword}),
        success : function(data, status, xhr){
            window.location.replace("http://localhost:8080/edit-user");
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
});