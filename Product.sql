CREATE DATABASE LAB321_P0019_SE140851_2
GO

USE [LAB321_P0019_SE140851_2]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 11/29/2021 9:38:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[categoryID] [nvarchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 11/29/2021 9:38:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[orderID] [nvarchar](10) NULL,
	[productID] [nvarchar](10) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
)
GO

CREATE TABLE [dbo].[Orders](
	[orderID] [nvarchar](10) NOT NULL,
	[fullname] [nvarchar](50) NULL,
	[phone] [varchar](10) NULL,
	[email] [varchar](100) NULL,
	[address] [nvarchar](100) NULL,
	[dateOrder] [date] NULL,
	[total] [float] NULL,
	[userID] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 11/29/2021 9:38:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[productID] [nvarchar](10) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[createDate] [date] NULL,
	[expirationDate] [date] NULL,
	[image] [nvarchar](100) NULL,
	[status] [bit] NULL,
	[shortDescription] [nvarchar](100) NULL,
	[categoryID] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/29/2021 9:38:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[roleID] [int] NOT NULL,
	[roleName] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/29/2021 9:38:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[address] [nvarchar](100) NULL,
	[phone] [nvarchar](20) NULL,
	[roleID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT INTO [dbo].[Categories]([categoryID],[categoryName])VALUES(N'C01', N'Bánh dẻo')
INSERT INTO [dbo].[Categories]([categoryID],[categoryName])VALUES(N'C02', N'Bánh nướng')

INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P01', N'DẺO HẠT SEN 1 TRỨNG', 57000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p01.png',1 , N'180 gram Nhân hỗn hạt sen, có 1 trứng', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P04', N'DẺO SẦU RIÊNG', 62000, 5, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p04.png',1 , N'180 gram nhân hỗn hợp sầu riêng', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P05', N'DẺO ĐẬU XANH 1 TRỨNG', 52000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p05.png',1 , N'150 gram nhân hỗn hợp đậu xanh', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P07', N'DẺO CỐM DỪA HẠT DẺ', 52000, 10, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p07.png',1 , N'180 gram nhân hỗn hợp Cốm dừa hạt dẻ', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P10', N'DẺO SẦU RIÊNGg HẠT SEN', 52000, 15, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p10.png',1 , N'180 gram Nhân hỗn hạt sen, có 1 trứng', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P18', N'DẺO SỮA DỪA HẠT DƯA', 70000, 60, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p18.png',1 , N'250 gram Nhân hỗn hợp sữa dừa hạt dưa', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P20', N'DẺO JAMBON LẠP XƯỞNG', 88000, 30, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p20.png',1 , N'250 gram nhân hỗn hợp lạp xưởng, jambon, có (01) trứng', N'C01')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P02', N'DẺO THẬP CẨM', 67000, 22, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p02.png',1 , N'150 gram nhân hỗn hợp thập cẩm lạp xưởng và các loại hạt', N'C01')

INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P11', N'Gà quay sốt X.O 4 trứng', 390000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p11.png',1 , N'800 gram Nhân hỗn hợp Gà quay sốt X.O 4 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P12', N'SỮA DỪA HẠT DƯA 2 TRỨNG', 95000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p12.png',1 , N'230 gram nhân hỗn hợp sữa dừa và hạt dưa, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P13', N'LẠP XƯỞNG NGŨ HẠT 2 TRỨNG', 122000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p13.png',1 , N'230 gram nhân hỗn hợp lạp xưởng ngũ hạt, có 2 trứng.', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P14', N'SẦU RIÊNG 1 TRỨNG', 67000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p14.png',1 , N'150 gram nhân hỗn hợp sầu riêng và 1 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P15', N'KHOAI MÔN 1 TRỨNG', 62000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p15.png',1 , N'150 gram nhân hỗn hợp khoai môn, có 1 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P16', N'JAMBON XÁ XÍU 2 TRỨNG ĐẶC BIỆT', 127000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p16.png',1 , N'230 gram nhân hỗn hợp jambon xá xíu, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P17', N'HẠT SEN TRÀ XANH 2 TRỨNG ĐẶC BIỆT', 107000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p17.png',1 , N'230 gram nhân hỗn hợp hạt sen trà xanh, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P19', N'HẠT SEN DỪA TƯƠI 2 TRỨNG ĐẶC BIỆT', 137000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p19.png',1 , N'230 gram nhân hỗn hợp hạt sen dừa tươi, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P09', N'ĐẬU ĐỎ KIỂU NHẬT 2 TRỨNG ĐẶC BIỆT', 95000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p09.png',1 , N'130 gram nhân đậu đỏ, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P08', N'KHOAI MÔN HẠT SEN 2 TRỨNG', 97000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p08.png',1 , N'230 gram nhân hỗn hợp khoai môn hạt sen, có 2 trứng ', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P06', N'BÀO NGƯ 2 TRỨNG ĐẶC BIỆT', 157000, 20, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-01' AS Date), N'image\p06.png',1 , N'230 gram Nhân hỗn hợp bào ngư hải sản, có 2 trứng', N'C02')
INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])VALUES(N'P03', N'THẬP CẨM LẠP XƯỞNG', 67000, 25, 21/11/2021, 21/11/2022, N'image\p3.png',1 , N'180 gram Nhân hỗn hạt sen, có 1 trứng', N'C02')



INSERT [dbo].[Users] ([userID], [password], [fullName], [email], [address], [phone], [roleID]) VALUES (N'U01', N'123', N'Phien', N'phien123@gmail.com', N'Lam Dong', N'0898121579',  1)
INSERT [dbo].[Users] ([userID], [password], [fullName], [email], [address], [phone], [roleID]) VALUES (N'U02', N'123', N'User02', N'User02@gmail.com', N'HCM', N'0898121579', 2)
INSERT [dbo].[Users] ([userID], [fullName], [password], [email], [address], [phone], [roleID]) VALUES (N'U03', N'123', N'User03', N'User03@gmail.com', N'TPHCM', N'0898121579', 2)
INSERT [dbo].[Users] ([userID], [fullName], [password], [email], [address], [phone], [roleID]) VALUES (N'U04', N'123', N'User04', N'User03@gmail.com', N'TP.HCM', N'0121547896', 2)

INSERT INTO [dbo].[Role] VALUES (1,'ADMIN')
INSERT INTO [dbo].[Role] VALUES (2,'USER')



INSERT INTO [dbo].[Orders]([orderID],[userID],[date],[total])VALUES()

INSERT INTO [dbo].[OrderDetail]([orderDetailID],[orderID],[productID],[price],[quantity])VALUES ()

ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Orders] FOREIGN KEY([orderID])
REFERENCES [dbo].[Orders] ([orderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Orders]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Products] FOREIGN KEY([productID])
REFERENCES [dbo].[Products] ([productID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Products]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Users] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Users]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Categories] ([categoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[Role] ([roleID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Role]
GO

select * from Users
Select * from products
Select * from OrderDetail
select * from Orders

select OrderDetail.orderID, OrderDetail.productID, 
 OrderDetail.quantity, OrderDetail.price, Products.productName 
 from OrderDetail 
 INNER JOIN Products on OrderDetail.productID = Products.productID 
 Where orderID like '21340'

 INSERT INTO [dbo].[Products]([productID],[productName],[price],[quantity],[createDate],[expirationDate],[image],[status],[shortDescription],[categoryID])
 VALUES(N'P03', N'THẬP CẨM LẠP XƯỞNG', 67000, 25, 21/11/2021, 21/11/2022, N'image\p3.png',1 , N'180 gram Nhân hỗn hạt sen, có 1 trứng', N'C02') CONVERT