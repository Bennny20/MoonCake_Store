<%-- 
    Document   : Home
    Created on : Nov 29, 2021, 12:46:05 PM
    Author     : phien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%-- HEARDER --%>
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
                            <li class="nav-item">
                                <a class="nav-link" href="ViewOrderAdmin">Xem đơn hàng</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.USER.roleID == 2}">
                            <li class="nav-item">
                                <a class="nav-link" href="ViewOrder">Xem đơn hàng</a>
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
                                <button type="submit" class="btn btn-secondary btn-number" name="btAction" value="search" >
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

        <%-- BODY --%>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">BÁNH TRUNG THU CHẤT LƯỢNG CAO</h1>
                <p class="lead text-muted mb-0" > - Kính chào Quý Khách hàng!</p>
            </div>
        </section>

        <%-- Caterogy--%>
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
                            <form action="SearchController">
                                <input name="txtFrom" type="number" value="${param.txtFrom}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Price from....">
                                <input name="txtTo" type="number" value="${param.txtTo}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="To.....">                           
                                <hr>
                                <button type="submit" class="btn btn-secondary btn-number" name="btAction" value="price" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </form>                           
                        </div>
                    </div>    
                </div>

                <%--Lóad product--%>        
                <div class="col-sm-9">
                    <div class="row">


                        <c:forEach items="${LIST_PRODUCT}" var="c">

                            <input type="hidden" name="productID" value="${c.productID}" />
                            <input type="hidden" name="nameProduct" value="${c.productName}" />
                            <input type="hidden" name="price" value="${c.price}" />
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${c.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h6 class="card-title show_txt"> <a href="ProductController?productID=${c.productID}" title="View Product">${c.productName}</a></h6>
                                        <p style="background-color: #DF4B3B; text-align:center">${c.price} VNĐ</p>
                                        <div class="row">
                                            <c:if test="${sessionScope.LIST_PRODUCT.status == True}">                                              
                                                <div class="col">
                                                    <c:url var="urlRewriting" value="AddToCartController">
                                                        <c:param name="productID" value="${c.productID}"/>
                                                        <c:param name="nameProduct" value="${c.productName}"/>
                                                        <c:param name="price" value="${c.price}"/>
                                                    </c:url>
                                                    <a href="${urlRewriting}" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <%-- END BODY --%>
    </body>
</html>
