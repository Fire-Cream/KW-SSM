<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>酷玩周边商城-订单支付</title>
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
    <div class="list-group">
        <h3 class="list-group-item-heading">生成订单成功,订单号：${order.oid}</h3>
        <div class="list-group-item">
            <table class="table table-condensed">
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
                <c:forEach items="${order.orderItems}" var="entry">
                    <tr>
                        <td class="col-md-2"><img src="${pageContext.request.contextPath}/upload/${entry.item.image}"
                                                  class="buyimg"/></td>
                        <td class="col-md-5">${entry.item.name}</td>
                        <td class="col-md-2">¥${entry.item.shopPrice}</td>
                        <td class="col-md-1">${entry.count}</td>
                        <td class="col-md-2">¥${entry.subtotal}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="text-right list-group-item" style="margin-bottom: 10px;">
            商品金额：<span class="xiangq_font3">¥${order.total}元</span>
        </div>
        <form accept-charset="UTF-8" onsubmit="document.charset='UTF-8'" class="form-horizontal list-group-item"
              action="${pageContext.request.contextPath}/order/pay" method="post">
            <input type="hidden" name="WIDout_trade_no" value="${order.oid}">
            <h3 class="list-group-item-heading">配送至:</h3>
            <div class="form-group">
                <label for="address" class="col-sm-1 control-label">收货地址:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="address" name="address">
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-1 control-label">收货人:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="name" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="username" class="col-sm-1 control-label">联系方式:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="telephone" name="telephone">
                </div>
            </div>
            <div class="form-group">
                <label for="username" class="col-sm-1 control-label">支付方式:</label>
                <div class="col-md-3 ">
                    <input type="submit" class="btn btn-success btn-lg" value="支付宝支付">
                </div>
            </div>
        </form>
    </div>
</div>
<!--底部-->
<jsp:include page="foot.jsp"/>
</body>

</html>
