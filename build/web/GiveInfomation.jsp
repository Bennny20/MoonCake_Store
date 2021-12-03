<%-- 
    Document   : GiveInfomation
    Created on : Dec 3, 2021, 2:51:57 AM
    Author     : phien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information</title>
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
                <form action="CheckOutNoLogin" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Thông tin khách hàng</h4>
                    </div>
                    <div class="modal-body">
                        <%--Full Name--%>
                        <div class="form-group">
                            <label >Full Name</label>                            
                            <input type="text" name="txtName" value="" class="form-control" required /> 
                        </div>
                        <%--Phone--%>
                        <div class="form-group">
                            <label>Phone</label>
                            <input value="" name="txtPhone" type="text" class="form-control" required>
                        </div>
                        <%--Email--%>
                        <div class="form-group">
                            <label>Email</label>
                            <input value="" name="txtEmail" type="text" class="form-control" required>

                        </div>
                        <%--Addrass--%>
                        <div class="form-group">
                            <label>Địa chỉ nhận hàng</label>
                            <input value="" name="Address" type="text" class="form-control" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-success" name="btAction" value="Back">
                        <input type="submit" class="btn btn-success" name="btAction" value="CheckOut" onclick="return confirm('Ban mu hàng thành công')">
                    </div>
                </form>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
