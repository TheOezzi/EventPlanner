<!DOCTYPE html>
<html>
<head>
    <title>Konzert Planer</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../js/list.js"></script>
</head>

<body>
<h2>SGLH Konzert Planer</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Ort</th>
            <th>Datum</th>
            <th>Teilnehmer</th>
        </tr>
        </thead>
        <tbody>
        <tr onclick="createNewEvent()">
            <td colspan="4">Neues Event erstellen</td>
        </tr>
        <#list model.events as event>
            <tr onclick="showDetails(${event.id})">
                <td>${event.name}</td>
                <td>${event.location}</td>
                <td>${event.date}</td>
                <td>${event.attendees}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>

</html>