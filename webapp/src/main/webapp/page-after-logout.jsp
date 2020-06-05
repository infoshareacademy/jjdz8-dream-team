<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="E-learning web app"/>
    <br>
    <title>E-learning web app by Dream Team</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="menu-logIn.jsp"/>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="align-self-center">
                    <h3 class="display-5">you are safety logout. <br>
                        See you next Time</h3>
                </div>
            </div>
        </div>
    </main>
<footer class="container">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
<jsp:include page="jsScripts.html"/>
</body>
<jsp:include page="footer.jsp"/>
</html>
<%--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="E-learning web app" />
    <title>E-learning web app by Dream Team</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link href="styles.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="menu.html"/>
<jsp:include page="headerJambutron.html"/>
<main role="main">
    <div class="container">
        <div class="row">
            <div class="align-self-center">
                <h3 class="display-5">you are safety logout. <br>
                    See you next Time</h3>
            </div>
        </div>
    </div>
</main>
<footer class="container">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
<jsp:include page="jsScripts.html"/>

</body>
</html>
--%>
