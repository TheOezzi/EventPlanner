<!DOCTYPE html>
<html>
<head>
    <title>Konzert Planer</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="../../img/sglh.png">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../js/create.js"></script>
</head>

<body>
<div >
    <img src="../../img/sglh.png" class="center">
    <h2>Neues Konzert erstellen</h2>
</div>
<div class="table-wrapper">
    <table class="fl-table">
        <tbody>
        <tr>
            <td>Name:</td>
            <td><input type="text" id="create-name"/></td>
        </tr>
        <tr>
            <td>Ort:</td>
            <td><input type="text" id="create-location"/></td>
        </tr>
        <tr>
            <td>Datum:</td>
            <td><input type="datetime-local" id="create-date"/></td>
        </tr>
        <tr>
            <td>Teilnehmer:</td>
            <td><input type="text" id="create-attendees"/></td>
        </tr>
        <tr>
            <td colspan="2"><button class="btn btn-1 btn-sep icon-save" onclick="createNew()">Speichern</button></td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>