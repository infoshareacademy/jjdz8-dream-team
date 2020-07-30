<form>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">nickname</label>
            <input type="text" class="form-control" id="inputEmail4" name="nickName"
                   placeholder="${user.nickName}" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail4">email</label>
            <input type="email" class="form-control" id="inputEmail4" name="email"
                   placeholder="${user.email}" disabled>
        </div>
    </div>
    <div class="form-row">

        <div class="form-group col-md-6">
            <label for="inputPassword4">hasło</label>
            <input type="password" class="form-control" id="inputPassword4" name="password"
                   placeholder="hasło" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="role">rola</label>
            <input type="text" class="form-control" id="role" name="role"
                   placeholder="${user.role}" disabled>
        </div>
    </div>
</form>