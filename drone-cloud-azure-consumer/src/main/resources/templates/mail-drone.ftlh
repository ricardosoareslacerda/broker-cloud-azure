<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fiap - Drone Alert</title>
    <style>
            body{
                 font-family: verdana;
            }

            table {
                width: 500px;

            }

            table, th, td {
                border: 1px solid black;
                padding: 2px;
            }

            th{
                background-color: #00439A;
                color : #FFFFFF;
                text-align: right;
            }

            tr{
                background-color: #CFCFCF;
            }
        </style>
</head>
<body>
<h1>Drone Alert Information</h1>
<div>
    <table>
        <tr>
            <th>ID:</th>
            <td >${drone.id}</td>
        </tr>
        <tr>
            <th>Nome:</th>
            <td>${drone.name}</td>
        </tr>
        <tr>
            <th>Latitude:</th>
            <td>${drone.latitude}</td>
        </tr>
        <tr>
            <th>Longitude:</th>
            <td>${drone.longitude}</td>
        </tr>
        <tr>
            <th>Tempetura:</th>
            <td>${drone.temperature}</td>
        </tr>
        <tr>
            <th>Umidade:</th>
            <td>${drone.humidity}</td>
        </tr>
        <tr>
            <th>Rastreabilidade:</th>
            <td>${drone.rastreability?c}</td>
        </tr>
        <tr>
            <th>Data/Hora:</th>
            <td>${drone.lastUpdate?string('dd.MM.yyyy HH:mm:ss')}</td>
        </tr>
    </table>
</div>
</body>
</html>