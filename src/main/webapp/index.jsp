<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                //alert("button click");
                $.ajax({
                    //url:"returnVoid-ajax.do",
                    //url:"/returnStudentJson.do",
                    //url:"returnStudentJsonArray.do",
                    url:"returnStringData.do",
                    data:{
                        name:"张三",
                        age:20
                    },
                    type:"post",
                    dataType:"text",
                    //dataType:"json",
                    success:function (resp) {
                        //alert(resp.name+"   ===   "+resp.age);

                        // $.each(resp , function (i , n) {
                        //     alert(n.name + "======" + n.age);
                        // })

                        alert("返回的是文本数据："+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
<br/>
<button id="btn">发起ajax请求</button>
</body>
</html>
