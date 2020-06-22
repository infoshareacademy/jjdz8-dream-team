<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="pl">

<form method="post" action="/user" class="contact">
    <div class="form col-md-6">
        <label for="nickname">Nickname:</label>
        <input type="text" name="name" id="nickname" required/>
    </div>
    <div class="form col-md-6">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required/>
    </div>
    </div>
    <div class="form">
        <label for="description">Massage:</label>
        <textarea name="description"></textarea>
    </div>
    <div class="form">
        <button type="submit  " class="btn btn-dark">Send</button>
    </div>
</form>