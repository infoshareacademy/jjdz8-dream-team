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
        <link href="styles.css" rel="stylesheet" />
        <link href="form.css" rel="stylesheet" />
    </head>

    <body>
    <jsp:include page="menu.jsp"/>

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
            <div>
                <div>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus.
                    </p>
                    <a href="tel:111222333">
                        Call us
                    </a>
                </div>
                <div>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus.
                    </p>
                    <a href="mailto:some@email.com">
                        Write email
                    </a>
                </div>
                <div>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus.
                    </p>
                    <a href="https://facebook.com/company"> Facebook</a>
                </div>
            </div>
        </main>
    <footer class="container">
        <p>E-learning web app - all rights reserved;-)</p>
    </footer>
    </body>
</html>