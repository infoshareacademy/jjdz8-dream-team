<#include "base-logout-user.ftlh">
<#macro content>
 <#if message??>
        <div class="alert alert-danger" role="alert">
            Coś poszło nie tak, pola nie mogą pozostać puste!
        </div>
    </#if>
        <form method="post" action="/add-user">
        <h1>Wprowadź dane nowego użytkownika</h1>
            <div class="form">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">nickname</label>
                       <input type="text" class="form-control" id="inputEmail4" name="nickName" <#if nickName??>value="${nickName}" </#if>
                         <#if emptyNickName ??>
                            <small id="emailHelp" class="form-text text-muted" style="color: #ff0000">pole nie może posostać puste</small>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" name="email" <#if email??>value="${email}" </#if>>
                           <#if emptyEmail ??>
                            <small class="form-text text-muted" style="color: #ff0000">pole nie może posostać puste</small>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword4" >Wprowadź hasło</label>
                        <input type="password" class="form-control" id="inputPassword4" name="password" required>
                           <#if emptyPassword ??>
                            <small class="form-text text-muted" style="color: #ff0000">pole nie może posostać puste</small>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword4" style="color: darkgreen">Powtórz hasło</label>
                        <#if emptyPassword ??>
                            <p style="color: red">pole nie może posostać puste</p>
                        </#if>
                        <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword" required>
                    </div>
                    <div class="form-group">
                        <label for="role"> załóż konto jako:</label>
                <select id="role" name="role" class="form-control form-control-lg">
                    <option value="TEACHER">TEACHER</option>
                    <option value="STUDENT">STUDENT</option>
                </select>
                    </div>
                <input class="btn btn-secondary" type="submit" name="save" value="załóż konto"/><br/><br/>
                </div>
        </form>
</#macro>

<@home/>

