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
<div >
    <img src="../../img/sglh.png" class="center">
    <h2>Konzert Details</h2>
</div>
<div class="table-wrapper">
    <table class="fl-table">
        <tbody>
        <tr>
            <td>Name:</td>
            <td><input type="text" id="edit-name" value="${model.name}"></td>
        </tr>
        <tr>
            <td>Ort:</td>
            <td><input type="text" id="edit-location" value="${model.location}"></td>
        </tr>
        <tr>
            <td>Datum:</td>
            <td><input type="datetime-local" id="edit-date" value="${model.date}"></td>
        </tr>
        <tr>
            <td>Teilnehmer:</td>
            <td><input type="text" id="edit-attendees" value="${model.attendees}"></td>
        </tr>
        <tr>
            <td onclick="deleteEvent(${model.id})">
                <img src="../../img/delete.png" height="20px">
            </td>
            <td onclick="editEvent(${model.id})">
                <img src="../../img/save.png" height="20px">
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>