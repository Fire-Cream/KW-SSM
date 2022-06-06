<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>酷玩周边商城-订单列表</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css"/>
    <!-- 引入jQuery核心js文件 -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
<jsp:include page="head.jsp"/>
<div class="container" style="margin-top: 20px;">
    <c:if test="${empty orders}">
        <div class='jumbotron'><p class='text-center'>您还没有购买过任何东西,
            <a href='${pageContext.request.contextPath}/' target='_Self'> 去逛逛吧</a></p>
        </div>
    </c:if>
    <c:forEach items="${orders}" var="order">
        <div class="panel panel-default" style="margin-top: 15px">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="col-md-10" style="text-decoration: none;margin-right: 25px;" data-toggle="collapse" data-parent="#accordion" href="#${order.oid}">
                        订单号:${order.oid} (点击查看详细信息)<br>
                        <span style="font-size: 15px;color: green;"><fmt:formatDate value="${order.orderTime}" pattern="yyyy年MM月dd日 HH小时mm分ss秒"></fmt:formatDate></span>
                    </a>
                    <c:if test="${order.state == 2}"><button type="button" class="btn btn-success">已支付</button></c:if>
                    <form action="${pageContext.request.contextPath}/order/toPay">
                        <input type="hidden" name="oid" value="${order.oid}">
                        <input type="hidden" name="address" value="${order.address}">
                        <input type="hidden" name="name" value="${order.name}">
                        <input type="hidden" name="telephone" value="${order.telephone}">
                        <c:if test="${order.state == 1}"><button type="submit" class="btn btn-warning">未支付</button></c:if>
                    </form>
                </h4>
            </div>
            <div id="${order.oid}" class="panel-collapse collapse">
                <div class="panel-body">
                    <div class="list-group-item">
                        <table class="table table-condensed" style="margin-bottom: 0;">
                            <thead>
                            <tr>
                                <th>图片</th>
                                <th>商品</th>
                                <th>单价(元)</th>
                                <th>数量</th>
                                <th>小计</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${order.orderItems}" var="orderItem">
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/upload/${orderItem.item.image}" class="buyimg" /></td>
                                    <td>${orderItem.item.name}</td>
                                    <td>¥${orderItem.item.shopPrice}</td>
                                    <td>${orderItem.count}</td>
                                    <td>${orderItem.subtotal}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="text-right list-group-item" style="margin-bottom: 10px;">
                        <address>
                            收货人：${order.name}<br/>
                            电话：${order.telephone}<br/>
                            地址：${order.address}
                        </address>
                        商品金额：<span class="xiangq_font3">¥${order.total}元</span>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
<!--底部-->
<jsp:include page="foot.jsp"/>
</body>

</html>
