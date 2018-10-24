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
            var content = JSON.parse(data);
            var hand = content.hand;
            
            for(var contador = 0; contador < hand.length; contador++){
            	var boton = document.createElement("button");
                boton.type = "button";
                if(hand[contador].name != "Simple Card"){
                	if(hand[contador].name == "Take 2" || hand[contador].name == "Jump" || hand[contador].name == "Reverse" ){
                		var t = document.createTextNode(hand[contador].name + " " + hand[contador].color);
                        boton.appendChild(t);
                        document.body.appendChild(boton);   
                	}
                	else{//Es toma 4 o cambia color
                		var t = document.createTextNode(hand[contador].name);
                        boton.appendChild(t);
                        document.body.appendChild(boton);   
                	}         
                }
                else{//Es simple card
                	var t = document.createTextNode(hand[contador].color + " " + hand[contador].number);
                    boton.appendChild(t);
                    document.body.appendChild(boton);
                	
                }            	
            }
            
            alert("A jugar "+content.name);         
            }
    }
    xhr.open('POST', 'Update', true);
    xhr.send(null);
	
}
function UpdateAll(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText; //Este data es lo que retorna
            var content = JSON.parse(data);
                       
            alert(content+", "+content[0]);         
            }
    }
    xhr.open('POST', 'UpdateAll', true);
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
    xhr.open('POST', 'PutCard', true);
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
            var obj = JSON.parse(data);
            
            alert(obj.name+", "+obj.hand);           
        }
    }
    xhr.open('POST', 'GritarUNO', true);
    xhr.send(null);
    UpdateAll()
}
