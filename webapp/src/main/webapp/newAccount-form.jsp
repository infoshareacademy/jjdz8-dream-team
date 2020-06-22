<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post" action="${pageContext.request.contextPath}/add-user" class="">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="nickName">Nickname</label>
            <input type="text" class="form-control" id="nickName" name="nickName" placeholder="Nickname">
        </div>
        <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="password">Hasło</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="form-group col-md-6">
            <label for="repeatedPassword">Powtórz Hasło</label>
            <input type="password" class="form-control" id="repeatedPassword" placeholder="repeatedPassword">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="FirstName">First Name</label>
            <input type="text" class="form-control" id="FirstName" placeholder="FirstName">
        </div>
        <div class="form-group col-md-6">
            <label for="LastName">Last Name</label>
            <input type="text" class="form-control" id="LastName" placeholder="Last Name">
        </div>
    </div>
    <div class="form-group col-md-6">
        <label for="Nationality">Nationality</label>
        <input type="text" class="form-control" id="Nationality" placeholder="Nationality">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="przykladoweMiasto">Miasto</label>
            <input type="text" class="form-control" id="przykladoweMiasto">
        </div>
        <div class="form-group col-md-6">
            <label for="whoIAm">Who I am</label>
            <select name="whoIAm" id="WhoIAm"  class="form-control">
                <option selected>Select</option>
                <option>Teacher</option>
                <option>Student</option>
            </select>
        </div>
    </div>
    <div>
        <button type="submit" class="btn btn-dark">Send</button>
    </div>
</form>