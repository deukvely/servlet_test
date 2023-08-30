/**
 * 
 */
console.log("member.js");

document.addEventListener("DOMContentLoaded", function(){
	// members.json 데이터 활용해서 초기 데이터
	fetch('../AjaxMemberList.do')
	.then(result => result.json())
	.then(json => {
		for(let i in json){
			document.getElementById("list").appendChild(makeTr(json[i]));
		}
	})	
	.catch(err => console.log(err))
	
	// 버튼 클릭 이벤트
	document.getElementById('addBtn').addEventListener('click', addBtnFnc);
	document.getElementById('editBtn').addEventListener('click', editBtnFnc);
	
	function addBtnFnc(){
		//let no = document.getElementById('no');
		//let name = document.getElementById('name');
		//let phone = document.getElementById('phone');
		//let age = document.getElementById('age');
		
		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value;
		
		if(!no || !name || !phone || !age){
			alert("값을 입력해주세요.");
			return;			
		}
		
		const memb = {no, name, phone, age}
		// json -> obj : JSON.parse() json을 오브젝트로 바꿀 때
		// obj -> json : JSON.stringify() 반대
		// ajax  호출하는 방법
		fetch("../AjaxMemberAdd.do", {
			method: 'post',
			headers: {
				//'Context-Type': 'application/x-www-form-urlencoded'},
				'Context-Type': 'application/json'
				},
			body: JSON.stringify(memb) //'no='+ no + '&name=' + name + '&phone=' + phone+'&age=' + age
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'Success'){
				document.getElementById('list').appendChild(makeTr(memb));
			} else if (result.retCode == 'Fail'){
				alert(result.retCode);
			}
		})
		.catch(console.log);
		
		// initialize.
		const nodelist = document.querySelectorAll('table input');
		console.log(nodelist);
		
		nodelist.forEach(function(item){
			item.value = '';						
		})
	}
	
	function editBtnFnc(){
		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value;
		
		const target = document.getElementById('mem_'+ no);
		
		
		fetch('../AjaxMemberEdit.do',{
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
			body: 'no='+ no + '&name=' + name + '&phone=' + phone+'&age=' + age
		})
		.then(resolve => resolve.json())
		.then(json => {
			if (json.retCode == 'Sucess'){
				target.children[1].textContent = name;
				target.children[2].textContent = phone;
				target.children[3].textContent = age;
			} else if (json.retCode == 'Fail'){
				alert("에러발생");
			}
		})
		
	}
	function makeTr(member = {}){
		let tr = document.createElement('tr');
		
		tr.setAttribute('id', 'mem_'+ member.mbrId);
		tr.setAttribute('data-no', member.mbrId);
		
		tr.addEventListener('click', function(){
			document.querySelector('#no').value = tr.children[0].innerHTML;
			document.querySelector('#name').value = tr.children[1].innerHTML;
			document.querySelector('#phone').value = tr.children[2].innerHTML;
			document.querySelector('#age').value = tr.children[3].innerHTML;
		})
		
		for(let field in member){
			let td = document.createElement('td');
			td.innerText = member[field];
			tr.appendChild(td);
		}
		// 삭제 버튼 td 안에 버튼
		let btn = document.createElement('button');
		btn.addEventListener('click', deleteHandler);
			// this가 가르키는 btn. // this.parentElement 가르키는 td 한번 더 parentElement.remove()는 td의 부모 tr	
		// this.parentElement.parentElement.remove();
		// console.log(tr.children[2].innerHTML) // tr의 자식 td을 보여줌
		btn.innerText = '삭제	';
		let td = document.createElement('td');	
		td.appendChild(btn);
		tr.appendChild(td);
		// 삭제 버튼 td 안에 버튼
		//let btn = document.createElement('button');
		//btn.addEventListener('click', function () {
			// this가 가르키는 btn. // this.parentElement 가르키는 td 한번 더 parentElement.remove()는 td의 부모 tr
			
			//this.parentElement.parentElement.remove();
			// console.log(tr.children[2].innerHTML) // tr의 자식 td을 보여줌
		//})
		return tr;
	}
	
	function deleteHandler(){
		e.stopProgation(); // event 하위에서 상위(html)로 가는 것을 차단
		let delNo = this.parentElement.parentElement.dataset.no;
		console.log(delNo)
		fetch('../AjaxMemberDel.do', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
			body: 'no=' + delNo
		})	
		.then(resolve => resolve.json())
		.then(json => {
			if (json.retCode == 'Sucess'){
				this.parentElement.parentElement.remove();
			} else if (json.retCode == 'Fail'){
				alert("에러발생");
			}
		})
		.catch(console.log);
		this.parentElement.parentElement.remove();
	}	
	
	function makeTrTr(json) {
		for(let i of json){
			let value = [i["no"],i["name"], i["phone"], i["age"]];
			document.getElementById('list').appendChild(makeTr(value));
		}
	}
})