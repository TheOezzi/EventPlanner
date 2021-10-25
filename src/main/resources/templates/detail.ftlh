<!DOCTYPE html>
<html>
<head>
    <title>Konzert Planer</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../js/detail.js"></script>
</head>

<body>
<h2>Event Details</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <tbody>
        <tr>
            <td>Name:</td>
            <td><input type="text" value=${model.name}></td>
        </tr>
        <tr>
            <td>Ort:</td>
            <td><input type="text" value=${model.location}></td>
        </tr>
        <tr>
            <td>Datum:</td>
            <td><input type="datetime-local" value=${model.date}></td>
        </tr>
        <tr>
            <td>Teilnehmer:</td>
            <td><input type="text" value=${model.attendees}></td>
        </tr>
        <tr>
            <td onclick="deleteEvent(${model.id})">
                <img src="../../img/delete.png" height="20px">
            </td>
            <td>
                <img src="../../img/save.png" height="20px">
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>