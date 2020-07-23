

<form id="user-form">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputNickname">nickname</label>
            <#if emptyNickname ??><p style="color: crimson">* to pole nie może pozostać puste</p>
                <input type="text" class="form-control" id="inputNickname" name="nickName" placeholder="enter nickname">
            <#elseif nickNameExist ??><p style="color: crimson">użytkownik o podanym nickname już istnieje </p>
                <input type="text" class="form-control" id="inputNickname" name="nickName" placeholder="enter nickname">
            <#else > <input type="text" class="form-control" id="inputNickname" name="nickName"
                            value="${user.nickName}">
            </#if>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <#if emptyEmail ??><p style="color: crimson">* to pole nie może pozostać puste</p>
                <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="enter email">
            <#elseif emailExist ??><p style="color: crimson">użytkownik o podanym adresie email już istnieje</p>
                <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="enter email">
            <#else> <input type="text" class="form-control" id="inputEmail4" name="email" value="${user.email}">
            </#if>
        </div>
    </div>
    <input type="hidden" name="id" value="${user.id}">
    <button type="submit" class="btn btn-primary">edytuj</button>
    <br><br>
</form>
