<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="E-learning web app" />
    <br>
    <title>E-learning web app by Dream Team</title>

    <link href="styles.css" rel="stylesheet" />
    <link href="form.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="menu.jsp"/>

<form action="mailto:twój_adres_poczty@domena" method="post" enctype="text/plain">
    <div class="form">

        <label for="nickname">Nickname:</label>
        <input type="text" name="name" id="nickname" required/>

        <label for="Name">Give your name:</label>
        <input type="text" name="name" id="name" required/>

        <label for="surname">Enter your surname:</label>
        <input type="text" name="surname" id="surname" required/>

        <!-- Pole typu RADIO -->
        <p>Podaj swoją płeć:</p>
        <input type="radio" name="Płeć" value="Kobieta">Kobieta
        <input type="radio" name="Płeć" value="Mężczyzna">Mężczyzna
        <!-- Pole typu RADIO -->
        <p>Ile masz lat?</p>
        <input type="radio" name="Wiek" value="mniej niż 15">mniej niż 15<br>
        <input type="radio" name="Wiek" value="15-19">15-19<br>
        <input type="radio" name="Wiek" value="20-29">20-29<br>
        <input type="radio" name="Wiek" value="30-39">30-39<br>
        <input type="radio" name="Wiek" value="40-60">40-60<br>
        <input type="radio" name="Wiek" value="więcej niż 60">więcej niż 60
        <!-- Pole typu CHECKBOX -->
        <p>Jakie przedmioty lubisz najbardziej(możesz zaznaczyć więcej możliwości)?</p>
        <input type="checkbox" name="Jezyk" value="Polski">Polski<br>
        <input type="checkbox" name="Jezyk" value="Angielski">Anigielski<br>
        <input type="checkbox" name="Nauki Scisle" value="Fizyka">Fizyka<br>
        <input type="checkbox" name="Nauki Scisle" value="Mechatronika">Mechtronika<br>
        <input type="checkbox" name="Nauki Scisle" value="Matematyka">Matematyka<br>
        <input type="checkbox" name="Nauka" value="Inna">Inna (podaj jaka):
        <input name="Muzyka">
        <!-- Lista rozwijalna (typ podstawowy) z zaznaczoną opcją domyślną -->
        <p>Jakiej przeglądarki internetowej używasz?</p>
        <select name="Przeglądarka">
        <option selected>Internet Explorer</option>
        <option>Netscape</option>
        <option>Opera</option>
        <option>Mozilla</option>
        <option>Inna</option>
    </select>
        <!-- Lista rozwijalna (typ rozszerzony) z zaznaczoną opcją domyślną i zmniejszoną wysokością -->
        <p>Jakie znasz systemy operacyjne (możesz wybrać kilka opcji trzymając klawisz Ctrl)?</p>
        <select name="System operacyjny" multiple size="3">
        <option selected>Dos</option>
        <option>Windows</option>
        <option>Linux</option>
        <option>Inny</option>
    </select>
        <!-- Pole komentarza (o powiększonych rozmiarach oraz z tekstem domyślnym) -->
        <p>Podaj swój komentarz:</p>
        <textarea name="Komentarz" cols="50" rows="10">Proszę, wpisz tutaj jakiś komentarz...</textarea>
        <br><br><br>
        <!-- Przycisk WYŚLIJ -->
        <input type="submit" value="Wyślij formularz">
        <!-- Przycisk WYCZYŚĆ DANE -->
        <input type="reset" value="Wyczyść dane">
    </div>
</form>
</body>
</html>
