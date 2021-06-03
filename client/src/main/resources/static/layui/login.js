
function findAllDepts() {
    $.ajax({
        async : false,    //表示请求是否异步处理
        type : "post",    //请求类型
        url : "/user/findAll",//请求的 URL地址
        dataType : "json",//返回的数据类型
        success: function (data) {
            console.log(data);  //在控制台打印服务器端返回的数据
            for(var i=0;i<data.length;i++){
                console.log(data[i].deptId+" "+data[i].deptName);
            }
            $("select[name='depertmentId']").empty();
            $("select[name='depertmentId']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].deptId+'">';
                html +=data[i].deptName + '</option>';
                $("select[name='departmentId']").append(html);  //将数据显示在html页面
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
};

$(document).ready(function () {
    findAllDepts();  //页面加载完成就执行该方法
});