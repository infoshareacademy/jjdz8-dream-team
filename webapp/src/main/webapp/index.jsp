
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
                <div class="col-12">
                    <h3 class="display-5">Nasze usługi</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <h3>Sesje</h3>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus. Etiam porta sem malesuada
                        magna mollis euismod. Donec sed odio dui.
                    </p>
                </div>
                <div class="col-md-4">
                    <h3>Druk</h3>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus. Etiam porta sem malesuada
                        magna mollis euismod. Donec sed odio dui.
                    </p>
                </div>
                <div class="col-md-4">
                    <h3>Wydarzenia</h3>
                    <p>
                        Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
                        egestas eget quam. Vestibulum id ligula porta felis euismod
                        semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                        condimentum nibh, ut fermentum massa justo sit amet risus.
                    </p>
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
