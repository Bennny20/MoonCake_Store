<%-- 
    Document   : UpdateProduct
    Created on : Nov 30, 2021, 11:17:36 AM
    Author     : phien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="UpdateController" method="post">
                    <c:set var="errors" value="${requestScope.ERRORS}"/>
                    <div class="modal-header">						
                        <h4 class="modal-title">Update Product</h4>
                    </div>
                    <div class="modal-body">
                        <%--ID--%>
                        <div class="form-group">
                            <label >ID</label>                            
                            <input type="text" name="txtID" value="${PRODUCT.productID}" class="form-control" required readonly=""/> 
                        </div>
                        <%--Name--%>
                        <div class="form-group">
                            <label>Tên</label>
                            <input value="${PRODUCT.productName}" name="txtName" type="text" class="form-control" required>

                        </div>
                        <%--Price--%>
                        <div class="form-group">
                            <label>Giá</label>
                            <input value="${PRODUCT.price}" name="txtPrice" type="text" class="form-control" required>

                        </div>
                        <%--Quantity--%>
                        <div class="form-group">
                            <label>Số lượng</label>
                            <input value="${PRODUCT.quantity}" name="txtQuantity" type="text" class="form-control" required>
                            <c:if test="${not empty errors.quantityLengthViolent}">
                                <font color="red">${$errors.quantityLengthViolent}</font>
                            </c:if>
                        </div>
                        <%--createDate--%>
                        <div class="form-group">
                            <label>NSX</label>
                            <input value="${PRODUCT.createDate}" name="txtCreateDate" type="text" class="form-control" required>
                        </div>
                        <%--HSD--%>
                        <div class="form-group">
                            <label>HSD</label>
                            <input value="${PRODUCT.expirationDate}" name="txtHSD" type="text" class="form-control" required>
                        </div>
                        <%--image--%>
                        <div class="form-group">
                            <label>Ảnh sản phẩm</label>
                            <input value="${PRODUCT.image}" name="txtImage" type="text" class="form-control" required>
                        </div>
                        <%--status--%>
                        <div class="form-group">
                            <label>Trình trạng</label>
                            <c:if test="${PRODUCT.status eq true}">
                                <input value="Còn hàng" name="txtStatus" type="text" class="form-control" required>
                            </c:if>
                            <c:if test="${PRODUCT.status eq false}">
                                <input value="Hết hàng" name="txtStatus" type="text" class="form-control" required>
                            </c:if>
                        </div>
                        <%--Description--%>
                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea name="txtDescription" class="form-control" required>${PRODUCT.shortDescription}</textarea>
                        </div>
                        <%--Category--%>
                        <div class="form-group">
                            <label>Loại bánh</label>
                            <select name="PRODUCT.categoryID" class="form-select" aria-label="Default select example">
                                <option value="CO1">Bánh dẻo</option>
                                <option value="CO2">Bánh nướng</option>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a href="ManagerProduct" class="btn btn-primary btn-lg" tabindex="-1" role="button">Back to manager product</a>
                        <input type="submit" class="btn btn-success" name="btAction" value="Save">
                    </div>
                </form>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>

    </body>
</html>
