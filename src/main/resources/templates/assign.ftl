<html>
<head>
    <meta charset="utf-8">
    <title>Type</title>
</head>
<body>
<div>
    <h3>赋值和取值</h3>
    <#assign a = 100/>
    a = ${a}
    a + 100 = ${a+100}

    <h3>if语法</h3>
    <#assign value = 314/>
    <#if value == 315>
        var = 315
    <#else>
        var = 314
    </#if>
</div>
</body>
</html>