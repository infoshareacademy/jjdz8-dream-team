<form id="user-edit-form">
    <div class="form-row">

        <div class="form-group col-md-6">
            <label for="oldPassword">wprowadź stare hasło</label>
            <input type="password" class="form-control" id="oldPassword" name="password">
        </div>
        <div class="form-group col-md-6">
            <label for="newPassword">podaj nowe hasło</label>
            <input type="password" class="form-control" id="newPassword" name="newPassword">
        </div>
        <div class="form-group col-md-6">
            <label for="repeatedPassword">powtórz nowe hasło</label>
            <input type="password" class="form-control" id="repeatedPassword" name="repeatedPassword">
        </div>
    </div>
    <input type="hidden" name="id" value="${user.id}">
    <input class="btn btn-secondary" type="submit" name="save" value="zatwierdź"/><br/><br/>
</form>