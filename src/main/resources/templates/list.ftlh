<!DOCTYPE html>
<html>
<head>
    <title>Konzert Planer</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../js/list.js"></script>
</head>

<body>
<div >
    <img src="./../img/sglh.png" class="center">
    <h2>SGLH Konzert Planer</h2>
</div>
<div>
    <button class="btn btn-3 btn-sep icon-add" onclick="createNewEvent()">Event erstellen</button>
</div>
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