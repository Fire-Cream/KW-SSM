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
    <style type="text/css">
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }

        input[type="number"] {
            -moz-appearance: textfield;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("#minus").click(function () {
                let num = $("#quantity").val();
                $("#quantity").val(num > 1 ? --num : 1);
            });
            $("#add").click(function () {
                let num = $("#quantity").val();
                $("#quantity").val(num <${item.num} ? ++num :${item.num});
            });
            $("#quantity").change(function () {
                let num = $("#quantity").val();
                if (num < 1) {
                    $("#quantity").val(1);
                } else if (num > ${item.num}) {
                    $("#quantity").val(${item.num});
                } else {
                    $("#quantity").val(num);
                }
            });
        });
    </script>
</head>
<body>
<!-- 头部 -->
<jsp:include page="head.jsp"/>
<!--主区域-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div class="row" style="margin-bottom: 10px;">
                <div class="col-md-5 col-xs-5">
                    <div>
                        <a href="#"><img class="img-responsive"
                                         src="${pageContext.request.contextPath}/upload/${item.image}"/></a>
                    </div>
                </div>
                <div class="col-md-7 col-xs-7 product-info">
                    <div>
                        <h3 class="pord-name">${item.name}</h3>
                    </div>
                    <div class="pord-price clearfix">
                        <span class="pord-dispri">￥<strong>${item.shopPrice}</strong></span>
                        <span class="pord-orpri">￥${item.marketPrice}</span>
                    </div>
                    <!--<div class="pord-detailbox clearfix">
                            <div class="pull-left pord-sold">已售：<span>1448</span></div>
                            <div class="pull-left pord-totalcom">累计评价：<span class="commentNum">48</span></div>
                        </div>-->
                    <div id="blk_detail_main_btn">
                        <form action="${pageContext.request.contextPath}/cart/add" method="post">
                            <input id="id" name="id" type="hidden" value="${item.id}">
                            <div class="mt10 pord-num clearfix">
                                <label class="pull-left pt10">数量</label>
                                <div class="pull-left ml42">
                                    <a id="minus" href="javascript:;"
                                       class="pull-left num-plus numbtn num-plus btn_detail_main_buy_min"><i
                                            class="ico-detail">-</i></a>
                                    <input id="quantity" name="quantity" type="number" size="2" maxlength="3"
                                           stock_num="728" limit_num="30"
                                           class="fl nummidbtn num inpt_detail_main_buy_num" value="1">
                                    <a id="add" href="javascript:;"
                                       class="pull-left numbtn num-minus btn_detail_main_buy_plus"><i
                                            class="ico-detail">+</i></a>
                                </div>
                                <span class="pord-stock">（库存：${item.num}）</span>
                            </div>
                            <div class="pord-btn clearfix">
                                <button type="submit" id="btn_detail_cart_add"
                                        class="fl joincart-btn">加入购物车
                                </button>
                                <button type="submit" id="btn_detail_cart_buy" class="fl ml30 buy-btn">立即购买</button>
                                <a href="javascript:;" class="fl btn-collect">
                                    <i class="ico-detail ico-collect"></i>
                                    <span>收藏</span>
                                </a>
                                <a href="javascript:;" class="fl btn-collected" style="display: none">
                                    <i class="ico-detail ico-collect"></i>
                                    <span>已收藏</span>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-xs-12">
                    <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
                        <ul id="myTabs" class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
                                   aria-expanded="true">商品介绍</a>
                            </li>
                            <li role="presentation">
                                <a href="#profile" role="tab" id="profile-tab" data-toggle="tab"
                                   aria-controls="profile">商品评论</a>
                            </li>
                        </ul>
                        <div id="myTabContent" class="tab-content ">
                            <div role="tabpanel" class="tab-pane fade in active" id="home"
                                 aria-labelledby="home-tab">
                                <img class="img-responsive center-block"
                                     src="${pageContext.request.contextPath}/upload/${item.idesc}"/>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
                                <div class="media">
                                    <div class="media-body">
                                        <h4 class="media-heading">王大炮：</h4>
                                        非常不错啊！！！
                                    </div>
                                </div>
                                <div class="media">
                                    <div class="media-body">
                                        <h4 class="media-heading">王中炮：</h4>
                                        非常不错啊！！！
                                    </div>
                                </div>
                                <div class="media">
                                    <div class="media-body">
                                        <h4 class="media-heading">王小炮：</h4>
                                        非常不错啊！！！
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<jsp:include page="foot.jsp"/>
</body>

</html>