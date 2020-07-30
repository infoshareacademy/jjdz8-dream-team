
$("#user-form").submit(function(event){
    event.preventDefault();
    var $form = $(this);
    var userId = $form.find('input[name="id"]').val();
    var userNickName = $form.find('input[name="nickName"]').val();
    var userEmail = $form.find('input[name="email"]').val();
    var userRole = $form.find('select[name="role"]').val();
    var url = 'http://localhost:8080/user';

    $.ajax({
        type : 'PUT',
        url : url,
        contentType: 'application/json',
        data : JSON.stringify({id:userId, nickName: userNickName, email: userEmail, role: userRole}),
        success : function(data, status, xhr){
            window.location.replace("http://localhost:8080/user");
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
});