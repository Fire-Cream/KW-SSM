<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>酷玩周边商城-商品列表</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css"/>
    <!-- 引入jQuery核心js文件 -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container-fluid"
     style="height:460px;background: url('${pageContext.request.contextPath}/img/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
        </div>
        <div class="col-md-5">
            <div class="panel panel-default" style="width: 400px; margin-top: 50px;">
                <div class="panel-heading">
                    <h3 class="panel-title">用户登录</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/login" method="post">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                    ${error}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="username" class="col-sm-3 control-label">用户名:</label>
                            <div class="col-sm-7">
                                <input type="text" name="username" class="form-control" id="username"
                                       placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">密码:</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="请输入密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="captcha" class="col-sm-3 control-label">验证码:</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="captcha" id="captcha"
                                       placeholder="请输入验证码">
                            </div>
                            <div class="col-sm-4" style="padding: 0;">
                                <img id="showCode" width="100" height="34" onclick="changeCode()"
                                     src="${pageContext.request.contextPath}/HappyCaptcha"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <div class="checkbox">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" value="true"/>记住用户名
                                        <a href="${pageContext.request.contextPath}/register">注册新用户</a>
                                    </label>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-7">
                                <input class="btn btn-success  btn-block" type="submit" value="登录" name="submit"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="foot.jsp"/>
</html>
