<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Temperature</title>
    </head>
    <body>
        <h1>
            <%= "Calculate today`s temperature" %>
        </h1>
        <br/>
        <form action="temp" target="_blank">
            <input type="text" placeholder="City" name="city">
        </form>
    </body>
</html>