<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta
            name="description"
            content="Contact"
    />
    <title>Add-user</title>
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="menu.jsp"/>
<header>

</header>
<main>
    <div class="contact-from">
        <h1>Contact</h1>
        <p>
            Use bellow form.
        </p>
    </div>
    <form method="post" action="/user" class="contact-from">
        <div class="form">
            <label for="nickname">Nickname:</label>
            <input type="text" name="name" id="nickname" required/>
        </div>
        <div class="form">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required/>
        </div>

        </div>
        <div class="form">
            <label for="description">Massage:</label>
            <textarea name="description"></textarea>
        </div>
        <div class="form">
            <button type="submit">
                Send
            </button>
        </div>
    </form>
</main>
<footer class="container">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
</body>
</html>