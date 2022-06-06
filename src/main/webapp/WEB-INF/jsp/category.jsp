<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
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
<!-- 头部 -->
<jsp:include page="head.jsp"/>
<!--主区域-->
<div class="container" style="margin-top:25px;">
    <div class="row">
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/">首页</a></li>
                <c:forEach items="${itemCats}" var="item">
                    <c:if test="${item.cid == cid}">
                        <li class="active">${item.name}</li>
                    </c:if>
                </c:forEach>
            </ol>
        </div>
        <div class="col-md-12">
            <div class="row  text-center cat-item-list">
                <c:forEach items="${pageInfo.list}" var="item">
                    <div class="col-md-4">
                        <a href="${pageContext.request.contextPath}/item/showItem?id=${item.id}" class="thumbnail"> <img
                                class="img-responsive" src="${pageContext.request.contextPath}/upload/${item.image}"/>
                            <p class="item-name">${item.name}</p>
                            <p class="item-price"><strong>¥${item.shopPrice}</strong></p>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-8">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <c:if test="${pageInfo.prePage == 0}"><a href="${pageContext.request.contextPath}/item/queryPage?cid=${cid}&page=${pageInfo.navigateFirstPage}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></c:if>
                                <c:if test="${pageInfo.prePage != 0}"><a href="${pageContext.request.contextPath}/item/queryPage?cid=${cid}&page=${pageInfo.prePage}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></c:if>
                            </li>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                                <li <c:if test="${pageInfo.pageNum == i}">class="active"</c:if>><a
                                    href="${pageContext.request.contextPath}/item/queryPage?cid=${cid}&page=${i}">${i}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <c:if test="${pageInfo.nextPage == 0}"><a href="${pageContext.request.contextPath}/item/queryPage?cid=${cid}&page=${pageInfo.navigateLastPage}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></c:if>
                                <c:if test="${pageInfo.nextPage != 0}"><a href="${pageContext.request.contextPath}/item/queryPage?cid=${cid}&page=${pageInfo.nextPage}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></c:if>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<jsp:include page="foot.jsp"/>
</body>

</html>