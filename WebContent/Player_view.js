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
	
}

function PutCard(){
	
}

function TakeCard(){
	
}

function UNO(){
	
}