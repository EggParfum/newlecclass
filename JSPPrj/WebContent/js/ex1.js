
/*-------------------------------------------*/

window.addEventListener("load", function() {
	var section = document.querySelector("#ex10");
	var tbody = section.querySelector("tbody");
	var requestButton = section.querySelector(".btn-request");
	var pager = section.querySelector(".pager");
	var fieldInput = section.querySelector(".search-form select");
	var queryInput = section.querySelector(".search-form input[name=q]");
	var submitButton = section.querySelector(".search-form input[type=submit]");
	var pageElement = pager.querySelector("a");

	submitButton.onclick = function(e) {
		e.preventDefault();

		var field = fieldInput.value;
		var query = queryInput.value;

		bind(`../api/notice/list?f=${field}&q=${query}`);
	};

	pager.onclick = function(e) {
		e.preventDefault();

		if (e.target.tagName != "A")
			return;

		var page = e.target.innerText;

		// "http://localhost:8080/api/notice/list?p=2"
		// "http://localhost:8080/js/ex1.html"
		console.log(`../api/notice/list?p=${page}`);
		bind(`../api/notice/list?p=${page}`);

		//var as = pager.querySelectorAll("a");
		//console.log(as.length);

		//for(var i=0; i<as.length; i++)
		//as[i].classList.remove("text-strong");

		pageElement.classList.remove("text-strong");
		e.target.classList.add("text-strong");
		pageElement = e.target;

	};

	//requestButton.onclick = function(e){
	bind("http://localhost:8080/api/notice/list");
	//}
	function bind(url) {
		var request = new XMLHttpRequest();


		request.onload = function() {

			// tbody의 자식들을 모두 지우는 트릭
			tbody.innerHTML = "";

			console.log(request.responseText);
			// 새로운 목록으로 tbody를 채우는 코드  
		
			var list = JSON.parse(request.responseText);
		

			for (var i = 0; i < list.length; i++) {
				var tr = `<tr>
                          <td>`+ list[i].id + `</td>
                         <td>${list[i].title}</td>
                       </tr>`;

				tbody.insertAdjacentHTML("beforeend", tr);
			}

			// 2. 창과 아이콘을 제거한다.
			screen.remove();
		};

		request.onabort = function() {
			console.log("aborted");
			screen.remove();
		};

		request.open("GET", url, true);
		request.send(null);

		var screen = document.createElement("div");
		screen.style.width = "100%";
		screen.style.height = "100%";
		screen.style.backgroundColor = "black";
		screen.style.position = "absolute";
		screen.style.top = "0px";
		screen.style.left = "0px";
		screen.style.opacity = 0;
		screen.style.transition = ".5s";

		screen.style.display = "flex";
		screen.style.alignItems = "center";
		screen.style.justifyContent = "center";

		var img = document.createElement("img");
		img.src = "../images/ajax-loader.gif";
		screen.append(img);

		var closeButton = document.createElement("input");
		closeButton.value = "취소";
		closeButton.type = "button";
		closeButton.style.alignSelf = "flex-start";
		closeButton.style.position = "absolute";
		closeButton.style.right = "0px";
		screen.append(closeButton);

		closeButton.onclick = function() {
			console.log("asdf");
			request.abort();
		};

		setTimeout(function() {
			screen.style.opacity = 0.7;
		}, 0);

		section.append(screen);
	}
});

/*-------------------------------------------*/
/** 
window.addEventListener("load", function(){
	var section = document.querySelector("#ex10");
   var tbody = section.querySelector("tbody");
	var requestButton = section.querySelector(".btn-request");
   var pager = section.querySelector(".pager");
   var fieldInput = section.querySelector(".search-form select");
   var queryInput = section.querySelector(".search-form input[name=q]");
   var submitButton = section.querySelector(".search-form input[type=submit]");
   
   submitButton.onclick = function(e){
	  e.preventDefault();
	  
	  var field = fieldInput.value;
	  var query = queryInput.value;
	  
	  bind(`../api/notice/list?f=${field}&q=${query}`);
   };

   pager.onclick = function(e){
	  e.preventDefault();
	  
	  if(e.target.tagName != "A")
		 return;
	  
	  var page = e.target.innerText;
	  
	  // "http://localhost:8080/api/notice/list?p=2"
	  // "http://localhost:8080/js/ex1.html"
	  console.log(`../api/notice/list?p=${page}`);
	  bind(`../api/notice/list?p=${page}`);
	  
   };

	//requestButton.onclick = function(e){
	bind("http://localhost:8080/api/notice/list");
	//}
	function bind(url){
	  var request = new XMLHttpRequest();
	  
	  
	  request.onload = function(){
		 
		 // tbody의 자식들을 모두 지우는 트릭
		 tbody.innerHTML = "";
		    
		 // 새로운 목록으로 tbody를 채우는 코드      
		 var list = JSON.parse(request.responseText);         
		 /*
		 var tr = '<tr> \
					   <td>1</td> \
					  <td>안녕하세요</td> \
					</tr>';
		 var tbody = section.querySelector("tbody");
		 */
//1. innerHTML 
/*tobdy.innerHTML += tr;*/
//2. DOM 을 직접 생성해서 추가하는 방법
/*var tr = document.createElement("tr");
var td = document.createElement("td");
td.innerText = "1";
tr.append(td);*/
//3. template을 이용한 클론
/*var trTemplate = section.querySelector("#tr-template");
var tr = trTemplate.cloneNode(true);
tr.querySelector("td:first-child").innerText = "1";
tobdy.append(tr);*/
//4. insertAdjacentElement을 이용해서 문자열로 추가

/*var trEmpty = tbody.querySelector(".empty");
if(list.length > 0 && trEmpty != null)
   trEmpty.remove();*/
/*       
	   for(var i=0; i<list.length; i++){
		  var tr = `<tr>
						<td>`+list[i].id+`</td>
					   <td>${list[i].title}</td>
					 </tr>`;
	   
		  tbody.insertAdjacentHTML("beforeend", tr);
	   }
	   
	   // 2. 창과 아이콘을 제거한다.
	   screen.remove();
	};
    
	request.onabort = function(){
	   console.log("aborted");
	   screen.remove();
	};
    
	  request.open("GET", url, true);
	  request.send(null);

	var screen = document.createElement("div");   
	 screen.style.width = "100%";
	 screen.style.height = "100%";
	 screen.style.backgroundColor = "black";
	 screen.style.position = "absolute";
	 screen.style.top = "0px";
	 screen.style.left = "0px";
	 screen.style.opacity = 0;
	 screen.style.transition = ".5s";

	screen.style.display = "flex";
	screen.style.alignItems = "center";
	screen.style.justifyContent = "center";
    
	var img = document.createElement("img");
	img.src = "../images/ajax-loader.gif";      
	screen.append(img);
    
	var closeButton = document.createElement("input");
	closeButton.value="취소";      
	closeButton.type="button";
	closeButton.style.alignSelf = "flex-start";
	closeButton.style.position="absolute";
	closeButton.style.right = "0px";
	screen.append(closeButton);
    
	closeButton.onclick = function(){
	   request.abort();
	};
 
	 setTimeout(function(){
		 screen.style.opacity = 0.7;
	 },0);
 
	 section.append(screen);
 }
});
*/

/**프로그래밍은 모두 동기형 작동. 양자컴퓨터가 아니니깐.
 * request.open("GET", "ex1.txt", true);하면 비동기
 * request.send(null); post영역
 * 바톤을 넘겨받은 사람만이 일하는 것을 동기형식으로 일한다.
 */

//----------ex9!!! 이거 다시 꼼꼼히 해야함!!!------------------------------

window.addEventListener("load", function() {
	var section = document.querySelector("#ex9");

	var uploadBox = section.querySelector(".upload-box")
	var selButton = section.querySelector(".btn-sel");
	var fileButton = section.querySelector(".btn-file");

	uploadBox.ondragenter = function(e) {
		e.preventDefault();
		console.log("enter");
	}

	uploadBox.ondragover = function(e) {
		e.preventDefault();

		var valid = e.dataTransfer.types.indexOf("Files");
		//==="Files는 예약어?" 예약어라기 보다는 속성. 
		console.log(valid);

		//indexOf 못찾으면 index -1 반환.
		if (!valid)
			uploadBox.style.backgroundColor = "red";
		else
			uploadBox.style.backgroundColor = "green";

		//console.log(e.dataTransfer.files[0].size); 이건 drop에서 써야 확인 가능
	}

	uploadBox.ondragleave = function(e) {
		//e.preventDefault();
		uploadBox.style.backgroundColor = "initial";
	}

	uploadBox.ondrop = function(e) {
		uploadBox.style.backgroundColor = "initial";
		e.preventDefault();

		console.log(e.dataTransfer.files[0].size);

		//for(var attr in e.dataTransfer.files[0])
		//console.log(attr);
		//데이터 타입을 알아보는 거. 이 내용은 정확히 파일에서 뽑아 내서 여기서 쓸 수 있는 속성?



	}

	fileButton.onclick = function() {

	};

	fileButton.onchange = function() {

	};

	fileButton.oninput = function() {

	};

	selButton.onclick = function(e) {
		var event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		fileButton.dispatchEvent(event);
	}

});

/*
selButton.onclick = function(e){
	var event = new MouseEvent
}

*/



window.addEventListener("load", function() {
	var section = document.querySelector("#ex8");

	var product = section.querySelector(".product");
	product.onclick = function(e) {
		var target = e.target;
		if (!target.classList.contains("up")
			&& !target.classList.contains("down")
			&& !target.classList.contains("current"))
			return;

		if (target.classList.contains("up")) {
			var input = item.parentNode.querySelector("input");
			input.value = parseInt(input.value) + 1;
		}
		else if (target.classList.contains("down")) {
			var input = target.parentElement.querySelector("input");
			input.value = parseInt(input.value) - 1;
		}
		else if (target.classList.contains("current")) {
			target.parentElement.classList.toggle("current");
		}

	}
});

/* accordion에 각각 click event 달지말기.*/

window.addEventListener("load", function() {
	var section = document.querySelector("#ex7");

	//var selected = null;
	var accordion = section.querySelector(".accordion");
	accordion.onclick = function(e) {

		if (!e.target.classList.contains("title"))
			return;
		e.target.nextElementSibling.classList.toggle("d-none");
		/* previousElementSibling-형/ nextElementSibling-동생 */

		//다른 title 누르면 접어지는거 해보기
		//selected = e.target;
		//if(selected != null && seleted != e.target)
		//    e.target.classList.add("d-none");


	}
});




window.addEventListener("load", function() {
	var section = document.querySelector("#ex6");

	var container = section.querySelector(".container");
	var btnDel = section.querySelector(".btn-del");
	var btnClone = section.querySelector(".btn-clone");
	var btnChange = section.querySelector(".btn-change");

	var selected = null;

	container.onclick = function(e) {
		//className이 box가 아니면 return. 아무것도 하지말고 빠져나오센.
		if (!e.target.classList.contains("box"))
			return;
		/*console.log(e.target.className);
			tagName - [DIV]도 있고 이건 콘솔에 className - [box] 찍힘.*/
		if (selected != null && selected != e.target)
			//&& selected != e.target은 지금 선택된(e.target) 애와 다른 애.
			selected.classList.remove("selected");
		selected = e.target;
		selected.classList.toggle("selected");
		/*if(selected.classList.contains("selected"))
			selected.classList.remove("selected");
		else
			selected.classList.add("selected");
		/*자바스크립트 코드는 최대한 아끼고
		css에서 상태를 미리 만들어 놓는다. 참고로 add 중복은 안됨.
		이 코드도 toggle로 한방 해결! */

	}
	//    var boxes = container.querySelectorAll(".box");
	///**let대신 var일 때 다 3인 거 이해안됨. boxes[i]의 i가 참조변수?*/
	//    for(let i=0; i<boxes.length; i++){
	//        boxes[i].onclick = function(){
	//            selected = boxes[i];
	//            /**let을 쓰면  boxes[i]값이 됨.  */
	//            console.log(i);
	//            console.log(selected);
	//        }
	//    };

	btnDel.onclick = function() {
		if (selected != null)
			selected.remove();
	}
});


/*----------------------------------------------------------------*/
window.addEventListener("load", function() {
	var section = document.querySelector("#ex5");

	var container = section.querySelector(".container");
	var idInput = section.querySelector(".id-input");
	var colorInput = section.querySelector(".color-input");
	var btnAdd = section.querySelector(".btn-add");
	var btnDel = section.querySelector(".btn-del");
	var btnClone = section.querySelector(".btn-clone");
	var btnChange = section.querySelector(".btn-change");

	btnAdd.onclick = function() {
		/*//1. Element 객체 생성하기 (document의 기능을 통해서 img를 만들어달라.)
		var img = document.createElement("img");
		//2. Element 객체의 속성 설정하기
		img.src = "../images/1.jpg";
		//3. Element 객체를 문서에 추가하기
		container.appendChild(img);
*/

		//var txt = document.createTextNode(1);

		var div = document.createElement("div");
		div.style.backgroundColor = colorInput.value;
		div.style.width = "100px";
		div.style.height = "100px";
		div.style.borderRadius = "50px";
		div.style.textAlign = "center";
		div.style.color = "white";

		div.style.lineHeight = "100px";
		//div.appendChild(txt);
		/*
		var txt = document.createTextNode(1);
		div.appendChild(txt);
		위 둘을 합친 개선된 div.append("1");
		*/
		div.append(idInput.value);
		container.append(div);
	};

	btnDel.onclick = function() {
		var div = container.querySelector("div:first-child");
		/*container.removeChild(div);
			위 보다는 아래가 간편.
		*/
		div.remove();
	};
	btnClone.onclick = function() {
		var div = container.querySelector("div:first-child");
		var clone = div.cloneNode(true);
		container.append(clone);
	};

	btnChange.onclick = function() {
		/*var e1 = container.querySelector("div:first-child");
		var e2 = container.querySelector("div:nth-child(2)");
		위 기니까 아래로 대체가능.*/
		var es = container.querySelectorAll("div");
		var e1 = es[0];
		var e2 = es[1];
		var old = container.replaceChild(e1, e2);
		//container.insertBefore(old, e1);
		e1.insertAdjacentElement('beforebegin', old);
		//var e3 = container.querySelector("div:nth-child(3)");
		//var e4 = container.querySelector("div:nth-child(4)");
		var e3 = es[2];
		var e4 = es[3];
		var old = container.replaceChild(e3, e4);
		e3.insertAdjacentElement('beforebegin', old);
		/*container.insertBefore(old, e3);
		 대신 e3의 이웃한 위치중(position(앞에다가),old를 둔다.) */

	}
});


window.addEventListener("load", function() {
	var section = document.querySelector("#ex4");
	var container = section.querySelector(".container");
	//querySelector하면 첫 번째것만!
	var boxes = section.querySelectorAll(".box");
	var button = section.querySelector("input[value='click']");
	/*css속성 중 input을 선택. 다른 input이 있을 경우에는 value값까지 지정. */
	button.onclick = function() {
		var box = boxes[0];
		/*배열 0번째 얻어오는 것도 연산이다.
		연산 두 번씩 되는 걸 자제. 지역변수를 습관화 하자!*/
		let boxStyle = window.getComputedStyle(box);
		/*css값을 얻어낼 수 있는 스크립트. */
		var left = parseInt(boxStyle.getPropertyValue("left"));

		var tid = window.setInterval(function() {

			left++;
			console.log(left);
			box.style.left = left + "px";

			if (left >= 400)
				clearInterval(tid);


		}, 7);
	}
});


/* querySelector는 무조건 css selector를 이용한다. id인지 class인지 표시해줘야. */
window.addEventListener("load", function() {
	var section = document.querySelector("#ex3");

	var span = section.querySelector(".span");
	var btn = section.querySelector(".btn");

	btn.onclick = function() {

		window.setInterval(function() {
			var count = parseInt(span.innerText);
			count--;
			span.innerText = count;
		}, 1000)
	}
});


window.addEventListener("load", function() {
	var section = document.getElementById("ex2");
	console.log(section);

	var xInput = section.getElementsByClassName("x-input")[0];
	var yInput = section.getElementsByClassName("y-input")[0];
	var submitBtn = section.getElementsByClassName("submit-btn")[0];
	var result = section.getElementsByClassName("result")[0];

	submitBtn.onclick = function() {
		var x = parseInt(xInput.value);
		console.log(x);
		var y = parseInt(yInput.value);
		console.log(y);
		result.innerText = x + y;
	}
});


window.addEventListener("load", function() {
	var section = document.getElementById("ex1");
	var submitButton = section.getElementsByClassName("submit-btn")[0];

	submitButton.onclick = function() {
		console.log("test");
	}
});
/**setInterval 14말단에. 설명 계속 보기. */

/*window.onload = function()를 계속 쓰면 함수를 덮어쓰게 돼버려서
누적할 수 있는 함수(addEventListener)룰 써야함. 4/16 4.24:45~
"load라는 Event에 function 추가.*/





// window.addEventListener("load", function(){
//     var section = document.querySelector("#ex6");
// 
//     var container = section.querySelector(".container");
//     var btnDel = section.querySelector(".btn-del");
//     var btnClone = section.querySelector(".btn-clone");
//     var btnChange = section.querySelector(".btn-change");
// 
//     var selected = null;
// 
//     container.onclick = function(e){
// 
//         if(!e.target.classList.contains("box"))
//             return;
// 
//         //if(e.target.className != "box")
//         //    return;
//         if(selected != null && selected !=e.target)
//             selected.classList.remove("selected");
//         //console.log(e.target.tagName);
//         //console.log(e.target);
//         selected = e.target;
//         selected.classList.toggle("selected");
//         //selected.classList.add("selected");
//     }
//     // var boxes = container.querySelectorAll(".box");
// 
//     // for(let i =0; i<boxes.length; i++){
//     //     boxes[i].onclick = function(){
//     //         selected = boxes[i];
//     //         console.log(selected);
//     //     };
//     // }
//     btnDel.onclick = function(){
//         if(selected != null)
//             selected = remove();
//     }
// });
// window.addEventListener("load", function() {

//     var sec1 = document.getElementById("ex1");
//     var btnSumbit1 = sec1.getElementsByClassName('btn-submit') [0];

//     btnSumbit1.addEventListener("click", function(e){

//         console.log('test');
//     });
// /* --------------------------------- */
//     var sec2 = document.getElementById("ex2");
//     var btnSumbit2 = sec2.getElementsByClassName('btn-submit') [0];

//     btnSumbit2.addEventListener("click", function(e){

//         var x = sec2.getElementsByClassName("val") [0];
//         var y = sec2.getElementsByClassName("val") [1];

//         sec2.getElementsByClassName("result") [0].innerHTML = parseInt(x.value) + parseInt(y.value);
//     });
// /* --------------------------------- */
//     var sec3 = document.querySelector("#ex3");
//     var spanTime = sec3.querySelector(".span");
//     var btnCountDown = sec3.querySelector(".btn");

//     btnCountDown.addEventListener("click", function(e) {

//         var timer = setInterval(() => {

//             var count = parseInt(spanTime.innerHTML);
//             spanTime.innerHTML = --count;

//             if(count == 0)
//                 clearInterval(timer);
//         }, 1000);

//     });
// /* --------------------------------- */
//     var sec4 = document.querySelector("#ex4");

//     var container = sec4.querySelector(".container");
//     var boxes = container.querySelectorAll(".box");
//     var btnClick = sec4.querySelector("button");

//     btnClick.addEventListener("click", function(e) {

//         var boxStyle = getComputedStyle(boxes[0]);
//         var left = parseInt(boxStyle.getPropertyValue('left'));

//         var tid = setInterval(function() {

//             if(left > 400)
//                 clearInterval(tid);

//             boxes[0].style.left = left + 'px';
//             left++;
//         }, 17);
//     });
/* --------------------------------- */
    // var sec5 = document.querySelector("#ex5");

    // var container = sec5.querySelector(".container");
    // var btnAdd = sec5.querySelector(".btn-add");
    // var btnDel = sec5.querySelector(".btn-del");
    // var btnClone = sec5.querySelector(".btn-clone");
    // var btnChange = sec5.querySelector(".btn-change");

    // btnAdd.addEventListener("click", function(e){

/* //엘리먼트 객체 생성
var img = document.createElement('img');

//엘리먼트 객체 속성 설정
img.src = '../images/1.jpg';

//엘리먼트 객체를 문서에 추가
container.appendChild(img); */

//         var circle = document.createElement('div');
//         circle.style = 'border-radius:50%; width:100px; height:100px; color: #fff; text-align:center; line-height: 100px';

//         var id = sec5.querySelector(".id-input");
//         var color = sec5.querySelector(".color-input");

//         circle.style.backgroundColor = color.value;
//         circle.innerText = id.value;

//         container.append(circle);

//         id.value = '';
//         color.value = '';
//     });

//     btnDel.addEventListener("click", function(e){
//         var div = container.querySelector('div:first-child');
//         div.remove();
//     });

//     btnClone.addEventListener("click", function(e){

//         var div = container.querySelector('div:first-child');
//         container.append(div.cloneNode(true));
//     });

//     btnChange.addEventListener("click", function(e) {

//         /* var e1 = container.querySelector("div:nth-child(1)");
//         var e2 = container.querySelector("div:nth-child(2)"); */
//         var e1 = container.querySelector("div:first-child");
//         var e2 = container.querySelector("div:last-child");

//         var oldNode = container.replaceChild(e1, e2);
//         container.insertBefore(oldNode, e1);
//     });

//     container.addEventListener("click", function(e) {

//         var classname = e.target.className;

//         console.log(classname);

//         if(classname === 'test'){

//             var data = e.target.getAttribute('data-name');
//             console.log(data);
//         }
//     });
// });



// window.addEventListener("load", function(){
//     var section = document.querySelector("#ex5");

//     var container = section.querySelector(".container");
//     var btnAdd = section.querySelector(".btn-add");
//     var btnDel = section.querySelector(".btn-del");
//     var btnClone = section.querySelector(".btn-clone");

//     btnAdd.onclick = function(){
//         //1. Element 객체를 생성하기
//         //var img = document.createElement("img");
//         //2. Element 객체의 속성 설정하기
//         //img.src = "../images/1.jpg";
//         //3. Element 객체를 문서에 추가하기
//         //container.appendChild(img);

//         var div = document.createElement("div");


//         div.style.backgroundColor="blue";
//         div.style.width="100px";
//         div.style.height="100px";
//         div.style.borderRadius = "50px";
//         div.style.textAlign = "center";
//         div.style.color = "fff";
//         div.style.lineHeight = "100px";

//         //div.appendChild(txt);
//         container.append("1");

//         //3. Element 객체를 문서에 추가하기.
//         //container.appendChild(img);
//         //container.appendChild(div);
//         container.append(div);
//     };
//     btnDel.onclick = function(){
//         var div = container.querySelector("div:first-child");
//         // container.removeChild(div);
//         div.remove();
//     };
//     btnClone.onclick = function(){
//         var div = container.querySelector("div:first-child");
//         var clone = div.cloneNode(true);
//         container.append(clone);
//     };
//     btnChange.onclick = function(){
//     }
// });

/** 기본코드 블록
 *  window.onload = function(){
 *      var container = document.getElementById("c1");
 *      var item = container.getElementsByClassName("it1");
 * }
 */