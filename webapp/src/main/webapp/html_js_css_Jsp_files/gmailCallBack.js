//google callback. This function will redirect to our login servlet
function onSignIn(googleUser) {
    const profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId());
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail());
    console.log('id_token: ' + googleUser.getAuthResponse().id_token);

    //do not post all above info to the server because that is not secure.
    //just send the id_token

    const redirectUrl = 'http://localhost:8080/log';

    //using jquery to post data dynamically
    const form = $('<form action="' + redirectUrl + '" method="post">' +
        '<input type="text" name="id_token" value="' +
        googleUser.getAuthResponse().id_token + '" />' +
        '</form>');
    $('body').append(form);
    form.submit();
}