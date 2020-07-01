<#include "base-logout-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Wprowadź dane dla nowego użytkownika
        </div>
        <div class="row">
            <div class="col-md-6">

                <form method="post" action="/add-user">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="input">nickname</label>
                            <input type="text" class="form-control" id="input" name="nickName"
                                   value="${user.nickName}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="inputEmail4" name="email"
                                   value="${user.email}">
                        </div>
                    </div>
                    <input class="btn btn-secondary" type="submit" name="save" value="edytuj"/><br/><br/>
                </form>


            </div>
        </div>
    </div>
</#macro>

<@home/>

