<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link href="styles.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="menu.html"/>
<jsp:include page="headerJambutron.html"/>
<div class="mainContainer">
    <h1><strong>Hello user please login </strong></h1>
    <form method="post" action="http://localhost:8080/teacher">
        NickName: <input type="text" name="nickName"/><br/><br/>
        <input type="submit" name="login" value="login as teacher"/><br/><br/>
    </form>
</div>
<footer class="footer">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
<jsp:include page="jsScripts.html"/>

</body>

</html>