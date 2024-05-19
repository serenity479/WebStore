<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Document</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</head>


<body>
	<header>
		<div class="fixed-top bg-info m-0">
		<div class="container clearfix">
			<nav>
				<ul class="left_header">
					<li id="authStatus"><c:out value="${login}" /></li>
					<li>
						<a id="exit" style="color: black" href="logout">Выйти</a>
					</li>				
				</ul>
				<ul class="right_header">
					<li id="counterProd" class="round" style="color: black"></li>

					<li>
						<a href="#" data-toggle="modal" data-target="#myModal2"  style="color: black">Корзина</a>
					</li>			
					<li>
						<a href="#" data-toggle="modal" data-target="#myModal1"  style="color: black">Поиск</a>
					</li>

				</ul>
			</nav>
		</div>
	</div>
	</header>


	<!-- элементы в ul -->
	 <c:forEach var = "category" items = "${ProductsCategory}">
        <section>

            <h1 class="sticky-top bg-info text_format" style="top: 34px;  height: 30px; bottom: 0px; ">"${category.name}"</h1> <!-- ${section_i} -->
            <hr size="3px" width="350px" align="center" color="black" style="height: 0.6px" >

            <ul class="products clearfix">
            <p id="extState" style="display:none">false</p>
                <c:forEach var="product" items="${category.products}"> <!-- ${ProductsSections[section_i]} -->
                    <li class="product-item" id="toggle${product.id} ">
                        <img src=${product.img} alt="pic stub" class="product">
                        <p>${product.name}</p>
                        <p class="cost">${product.cost}</p>
                        <p style="display:none">${product.id}</p>
                    </li>



                <!-- Расширенный вид  -->
                <div  class="mydiv" style="display:none; margin-left: 40px;">
                    <ul class="extend" >
                        <li>
                            <img src="img/no-image-found.jpg" alt="pic stub" class="product extend extImg"></img>
                        </li>
                        <li>
                            <p>Товар</p>
                        </li>
                        <li>
                            <p1>Цена</p1>
                        </li>
                        <li> <!-- Это для вырезания в окно корзины -->
                            <button style="display:block;">Удалить</button>
                        </li>
                        <li>
                            <a href="addToOrder/${product.id}"><button class="basketBtn" >В корзину</button></a>
                        </li>
                    </ul>
                </div>
                </c:forEach>

            </ul>
        </section>
	</c:forEach>


	<footer class="modal-footer">
		<span>Estore 2018</span>
		<span >Students production</span>
	</footer>


	<!-- Расширенный вид  -->
	<div id="myExt" class="mydiv" style="display:none; margin-left: 40px; margin-bottom: 40px;">
		<ul class="extend" id="elToBasket">							
			<li>
				<img src="img/no-image-found.jpg" alt="pic stub" class="product extend"></img>
			</li>
			<li>
				<p id="productName">Товар</p>
			</li>																						
			<li>
				<p1 id="extElCost">Цена</p1>
			</li>
			<li> <!-- Это для вырезания в окно корзины -->
				<button style="display:block;">Удалить</button>
			</li>
			<li>
				<button id="basket" class="basketBtn">В корзину</button>
			</li>							
		</ul>		
	</div>	

	<!-- Окно Поиска -->
	<div class="container">
			<!-- <h2>Modal Example</h2>
			     Button to Open the Modal 
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
			  Open modal
			</button> -->
		  
			<!-- The Modal -->
			<div class="modal" id="myModal1">
			  <div class="modal-dialog" >
				<div class="modal-content">
				
				  <!-- Modal Header -->
				  <div class="modal-header">
					<h4 class="modal-title" style="margin-left: 200px;">Поиск</h4>
					 <hr size="3px" width="350px"  color="black" style="margin-top: 40px; margin-left: -200px;" > 
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				  </div>
				  
				  <!-- Modal body -->
				  <div class="modal-body">
				  <form id="search_form" method="post" >
						<input id="inputFindProduct" name="searchProduct" class="elmsFindWind inputFindProduct" type="text" >

						<input type="submit" formaction="findByName" id="btnFindByName" class="elmsFindWind btnFind" href="javascript:void(0);" value="Найти по имени"/>
						<input type="submit" formaction="findByCost" id="btnFindByCost" class="elmsFindWind btnFind" href="javascript:void(0);" value="Найти по цене"/>
						<input type="submit" formaction="findById" id="btnFindById" class="elmsFindWind btnFind" href="javascript:void(0);" value="Найти по Id"/>


						<div class="findElements">
							<c:forEach var="product" items="${foundProducts}">
                                <div class="product-item" id="toggle${product.id} ">
                                    <img src=${product.img} alt="pic stub" class="product">
                                    <p>${product.name}</p>
                                    <p class="cost">${product.cost}</p>
                                </div>
                            </c:forEach>
						</div>
				  </form>
				  </div>
				  
				  <!-- Modal footer -->
				  <div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				  </div>
				  
				</div>
			  </div>
			</div>
			
	</div>

	<!-- Окно Корзины -->
	<div class="container1">
				<!-- <h2>Modal Example</h2>
					 Button to Open the Modal 
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
				  Open modal
				</button> -->
			  
				<!-- The Modal -->
				<div class="modal" id="myModal2">
					<div class="modal-dialog">
						<div class="modal-content">
					
					  <!-- Modal Header -->
					  <div class="modal-header">
							<h4 class="modal-title" style="margin-left: 200px;">Корзина</h4>
							<hr size="3px" width="350px"  color="black" style="margin-top: 40px; margin-left: -220px;" > 
					<button type="button" class="close" data-dismiss="modal">&times;</button>
						
					  </div>
					  
					  <!-- Modal body -->
					  <div class="modal-body">
							<div id="basketBody" class="addedElements">
								<!-- <c:forEach var="product" items="${orderedProducts}">
                                   <div class="product-item" id="toggle${product.id} ">
                                       <img src=${product.img} alt="pic stub" class="product">
                                       <p>${product.name}</p>
                                       <p class="cost">${product.cost}</p>
                                   </div>
                                </c:forEach> -->
								
							</div>		
					  </div>
					  
					  <!-- Modal footer -->
					  <div class="modal-footer ">
							<ul id="orderDetails">
									<li>
										<p id="sumProducts">
											Сумма товаров
										</p>
										<p id="discount">
											Скидка
										</p>
										<p id="total">
											Итого
										</p>
									</li>
									<li>
										<button >Оформить</button>
									</li>
							</ul>
						
					  </div>
					  
					</div>
				  </div>
				</div>
				
	</div>




		
</body>
<script src="js/main.js"></script>
</html>