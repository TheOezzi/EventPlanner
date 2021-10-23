<!DOCTYPE html>
<html>
<head>
    <title>Konzertplaner</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <#list model.events as event>
                    <tr>
                        <td>${event.name}</td>
                        <td>${event.location}</td>
                        <td>${event.date?datetime?string('dd-MM-yyyy')}</td>
                        <td>${event.attendees}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>

</html>