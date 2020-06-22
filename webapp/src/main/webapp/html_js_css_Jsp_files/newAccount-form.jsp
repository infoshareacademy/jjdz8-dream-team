<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form method="post" action="/user" class="">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="Email">Email</label>
                <input type="email" class="form-control" id="Email" placeholder="Email">
            </div>
            <div class="form-group col-md-6">
                <label for="Haslo">Hasło</label>
                <input type="password" class="form-control" id="Haslo" placeholder="Password">
            </div>
        </div>
    <div class="form-row">
            <div class="form-group col-md-6">
                <label for="Login">Login</label>
                <input type="text" class="form-control" id="Login" placeholder="Login">
            </div>
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
                <label for="WhoIAm">Who I am</label>
                <select id="WhoIAm" class="form-control">
                    option selected>Select</option>
                    <option>Teacher</option>
                    <option>Student</option>
                </select>
            </div>
        </div>
            <div class="form-group col-md-1">
                <label for="przykladoweWojewodztwo">Video material</label>
                <select id="przykladoweWojewodztwo" class="form-control">
                    <option selected>Select</option>
                    <option>Yes</option>
                    <option>No</option>
                </select>
            </div>
        </div>
    <div>
        <button type="submit  " class="btn btn-dark">Send</button>
    </div>
    </form>
</form>
