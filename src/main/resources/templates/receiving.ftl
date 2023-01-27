<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/static/styles/receivingStyle.css" media="screen">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
<#--    <script src="/static/scripts/main.js"></script>-->
    <title>Document</title>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="/">
                    GalaxyWMS
                </a>
            </li>
            <li>
                <a href="/receiving">Приход</a>
            </li>
            <li>
                <a href="#">Расход</a>
            </li>
            <li>
                <a href="#">Overview</a>
            </li>
            <li>
                <a href="#">Events</a>
            </li>
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="#">Services</a>
            </li>
            <li>
                <a href="javascript: document.logoutForm.submit()" role="menuitem">Выйти</a>
                <form name="logoutForm" action="/logout" method="post" type="hidden">
                    <input type="hidden" value="Выход"/>
                </form>
            </li>
        </ul>
    </div>
</div>
<!-- /#sidebar-wrapper -->

</body>
</html>