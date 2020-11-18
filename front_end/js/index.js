$(document).ready(function () {
    //获取邮箱列表
    $.ajax({
        type: "post",
        url: "http://localhost:8080/api/mail/list",
        success: function (response) {
            console.log("response:" + response);
            //parseJSON:将符合标准格式的的JSON字符串转为与之对应的JavaScript对象。
            // result = $.parseJSON(response.data);
            result = JSON.stringify(response.data);
            console.log("result:" + result);
            str = "";
            if (response.data == null) {
                str += "<tr>";
                str += "<td>There is no user;</td>";
                str += "</tr>";
            } else {
                $.each(response.data, function (i, item) {
                    var userMailList = item.userMailList;
                    // console.log("userMailList:"+userMailList);
                    // console.log("userMailList.mailName:"+userMailList[0].mailName);
                    for (var j = 0; j < userMailList.length; j++) {
                        var e = userMailList[j].id;
                        str += "<tr>";
                        str += "<td>" + item.username + "</td>";
                        str += "<td>" + item.password + "</td>";
                        str += "<td>" + userMailList[j].mailName + "</td>";
                        if (userMailList[j].isUsed == "1") {
                            str += "<td>正常</td>";
                        } else {
                            str += "<td>已注销</td>";
                        }
                        console.log("#####" + e);

                        // var idd = JSON.stringify(e);
                        // console.log(idd);
                        // var mailId=parseInt(e);
                        //TODO 为什么下面这样写 没有参数传过去
                        // str += "<td><a href='pages/update.html?id='"+ mailId +"'>修改</a></td>";
                        str += "<td><a href='#' onclick='updateMail(" + e + ")'>修改</a></td>";
                        str += "<td><a href='#' onclick='deleteMail(" + e + ")'>删除</a></td>";
                        // console.log("*********"+userMailList[j].id);
                        str += "</tr>";
                    }
                    // userMailList = JSON.stringify(item.userMailList);
                });
            }
            $('#mail_list').html(str);
        }
    });

    //添加按钮
    $("#add").click(function () {
        window.location.href = "pages/add.html";
    });

    updateMail = function (e) {
        var mailId = parseInt(e);
        window.location.href = "pages/update.html?id=" + mailId;
    }
    //注销
    deleteMail = function (e) {
        var mailId = parseInt(e);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/api/mail/delete?mail_id=" + mailId,
            dataType: "json",
            data: JSON.stringify(e),
            contentType: "application/json;charset=utf-8",
            success: function (response) {
                alert(response.data);
                window.location.href = "index.html";
            }
        });
    }


    //模糊查询按钮
    $("#search").click(function () {
        var mail_name = $("#selectMail").val();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/api/mail/select?mail_name=" + mail_name,
            dataType: "json",
            data: JSON.stringify(mail_name),
            contentType: "application/json;charset=utf-8",
            success: function (response) {
                console.log("response:" + response);
                //parseJSON:将符合标准格式的的JSON字符串转为与之对应的JavaScript对象。
                // result = $.parseJSON(response.data);
                result = JSON.stringify(response.data);
                console.log("查询返回结果 result:" + result);
                str = "";
                if (response.data == "") {
                    str += "<tr>";
                    str += "<td colspan='6'>There is no user</td>";
                    str += "</tr>";
                } else {
                    $.each(response.data, function (i, item) {
                        var userMailList = item.userMailList;
                        // console.log("userMailList:"+userMailList);
                        // console.log("userMailList.mailName:"+userMailList[0].mailName);
                        for (var j = 0; j < userMailList.length; j++) {
                            var e = userMailList[j].id;
                            str += "<tr>";
                            str += "<td>" + item.username + "</td>";
                            str += "<td>" + item.password + "</td>";
                            str += "<td>" + userMailList[j].mailName + "</td>";
                            if (userMailList[j].isUsed == "1") {
                                str += "<td>正常</td>";
                            } else {
                                str += "<td>已注销</td>";
                            }
                            console.log("#####" + e);

                            // var idd = JSON.stringify(e);
                            // console.log(idd);
                            // var mailId=parseInt(e);
                            //TODO 为什么下面这样写 没有参数传过去
                            // str += "<td><a href='pages/update.html?id='"+ mailId +"'>修改</a></td>";
                            str += "<td><a href='#' onclick='updateMail(" + e + ")'>修改</a></td>";
                            str += "<td><a href='#' onclick='deleteMail(" + e + ")'>删除</a></td>";
                            // console.log("*********"+userMailList[j].id);
                            str += "</tr>";
                        }
                        // userMailList = JSON.stringify(item.userMailList);
                    });
                }
                $('#mail_list').html(str);
            }
        });
    });
});