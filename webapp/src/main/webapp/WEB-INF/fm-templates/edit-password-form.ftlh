<form method="post" action="http://localhost:8080/edit-password">
    <div class="form-row">

        <div class="form-group col-md-6">
            <label for="oldPassword">wprowadź stare hasło</label>
            <input type="password" class="form-control" id="oldPassword" name="oldPassword">
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
    <input class="btn btn-secondary" type="submit" name="save" value="zatwierdź"/><br/><br/>
</form>