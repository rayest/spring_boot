<!
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Freemarker</title>
</head>
<body>
<div>
    <h3>排序</h3>
    <#assign myList = [1,9,2,8,5,0,3,7,6,4]/>
    <#list myList as item>
        ${item}
    </#list>
    <br>
    <#list sort_int(myList, false) as item>
        ${item}
    </#list>
</div>
</body>
</html>