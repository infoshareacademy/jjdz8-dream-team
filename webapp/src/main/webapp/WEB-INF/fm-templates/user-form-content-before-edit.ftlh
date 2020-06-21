<form method="post" action="http://localhost:8080/edit-user-account">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">nickname</label>
            <input type="text" class="form-control" id="inputEmail4" name="nickName"
                   value="${user.nickName}">
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4" name="email"
                   value="${user.email}">
        </div>
    </div>
    <input class="btn btn-secondary" type="submit" name="save" value="edytuj"/><br/><br/>
</form>
