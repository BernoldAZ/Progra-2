/**
 * 
 */


function Start(){
	alert("Bienvenido.");
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
            if (data == "Que comience el juego"){
            	BtnStart.style.display = 'none';
            	
            	BtnPutCard.style.display = 'block';
            	BtnTakeCard.style.display = 'block';
            	BtnUNO.style.display = 'block';

            	alert(data);
            	
            	Update();
            	return;
            }
            alert(data);
            return;
        }
    }
    xhr.open('GET', 'StartGame', true);
    xhr.send(null);
}

function Update(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
 
            alert(data);          
        }
    }
    xhr.open('POST', 'Update', true);
    xhr.send(null);
	
}

function PutCard(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
 
            alert(data);          
        }
    }
    xhr.open('POST', 'Update', true);
    xhr.send(null);
    Update();

}

function TakeCard(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
 
            alert(data);          
        }
    }
    xhr.open('POST', 'TakeCard', true);
    xhr.send(null);
    Update();
}

function UNO(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
 
            alert(data);           
        }
    }
    xhr.open('POST', 'GritarUNO', true);
    xhr.send(null);
    Update();
}