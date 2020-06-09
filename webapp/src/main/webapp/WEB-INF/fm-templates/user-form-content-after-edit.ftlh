<div class="form-row">
    <div class="form-group col-md-6">
        <label for="inputEmail4">nickname</label>
        <#if emptyNickname ??><p style="color: crimson">nickname cannot be empty</p>
            <input type="text" class="form-control" id="inputEmail4" name="nickName" placeholder="enter nickname"><br/><br/>
            <br/><br/>
        <#elseif nickName ??> <input type="text" class="form-control" id="inputEmail4" name="nickName" value="${nickName}" ><br/><br/>
        </#if>
    </div>
    <div class="form-group col-md-6">
        <label for="inputEmail4">Email</label>
        <#if emptyEmail ??><p style="color: crimson">nickname cannot be empty</p>
            <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="enter email">
        <#elseif email ??> <input type="text" class="form-control" id="inputEmail4" name="email" value="${email}" ><br/><br/>
        </#if>
    </div>
</div>
<div class="form-row">
    <div class="form-group col-md-6">
        <label for="inputPassword4">password</label>
        <#if wrongPassword ??> <p style="color: crimson">empty ora incorrect password</p>
            <input type="password" class="form-control" id="inputPassword4" name="oldPassword" placeholder="enter password" required>
        <#else> <input type="password" class="form-control" id="inputPassword4" name="oldPassword" required>
        </#if>
    </div>
</div>
<div class="form-row">
    <div class="form-group col-md-6">
        <label for="inputPassword4">new password</label>
        <#if wrongPasswordFormat ??>
            <p style="color: crimson">wrong format(8-20 characters,at
                lest one digit,<br>lower
                and upper chase character, special character[@,!*$...]</p>
            <input type="password" class="form-control" id="inputPassword4" name="newPassword" placeholder="enter new password" >
        <#else><input type="password" class="form-control" id="inputPassword4" name="newPassword">
        </#if>

        <label for="inputPassword4">repeated password</label>
        <#if wrongPasswordFormat ??> <p style="color: crimson">please repeat</p>
            <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword" placeholder="Password">
        <#else ><input type="password" class="form-control" id="inputPassword4" name="newPassword">
        </#if>
    </div>

</div>
<button type="submit" class="btn btn-secondary">edit</button>