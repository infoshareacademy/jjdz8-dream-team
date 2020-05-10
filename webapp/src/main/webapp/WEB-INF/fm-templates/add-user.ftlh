<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
            name="description"
            content="Add user: teacher or student"
    />
    <title>Add-user</title>
    <#include "style.ftlh">
</head>

<body>
<#include "menu.ftlh">
<header>
    <h1>Add an user</h1>
    <p>
        Use bellow form.
    </p>
</header>
<main>
    <form method="post" action="/user" class="contact-from">
        <div class="form">
            <label for="nickname">Nickname:</label>
            <input type="text" name="name" id="nickname" required />
        </div>
        <div class="form">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required />
        </div>
        <div class="form">
            <label for="services">User type:</label>
            <select id="services">
                <option value="teacher">Teacher</option>
                <option value="student">Student</option>
            </select>
        </div>
        <div class="form">
            <label for="description">Massage:</label>
            <textarea name="description"></textarea>
        </div>
        <div class="form">
            <button type="submit">
                Create account
            </button>
        </div>
    </form>
                <a href="https://facebook.com/company"> Facebook</a>
        </div>
    </div>
</main>
<#include "footer.ftlh">
<#include "js.ftlh">
</body>
</html>