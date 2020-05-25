<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="E-learning web app"/>


    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
    <link href="logout.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<main>

    <!------ Include the above in your HEAD tag ---------->

    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->

            <form>
                <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
                <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>

            <!-- Remind Passowrd -->
            <div id="formFooter">
                <a class="underlineHover" href="#">Forgot Password?</a>
            </div>

        </div>
    </div>
    </form>
</main>
<footer class="container">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
