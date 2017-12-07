<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Title</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <form method="post" action="/product/add">
            <div class="form-group">
                <label>添加</label>
                <input type="text" class="form-control" name="nodeName">
            </div>
            <button class="btn btn-success">添加</button>
        </form>
    </div>
    <br>

    <div class="container">
        <div class="panel panel-default">
            <div class="panel-body">
                <form action="/product" class="form-inline">
                    <input type="text" placeholder="商品名称" name="q_productName_like_s"  class="form-control">
                    <input type="text" placeholder="价格 或 市场价格" name="q_price_eq_bd" class="form-control">
                    <button class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>
    </div>



    <div class="container">
         <table class="table">
             <thead>
             <tr>
                 <th>商品名称</th>
                 <th>价格</th>
                 <th>市场价</th>
                 <th>产地</th>
                 <th>评论数量</th>
             </tr>
             </thead>
             <tbody>
             <c:forEach items="${page.item}" var="product">
             <tr>
                 <th>${product.productName}</th>
                 <th>${product.price}</th>
                 <th>${product.marketPrice}</th>
                 <th>${marketPrice.place}</th>
                 <th>${marketPrice.commentNum}</th>
             </tr>
             </c:forEach>
             </tbody>
         </table>
    </div>

</body>
</html>