<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<main>
    <body>
    <h2>Formularz kontaktowy</h2>
    <div id="send_form_status"></div>
    <form method="post" action="/send_form.php" id="contact_form">
        <div><label for="name">Imię i nazwisko</label></div>
        <div><input type="text" name="name" id="name" class="formField" /></div>
        <div><label for="phone">Numer telefonu</label></div>
        <div><input type="text" name="phone" id="phone" class="formField" /></div>
        <div><label for="email">Adres email</label></div>
        <div><input type="text" name="email" id="email" class="formField" /></div>
        <div><label for="message">Treść wiadomości</label></div>
        <div><textarea name="message" id="message" class="formField"></textarea></div>
        <div><button id="sendBtn">Wyślij</button></div>
    </form>
</main>