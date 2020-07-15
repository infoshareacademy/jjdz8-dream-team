<#include "base-logout-user.ftlh">
<#macro content>

        <form method="post" action="/add-user">
        <h1>Wprowadź dane nowego użytkownika</h1>
            <#if incorrectForm ??>
                <div class="alert alert-danger" role="alert">
                    Coś poszło nie tak, pola muszą zostać poprawnie wypełnione!
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </#if>
            <div class="form">
                <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">nickname</label>
                    <#if emptyNickName ??>
                        <p id="emailHelp" style="color: red">pole nie może pozostać puste</p>
                    </#if>
                    <#if nickNameExist ??>
                        <p id="emailHelp"  style="color: red">użytkownik o podanym nickName już istnieje</p>
                    </#if>
                       <input type="text" class="form-control" id="inputEmail4" name="nickName" <#if nickName??>value="${nickName}" </#if>>
                    </div>
                    </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">email</label>
                        <input type="email" class="form-control" id="inputEmail4" name="email" <#if email??>value="${email}" </#if>>
                           <#if emptyEmail ??>
                            <p  style="color: #ff0000">pole nie może pozostać puste</p>
                        </#if>
                        <#if emailExist ??>
                            <p  style="color: #ff0000">użytkownik o podanym adresie email już istnieje</p>
                        </#if>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputPassword4" >wprowadź hasło</label>
                        <input type="password" class="form-control" id="inputPassword4" name="password" required>
                           <#if emptyPassword ??>
                            <p  style="color: #ff0000">pole nie może posostać puste/niewłaściwy format</p>
                        </#if>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputPassword4" style="color: darkgreen">powtórz hasło</label>
                       <#if emptyPassword ??>
                            <p  style="color: #ff0000">pole nie może posostać puste/niewłaściwy format</p>
                        </#if>
                        <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="role"> załóż konto jako:</label>
                <select id="role" name="role" class="form-control form-control-lg">
                    <option value="TEACHER">TEACHER</option>
                    <option value="STUDENT">STUDENT</option>
                </select>
                    </div>
                </div>
                <input class="btn btn-secondary" type="submit" name="save" value="załóż konto"/><br/><br/>
                </div>
        </form>
</#macro>

<@home/>

