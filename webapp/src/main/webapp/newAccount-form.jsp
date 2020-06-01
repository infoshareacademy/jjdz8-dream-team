<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form method="post" action="/user" class="contact-from">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
        </div>
        <div class="form-group col-md-4">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="nickname">Name:</label>
            <input type="text" class="form-control" name="name" placeholder="nickname" id="nickname" required/>
        </div>
        <div class="form-group col-md-4">
            <label for="lastname">Lastname</label>
            <input type="text" class="form-control" id="lastname" placeholder="lastname">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Address</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Address 2</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
    </div>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label for="inputCity">City</label>
            <input type="text" class="form-control" id="inputCity">
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Kim jestem</label>
            <select id="inputState" class="form-control">
                <option selected>Wybór</option>
                <option>Uczeń</option>
                <option>Nauczyciel</option>
            </select>
        </div>

    </div>

    </div>
    <button type="submit" class="btn btn-dark">Utwórz</button>
</form>
