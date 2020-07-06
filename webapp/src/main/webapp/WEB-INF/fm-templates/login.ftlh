<#include "base-logout-user.ftlh">
<#macro content>
    <main>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form method="post" action="/login">
                    <div class="form-row col-md-12">
                        <#if incorrect ??>
                            <div class="alert alert-danger" role="alert">
                                Nieprawidłowe dane logowania! Spróbuj jeszcze raz
                            </div>
                        </#if>
                    </div>
                    <div class="form-row col-md-12">
                        <label for="formGroupExampleInput">nickname</label>
                        <input type="text" class="form-control" id="formGroupExampleInput" name="nickName"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-row col-md -12">
                        <label for="formGroupExampleInput2">password</label>
                        <input type="password" class="form-control" id="formGroupExampleInput2" name="password"
                               placeholder="Another input placeholder">
                    </div>
                    <br>
                    <div class="form-row col-md -12">
                        <button type="submit" class="btn btn-primary">zaloguj</button>
                    </div>
                    <div class="form-row col-md -12">
                        <a class="underlineHover" href="#">zapomniales hasla?</a>
                    </div>
                </form>
            </div>
        </div>
    </main>
</#macro>
<@home/>