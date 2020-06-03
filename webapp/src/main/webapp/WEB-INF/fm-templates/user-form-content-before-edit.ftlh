
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
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputPassword4" style="color: darkgreen">Enter password to confirm changes</label>
            <input type="password" class="form-control" id="inputPassword4" name="oldPassword"
                   placeholder="Password" required >
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputPassword4" style="color: darkgreen">If you want to change password please enter new one</label>
            <input type="password" class="form-control" id="inputPassword4" name="newPassword"
                   placeholder="Password">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputPassword4" style="color: darkgreen">Repeated to confirm changes                         </label>
            <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword"
                   placeholder="Password" >
        </div>
    </div>
    <input class="btn btn-primary" type="submit" name="save" value="edit"/><br/><br/>
