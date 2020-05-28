<html>
<head><title>Ocen nauczyciela</title>

<body>
<form name="user" action="/user2" method="post">
    name: <input type="text" name="name" />	<br/>
   grade: <input type="number" name="grade" />		<br/>
    <input type="submit" value="Save" />
</form>

<table class="datatable">
    <tr>
        <th>name</th>  <th>grade</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.name}</td> <td>${user.grade}</td>
        </tr>
    </#list>
</table>
</body>
</html>