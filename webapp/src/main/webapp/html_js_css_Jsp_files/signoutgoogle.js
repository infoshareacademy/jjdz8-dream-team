$("#logout").submit(function (event) {
    event.preventDefault();
    gapi.auth2.getAuthInstance().signOut().then(function () {
        console.log('User signed out.');
        location.reload();
    });

});