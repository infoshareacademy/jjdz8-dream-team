<#include "index.ftlh">
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
                <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">nickname</label>
                            <input type="text" class="form-control" id="inputEmail4" name="nickName"
                                   placeholder="${user.nickName}" disabled>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="inputEmail4" name="email"
                                   placeholder="${user.email}" disabled>
                        </div>
                    </div>
                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Password</label>
                            <input type="password" class="form-control" id="inputPassword4" name="password"
                                   placeholder="Password" disabled>
                        </div>
                    </div>
                </form>
                <br>
                <a href="/student-account-information-servlet"><input class="btn btn-primary" type="button"
                                                                      value="edit account"></a>
            </div>
            </#if>
        </div>
    </div>

    </div>
</#macro>

<@home/>