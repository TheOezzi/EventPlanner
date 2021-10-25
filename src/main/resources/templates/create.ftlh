<!DOCTYPE html>
<html>
<head>
    <title>Konzert Planer</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../js/create.js"></script>
</head>

<body>
<h2>Konzert Details</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <tbody>
        <tr>
            <td>Name:</td>
            <td><input type="text" id="name"/></td>
        </tr>
        <tr>
            <td>Ort:</td>
            <td><input type="text" id="location"/></td>
        </tr>
        <tr>
            <td>Datum:</td>
            <td><input type="datetime-local" id="date"/></td>
        </tr>
        <tr>
            <td>Teilnehmer:</td>
            <td><input type="text" id="attendees"/></td>
        </tr>
        <tr onclick="createNew()">
            <td colspan="2"><img src="../../img/save.png" height="20px"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>