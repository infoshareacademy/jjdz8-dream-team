<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta
            name="description"
            content="Search subject or teacher"
    />
    <title>Add-user</title>
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
    <link href="search.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="menu.jsp"/>

<main>

    <div class="input-group col-md-5">
        <div class="input-group-prepend">
            <div class="input-group-text">
                <input type="checkbox" aria-label="Checkbox przy polu tekstowym">
            </div>
        </div>
        <input type="text" class="form-control" aria-label=Wyszukaj po nazwisku nauczyciela"
               placeholder="Wyszukaj po nazwisku nauczyciela">
    </div>
    <div class="input-group col-md-5">
        <div class="input-group-prepend">
            <div class="input-group-text">
                <input type="checkbox" aria-label="szukaj przedniotu">
            </div>
        </div>
        <input type="text" class="form-control" aria-label="Pole tekstowe z checkboxem"
               placeholder="szukaj wg przedniotu">
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="Check1">
        <label class="form-check-label" for="Check1">
            Materiał wideo
        </label>
    </div>
    <button type="submit  " class="btn btn-dark">Szukaj</button>
</main>
<footer class="container">
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
</body>
</html>