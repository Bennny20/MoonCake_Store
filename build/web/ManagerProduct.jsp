<%-- 
    Document   : ManagerProduct
    Created on : Nov 30, 2021, 11:17:36 AM
    Author     : phien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>
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
        <div class="container">
            <a href="LoadProduct" class="btn btn-primary btn-lg" tabindex="-1" role="button">Back to home</a>
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Product</b> </h2>                            
                        </div>

                        <div class="col-sm-6">                           
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>					
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${LIST}" var="c">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${c.productID}</td>
                                <td>${c.productName}</td>
                                <td>
                                    <img src="${c.image}">
                                </td>
                                <td>${c.price} $</td>
                                <td>
                                    <a href="UpdateProductroller?productID=${c.productID}"  class="edit" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="DeleteProductController?productID=${c.productID}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete" onclick="return confirm('Ban muốn xóa sản phâm này ?')">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>                    
            </div>

        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="CreateProductController" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <c:set var="error" value="${requestScope.SIGNUP_ERRS}"/>
                            <div class="modal-body">
                                <%--ID--%>
                                <div class="form-group">
                                    <label>ID</label>
                                    <input name="txtID" type="text" class="form-control" required placeholder="Format PXX">                               
                                </div>
                                
                                <%--Name--%>
                                <div class="form-group">
                                    <label>Tên</label>
                                    <input name="txtName" type="text" class="form-control" required placeholder="Tên bánh">
                                </div>
                                <%--Price--%>
                                <div class="form-group">
                                    <label>Giá</label>
                                    <input name="txtPrice" type="text" class="form-control" required placeholder="Giá bánh">
                                </div>
                                <%--Quantity--%>
                                <div class="form-group">
                                    <label>Số lượng</label>
                                    <input name="txtQuantity" type="text" class="form-control" required  placeholder="Nhập số nguyên (1,2,3...)">
                                </div>
                                <%--createDate--%>
                                <div class="form-group">
                                    <label>NSX</label>
                                    <input name="txtCreateDate" type="text" class="form-control" required placeholder="Fomat YYYY/MM/DD">
                                </div>
                                <%--HSD--%>
                                <div class="form-group">
                                    <label>HSD</label>
                                    <input name="txtHSD" type="text" class="form-control" required  placeholder="Fomat YYYY/MM/DD">
                                </div>
                                <%--image--%>
                                <div class="form-group">
                                    <label>Ảnh sản phẩm</label>
                                    <input name="txtImage" type="text" class="form-control" required placeholder="Type .jpg, .jpeg...">
                                </div>
                                <%--status--%>
                                <div class="form-group">
                                    <label>Trình trạng</label>
                                    <input name="txtStatus" type="text" class="form-control" required>
                                </div>
                                <%--Description--%>
                                <div class="form-group">
                                    <label>Mô tả</label>
                                    <textarea name="txtDescription" class="form-control" required></textarea>
                                </div>
                                <%--Category--%>
                                <div class="form-group">
                                    <label>Loại bánh</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${LIST_C}" var="dto">
                                            <option value="${dto.categoryID}">${dto.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="editEmployeeModal" class="modal fade">

            </div>


            <script src="js/manager.js" type="text/javascript"></script>

        </body>
    </html>
