<#include "base.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane logowania
        </div>
        <div class="row">
            <div class="col-md-4">
                <#if message ??>
                    <h1>You have to login or registry first</h1>
                    <a href="http://localhost:8080/chooseWhoIsLogin.jsp">
                        <input type="button" value="login"/>
                    </a>
                    <a href="http://localhost:8080/add-user.jsp">
                        <input type="button" value="registry"/>
                    </a>
                </#if>
                <#if user ?? >
                <div class="card" style="width: 18rem;">
                    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="card-img-top"
                         alt="Daniel Adams">
                    <div class="card-body">
                        <h5 class="card-title">${user.nickName}</h5>
                        <span class="author-card-info"> date of joining</span><br><br>
                        <h5 class="author-card-details">Shortly about me</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk
                            of the
                            card's content.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <form  method="post" action="http://localhost:8080/edit-student-account">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">nickname</label>
                            <#if emptyNickname ??><p style="color: crimson">nickname cannot be empty</p>
                                NickName: <input type="text" class="form-control" id="inputEmail4" name="nickName" placeholder="enter nickname"><br/><br/>
                                <br/><br/>
                            <#elseif nickName ??> <input type="text" class="form-control" id="inputEmail4" name="nickName" value="${nickName}" ><br/><br/>
                            </#if>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <#if emptyEmail ??><p style="color: crimson">nickname cannot be empty</p>
                                <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="enter email">
                            <#elseif email ??> <input type="email" class="form-control" id="inputEmail4" name="email" value="${email}" ><br/><br/>
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
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">repeated password</label>
                            <#if wrongPasswordFormat ??> <p style="color: crimson">please repeat</p>
                            <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword" placeholder="Password">
                            <#else ><input type="password" class="form-control" id="inputPassword4" name="newPassword">
                            </#if>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">edit</button>
                </form>
            </div>
            </#if>
        </div>
    </div>
    </div>
</#macro>

<@home/>




