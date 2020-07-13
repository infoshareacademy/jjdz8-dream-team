
$("#edit-subject-form").submit(function(event){
    event.preventDefault();
    var $form = $(this);
    var userId = $form.find('input[name="userId"]').val();
    var id = $form.find('input[name="id"]').val();
    var subjectName = $form.find('input[name="name"]').val();
    var subjectTopic = $form.find('input[name="topic"]').val();
    var subjectDescription = $form.find('textarea[name="description"]').val();
    var subjectIsVideo = $form.find('input[name="isVideo"]').val();
    var subjectVideoLink = $form.find('input[name="videoLink"]').val();
    var url = 'http://localhost:8080/subjects';

    $.ajax({
        type : 'PUT',
        url : url,
        contentType: 'application/json',
        data : JSON.stringify({id:id,  name: subjectName, topic: subjectTopic, description: subjectDescription,
        isVideo:subjectIsVideo, videoLink:subjectVideoLink }),
        success : function(data, status, xhr){
            window.location.replace("http://localhost:8080/subjects?id="+id);
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
});