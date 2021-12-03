<%-- 
    Document   : Product
    Created on : Nov 30, 2021, 12:46:05 PM
    Author     : phien 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="LoadProduct">Moon Cakes Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">


                        <c:if test="${sessionScope.USER.roleID == 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="ManagerProduct">Manager Product</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.USER != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="LoadProduct">Hello ${USER.userName} </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="LogoutController">Logout</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.USER == null}">

                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        </c:if>    



                    </ul>
                    <%-- Search product by name --%>
                    <form action="SearchController" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txtSearch" type="text" value="${param.txtSearch}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="CartController">
                            <i class="fa fa-shopping-cart"></i> Car
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <%-- END HEARDER --%>

        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">BÁNH TRUNG THU CHẤT LƯỢNG CAO</h1>
                <p class="lead text-muted mb-0" > - Kính chào Quý Khách hàng!</p>
            </div>
        </section>


        <div class="container">



            <div class="row">


                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${LIST_CATEGORY}" var="o">
                                <li style="background-color: #ccc" class="list-group-item text-white ${categoryName == o.categoryName ? "active" :""}">
                                    <a style="text-decoration: none;" href="LoadProduct?action=showCategory&categoryID=${o.categoryID}">${o.categoryName}</a>
                                </li>
                            </c:forEach>
                            <li style="background-color: #ccc" class="list-group-item text-white ${categoryName == o.categoryName ? "active" :""}">
                                <a style="text-decoration: none;" href="LoadProduct">All</a>
                            </li>
                        </ul>
                    </div>
                    <%--Sort product--%>     
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Bộ lọc - theo giá</div>
                        <div class="card-body">
                            <h5 class="card-title"><a style="text-decoration: none; color: black" href="">Tăng dần</a></h5>
                            <h5 class="card-title"><a style="text-decoration: none; color: black" href="">Giảm dần</a></h5>
                        </div>
                    </div>    
                </div>

                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${PRODUCT.image}"></a></div>
                                        </div> <!-- slider-product.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${PRODUCT.productName}</h3>
                                        
                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num">${PRODUCT.price} VNĐ</span>
                                            </span> 
                                            <!--<span>/per kg</span>--> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Mô tả</dt>
                                            <dd><p>${PRODUCT.shortDescription} </p></dd>
                                        </dl>
                                        <dl class="item-property">
                                            <dt>Số lượng</dt>
                                            <dd><p>${PRODUCT.quantity} </p></dd>
                                        </dl>
                                        <dl class="item-property">
                                            <dt>Hạn sử dụng</dt>
                                            <dd><p>${PRODUCT.createDate} // ${PRODUCT.expirationDate} </p></dd>
                                        </dl>
                                        <hr>
                                        <c:if test="${sessionScope.PRODUCT.status == True}">
                                            <dl class="item-property">
                                                <dt>Tình trạng</dt>
                                                <dd><p>Còn hàng </p></dd>
                                            </dl>
                                            <c:url var="urlRewriting" value="AddToCartController">
                                                <c:param name="productID" value="${PRODUCT.productID}"/>
                                                <c:param name="nameProduct" value="${PRODUCT.productName}"/>
                                                <c:param name="price" value="${PRODUCT.price}"/>
                                            </c:url>
                                            <a href="${urlRewriting}" class="btn btn-lg btn-outline-primary text-uppercase">  Add to cart </a>
                                        </c:if>

                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
