


//Проверка авторизации и отображение пользователя
$(function () {
	console.log("При заходе...");
	var authStatus = document.getElementById("authStatus");
	var sessionValue = '<%=Session["usedData"]%>'



	//authStatus.textContent =  + " " + ; // login // выведем информацию о пользователе в header
	// можем здесь явно очищать currenLogin, чтоб пользователь заново авторизовывался каждый раз при загрузке страницы
	//localStorage.setItem("currentLogin", "");
});


/*$(document).ready(function () {
	var extView
	$(".deleteProduct").click(function () {
	 var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", "deleteProduct", true); // false for synchronous request
        var el = this.parentNode.lastChild.previousSibling;
        var extELid = el.children[0].children[3].children[0];
        xmlHttp.send(id);
        return xmlHttp.responseText;
	});
});*/


// Скрипт для отображения и скрытия расширенного вида
$(document).ready(function () {
	var extView
	$(".product-item").click(function () {
	extViewEl=this.parentNode.firstChild.nextSibling;
	extView = extViewEl.textContent;
		var el = this.parentNode.lastChild.previousSibling; // нашли div отвечающий за расширенный вид именно у этого элемента
		if (extView=="false") { // так сделал, потому что нужен индикатор именно у этой категори
			var extElName = el.children[0].children[1].children[0];//document.getElementById("productName");
			var extElCost = el.children[0].children[2].children[0];//document.getElementById("extElCost");
			var extELImg = el.children[0].children[0].children[0];
			var extElBtn = el.children[0].children[4].children[0];
			var prodId = "addToOrder/" + this.lastChild.previousSibling.innerHTML; // сюда будем писать idшник
			var img = this.children[0].getAttribute("src");
			if (el.style.display == "none") {
				el.style.display = "block";
				this.children[2].style.display = "none"; // нам не нужно дополнительно выводить цену, скопированную из объекта
				extElCost.textContent = this.children[2].textContent; // добавляем цену элемента в расширенный вид элемента, чтоб оттуда еще и в корзину
				extElName.textContent = this.children[1].textContent; // присвоим добавляемому элементу текст элемента, который был щелкнут
				extELImg.setAttribute("src", img);
				extElBtn.setAttribute("href", prodId);
				elExtend = document.getElementById(this.id); // id записываем только когда реально создаем новый div, а не когда просто кликаем на него, иначе idшник перезапишется и при нажатии на созданный div этот элемент не восстановится
				$(this).hide();
				extViewEl.textContent = "true";
			}
		} else {
			el.style.display = "none";
			$(elExtend).show();
			extViewEl.textContent = "false";
		}
	});
});


// Скрипт для выхода из расширенного вида по нажатию на сам элемент
 $ (document).ready (function(){
	   //var el = document.getElementById("myExt0");
	   $(".extend li:not(:last-child)").click(function(){
	   var el = this.parentNode.parentNode; // нашли div отвечающий за расширенный вид именно у этого элемента
		 el.style.display = "none";
		 $(elExtend).show();
   });
});





// Скрипт для поиска по элементам 
function viewFinder() { // сработает на клик по ссылке поиск
	var str = '';
	var inputEl = document.getElementById("inputFindProduct");
	var str = inputEl.value;
	var foundElement;
	var elements = $("p").filter(function () {
		if ($(this).text() === str) {
			foundElement = this.parentElement.cloneNode(true);
			//return foundElement;
		}
	});
	var parentElem = document.getElementsByClassName("findElements")[0];
	if (foundElement != null) {
		parentElem.appendChild(foundElement);
	} else {
		alert("Такого элемента не существует");
	}
}


// Скрипт для добавления эл в корзину и для для подсчета суммы товаров-->
$(document).ready(function () {
	count = 0;
	sumProducts = 0;
	var max = 10, min = 1;
	discountVal = 0;
	$(".basketBtn").click(function () {

		elCounter = document.getElementById("counterProd"); // счетчик кол-ва эл в корзине
		var parentElem = document.getElementsByClassName("addedElements")[0]; // сюда будем добавлять
		var addedElem = this.parentNode.parentNode.parentNode;//document.getElementById("elToBasket");
		var cloneAddedElem = addedElem.cloneNode(true);
		$(cloneAddedElem).addClass("basket");
		//var cloneAddedElem = $("#elToBasket").clone().addClass("basket"); // добавляем эл из расширенного вида в корзину
		//cloneAddedElem.children().eq(3).children().eq(0).addClass("btnDelete"); // добавление класса динамически созданной кнопке

		// настраиваем детали заказа(сумма товаров, скидка)
		var orderDetails = document.getElementById("orderDetails");
		sumElem = document.getElementById("sumProducts"); // это в деталях заказа, сюда выводим сумму
		var costProduct = addedElem.children[2].children[0].textContent;//document.getElementById("extElCost").textContent; // берем сумму из расширенного вида
		var discountEl = document.getElementById("discount");
		totalSum = document.getElementById("total");
		sumProducts += Number(costProduct);
		sumElem.innerHTML = "Сумма товаров " + sumProducts + "р";
		if (count == 0) { // при первом заходе в корзину определим скидку
			discountVal = Math.ceil(Math.random() * (max - min) + min);
		}
		discountEl.textContent = "Скидка " + discountVal + "%";
		totalSum.innerText = "Итого " + (sumProducts - sumProducts * discountVal / 100) + "р";

		cloneAddedElem.children[2].children[0].id = "basketElCost" + count; // изменим id у цены, добавляемой в корзину, чтоб потом ее вычитать
		cloneAddedElem.id = "basketEl" + count; // надо изменить айдишник, присвоить уникальный для удаления
		$(cloneAddedElem).appendTo("#basketBody"); // можно попробовать create element
		orderDetails.style.display = "block"; // как только что-то добавили в корзину можно отобразить детали заказа

		count++;
		console.log(count.toString());
		elCounter.innerHTML = count.toString();
	});
});


// Скрипт для удаления эл из корзины Делегированный обработчик -->
$(document).ready(function () {
	$("#basketBody").on('click', 'ul', function () { //используем делегированную обработку событий для динамически добавленных элементов
		var parentElem = document.getElementsByClassName("addedElements")[0];
		deleteElem = document.getElementById(this.id)

		var costProduct = document.getElementById(this.children[2].children[0].id).textContent; // получим цену товара из корзины
		sumProducts -= costProduct;
		sumElem.innerHTML = "Сумма товаров " + sumProducts;
		totalSum.innerText = "Итого " + (sumProducts - sumProducts * discountVal / 100) + "р";

		parentElem.removeChild(deleteElem); // удалим элемент тот, который был кликнут, отследив по Id  //parentElem.children[0]
		count--;
		elCounter.innerHTML = count.toString();
	});
});

// выход с сайта на страницу авторизации
/*$(document).ready(function () {
	$("#exit").click(function () {
		window.location.href = "\\auth";
		localStorage.setItem("currentLogin", "");
	});
});*/





