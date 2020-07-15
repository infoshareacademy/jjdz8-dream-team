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
    <link href="html_js_css_Jsp_files/styles.css" rel="stylesheet"/>
    <link href="html_js_css_Jsp_files/form.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="html_js_css_Jsp_files/menu-logIn.jsp"/>
<main>
    <div class="container">
        <div class="jumpotron"><h2>Aplikacja Internetowa Drem-Team</h2></div>
        <div class="carousel slide center" id="mycarousel" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#mycarousel" data-slide="0" class="active"></li>
                <li data-target="#mycarousel" data-slide="1"></li>
            </ol>
            <div class="carousel-inner img-fluid">
                <div class="item active img-fluid">
                    <img src="jpg/77522.jpg" alt="">
                    <!-- Opis slajdu -->
                    <div class="carousel-caption">
                        <h3>"KAŻDA PORAŻKA JEST SZANSĄ, ŻEBY SPRÓBOWAĆ JESZCZE RAZ.</h3>
                        <H2>TYLKO MĄDRZEJ."</H2>
                        <p>HENRY FORD</p>
                    </div>
                </div>
                <div class="item img-fluid">
                    <img src="jpg/pexels-1786955.jpg    " alt="">
                    <!-- Opis slajdu -->
                    <div class="carousel-caption">
                        <h3>"JESTLI JEST CIĘZKO, TO ZNACZY, ŻE IDZIESZ W DOBRYM KIERUNKU." </h3>
                    </div>
                </div>
                </a>
                <a class="right carousel-control" href="#mycarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Previous</span>
                </a>
            </div>
        </div>
    </div>
</main>
</footer>
<jsp:include page="html_js_css_Jsp_files/jsScripts.html"/>
</body>
<jsp:include page="html_js_css_Jsp_files/footer.jsp"/>
</html>