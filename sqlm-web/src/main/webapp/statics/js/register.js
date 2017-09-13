/**
 * 用户注册脚本
 * Created by Yampery on 2017/9/11.
 */

$("#showTooltips").click(function() {
    var username = $('#username').val();
    var password = $('#password').val();
    var repwd = $('#repwd').val();
    var mobile = $('#mobile').val();
    // var code = $('#code').val();
    if (!username) $.toptip("请输入用户名");
    else if (!password) $.toptip("请输入密码");
    else if (!repwd) $.toptip("请确认密码");
    else if (!(repwd == password)) $.toptip("两次输入密码不一致");
    else if(!mobile || !/1[3|4|5|7|8]\d{9}/.test(mobile)) $.toptip('请输入手机号');
    // else if(!code || !/\d{6}/.test(code)) $.toptip('请输入六位手机验证码');
    else {

        $.toptip('提交成功', 'success');
    }
});