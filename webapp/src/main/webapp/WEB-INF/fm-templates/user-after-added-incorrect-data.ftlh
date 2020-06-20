<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            User creator after incorrect data
        </div>

<#--        <#if message ??>-->
<#--            <div class="col-md-6">-->
<#--                <h1>You have to login or registry first</h1>-->
<#--                <a href="http://localhost:8080/chooseWhoIsLogin.jsp">-->
<#--                    <input type="button" class="btn btn-secondary" value="login"/>-->
<#--                </a>-->
<#--                <a href="http://localhost:8080/add-user.jsp">-->
<#--                    <input type="button" class="btn btn-secondary" value="registry"/>-->
<#--                </a>-->
<#--            </div>-->
<#--        </#if>-->
<#--        <#if user ?? >-->
            <div class="form">
                <form method="post" action="/add-user">
                    <#if emptyNickName ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">nickName cannot be empty</p>
                            <label for="Nickname">nickName</label><br>
                            <input id="Nickname" type="text" class="form-control" name="Nickname">
                        </div>
                    <#elseif nickName ??>
                        <div class="form-group col-md-6">
                            <label for="Nickname2">nickName</label><br>
                            <input id="Nickname2" type="text" name="Nickname" value="${nickName}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyEmail ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">Email cannot be empty</p>
                            <label for="Email">email</label><br>
                            <input id="Email" type="text" name="Email" value=""/><br/><br/>
                        </div>
                    <#elseif email ??>
                        <div class="form-group col-md-6">
                            <label for="Email2">email</label><br>
                            <input id="Email2" type="text" name="Email" value="${email}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyPassword ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">Password cannot be empty</p>
                            <label for="Haslo">password</label><br>
                            <textarea id="Haslo" type="text" name="Haslo"></textarea><br/><br/>
                        </div>
                    <#elseif password ??>
                        <div class="form-group col-md-6">
                            <label for="Haslo2">password</label><br>
                            <textarea id="Haslo2" type="text" name="Haslo" value="${password}"></textarea><br/><br/>
                        </div>
                    </#if>
                    <div class="form-group col-md-6">
                        <p>Pick a role</p>
                        <select id="whoIAm" name="whoIAm">
                            <option>Teacher</option>
                            <option>Student</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <input class="btn btn-secondary" type="submit" name="save" value="save"/><br/><br/>
                    </div>
                </form>
            </div>
<#--        </#if>-->
    </div>
</#macro>

<@home/>