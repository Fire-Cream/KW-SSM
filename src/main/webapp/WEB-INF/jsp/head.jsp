<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <script>
        $(document).ready(function () {
            $.post("/cat/list",
                function (data) {
                    var $ul = $(".wz-nav");
                    var str = "";
                    for (var i in data) {
                        str += '<li><a href="${pageContext.request.contextPath}/item/queryPage?cid=' + data[i].cid + '&page=1">' + data[i].name + '</a></li>'
                    }
                    $ul.html(str);
                });

            $("#btn-search").click(function () {
                //获取关键字
                let keyword = $.trim($("#keyword").val());
                console.log(keyword + ":" + keyword.length);
                //有关键字才请求
                if (keyword.length > 0) {
                    location.href = "${pageContext.request.contextPath}/item/search?name=" + keyword + "&page=1";
                }
            });

            function search() {
                //获取URL
                let str = location.search;
                //获取截取区间
                let index1 = str.indexOf("?");
                let index2 = str.indexOf("&");
                //截取
                let strs = str.substring(index1 + 1, index2);
                //数组化
                let name = strs.split("=");
                //回显
                if (name[0] == "name") {
                    $("#keyword").val(decodeURI(name[1]));
                }
            }

            search();
        });
    </script>
</head>
<!-- 头部 -->
<header>
    <div class="container-fluid wz-notice">
        <div class="container">
            <li class="icon-notice"></li>
            <span>酷玩周边商城手办热销中！，点击 <a href="#">查看详情></a> </span>
        </div>
    </div>
    <nav class="container-fluid wz-info">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-6">
                    <a class="icon-wzry pull-left" href="#">王者荣耀</a>
                    <div class="fl ico-comm i-solgan">可以触摸的欢乐时光</div>
                </div>
                <div class="col-md-4 hidden-xs">
                    <div class="search-box">
                        <input id="keyword" type="text" class="pull-left" placeholder="请输入想要找的宝贝"/>
                        <button id="btn-search" type="button" class="pull-left">搜索</button>
                    </div>
                </div>
                <div class="col-md-4 col-xs-6" style="margin-top: 40px;">
                    <ul class="list-inline text-right ">
                        <c:if test="${user == null}">
                            <li>
                                <a class="font1" href="${pageContext.request.contextPath}/login"><span
                                        class="glyphicon glyphicon-user"
                                        aria-hidden="true"></span>&nbsp;登录</a>
                            </li>
                        </c:if>
                        <c:if test="${user != null}">
                            <li class="dropdown">
                                <span data-toggle="dropdown" class="font1" href="javascript:void(0);"> 欢迎您：${user.name} <span
                                        class="caret"></span></span>
                                <ul class="dropdown-menu">
                                    <li><a href="${pageContext.request.contextPath}/order/showOrder?uid=${user.uid}"><span class="glyphicon glyphicon-list-alt"></span> 订单管理</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${pageContext.request.contextPath}/user/exit"><span
                                            class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li>
                            <a class="font1" href="${pageContext.request.contextPath}/cart/cart"><span
                                    class="glyphicon glyphicon-shopping-cart"></span>&nbsp;购物车</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <!--导航条-->
    <nav class="navbar navbar-inverse ">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">商城首页</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class=" nav navbar-nav wz-nav font2">
                    <c:forEach items="${itemCats}" var="itemCat">
                        <li>
                            <a href="">${itemCat.name}</a>
                        </li>
                    </c:forEach>
                </ul>
                <form class="hidden-md  hidden-lg navbar-right " role="search">
                    <div class="  form-group">
                        <input type="text" class="form-control" placeholder="请搜索商品..">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</header>

