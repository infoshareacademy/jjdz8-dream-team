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

    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="menu.jsp"/>
<main role="main">
    <div class="container">
        <div class="row">

        </div>

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block col-md-10 rounded mx-auto" src="jpg/77522.jpg" alt="First slide">
                    <div class="carousel-caption">
                        <h3>"KAŻDA PORAŻKA JEST SZANSĄ, ŻEBY SPRÓBOWAĆ JESZCZE RAZ.</h3>
                        <H2>TYLKO MĄDRZEJ."</H2>
                        <p>HENRY FORD</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block col-md-10 rounded mx-auto" src="jpg/pexels-1786955.jpg" alt="Second slide">
                    <div class="carousel-caption">
                        <h3>"JESTLI JEST CIĘZKO, TO ZNACZY, ŻE IDZIESZ W DOBRYM KIERUNKU." </h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block  col-md-8 rounded mx-auto" src="jpg/minion.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>

</html>