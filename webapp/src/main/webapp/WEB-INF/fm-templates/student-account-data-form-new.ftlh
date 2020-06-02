<#include "base.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Login data
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
                <form method="post" action="http://localhost:8080/edit-student-account">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">nickname</label>
                            <input type="text" class="form-control" id="inputEmail4" name="nickName"
                                   value="${user.nickName}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="inputEmail4" name="email"
                                   value="${user.email}">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputPassword4" style="color: darkgreen">Enter password to confirm changes</label>
                            <input type="password" class="form-control" id="inputPassword4" name="oldPassword"
                                   placeholder="Password" required >
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputPassword4" style="color: darkgreen">If you want to change password please enter new one</label>
                            <input type="password" class="form-control" id="inputPassword4" name="newPassword"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-row">
                    <div class="form-group col-md-6">
                            <label for="inputPassword4" style="color: darkgreen">Repeated to confirm changes                         </label>
                            <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword"
                                   placeholder="Password" >
                        </div>
                    </div>
                    <input class="btn btn-primary" type="submit" name="save" value="edit"/><br/><br/>
                </form>
                <br>
            </div>
            </#if>
        </div>
    </div>
    </div>
</#macro>

<@home/>