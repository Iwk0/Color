const selectedColor = $('#selectedColor');

$('input[type="range"]').on('change', function({target}) {
  sendColorPart(target.value, target.dataset.type);
});

function changeSelectedColor(r ,g, b) {
  selectedColor.css('background-color', `rgb(${r},${g},${b})`);
}

function sendColorPart(color, type) {
	console.log(type);
	console.log(typeof color);
	
	color = parseInt(color, 10);

	const json = {
		"type": type,
		"color": color
	};
	
	console.log(json);

  const request = $.ajax({
    url: 'http://localhost:8080/colors',
dataType: 'json',
    contentType: 'application/json; charset=utf-8',
    type: 'POST',
    data: JSON.stringify(json)
  });

  request.then(function(data) {
    changeSelectedColor(data.red, data.green, data.blue);
  })
}


