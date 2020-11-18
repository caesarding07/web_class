$(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })
//添加按钮
$("#addBtn").click(function () { 
    var isActive=0;
    var flag=true; //判断数据是否合理
    console.log($("#addInfor").serialize()+" dd:"+$("input[type='checkbox']").is(':checked')); 
    console.log($("#addInfor [name='isActive']").is(":checked"));
    if($("#addInfor [name='isActive']").is(":checked")){
        isActive=1;
    }
    var mail=$("#addInfor [name='mail_name']").val();
    var user_id=$("#addInfor [name='user_id']").val();
    if(mail.indexOf("@")==-1||typeof mail=="undefined"||mail==null||mail==""){
        flag=false;
        console.log("error");
         $('#mail_name').tooltip('show');
        $('.modal-body').text("添加失败");
    }
    if(typeof user_id=="undefined"||user_id==null||user_id==""||isNaN(user_id)){
        $('#user_id').tooltip('show');
        $('.modal-body').text("添加失败");
        flag=false;
    }
    if(flag){
        var data={
            id:2,
            mail_name:$("#addInfor [name='mail_name']").val(),
            user_id:parseInt($("#addInfor [name='user_id']").val()),
            is_used:isActive
        };
        console.log(JSON.stringify(data));
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/api/student/addMail",
            dataType:"json",
            data: JSON.stringify(data),
            success: function (response) {
                console.log(response.data);
                $('.modal-body').text("添加成功");
                $("#myModal").show();
               // alert("添加成功");
            }
        });
    }
    
});
//返回按钮
$("#returnBtn").click(function(){
    window.location.href="../index.html";//返回主页
});
