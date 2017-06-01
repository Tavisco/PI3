window.onload = function () {
	//var n1 = 5000;
	var a = [5366, 5499, 5135, 5295];
	var aData = [2012,1,1];
	var b = [5198,5629,5159, 5385];
	var bData = [2013,01,01];
	var chart = new CanvasJS.Chart("ContentBody",
	{
		title:{
			text: "Custom Candle Stick"
		},
		zoomEnabled: true,
		axisY: {
			includeZero:false,
			title: "Valores",
			prefix: "R$ "
		},
		axisX: {
			title: "Tempo",
			interval:2,
			intervalType: "month",
			valueFormatString: "MMM-YY",
			labelAngle: -45
		},
		data: [
		{
			type: "candlestick",
			risingColor: "#F79B8E",
			
			dataPoints: [
				{x: new Date(aData),y:a},
				/*{x: new Date(2012,02,01),y:[5366, 5499, 5135, 5295]}
				{x: new Date(2012,03,01),y:[5296, 5378, 5154, 5248]},
				{x: new Date(2012,04,01),y:[5254, 5279, 4788, 4924]},
				{x: new Date(2012,05,01),y:[4910, 5286, 4770, 5278]},
				{x: new Date(2012,06,01),y:[5283, 5348, 5032, 5229]},
				{x: new Date(2012,07,01),y:[5220, 5448, 5164, 5258]},
				{x: new Date(2012,08,01),y:[5276, 5735, 5215, 5703]},
				{x: new Date(2012,09,01),y:[5704, 5815, 4888, 5619]},
				{x: new Date(2012,10,01),y:[5609, 5885, 5548, 5879]},
				{x: new Date(2012,11,01),y:[5878, 5965, 5823, 5905]}*/
			],
			toolTipContent: "abertura: " + a[0] +"<br>alta: " + a[1] + "<br>baixa: " + a[2] + "<br>fechamento: " + a[3],
			},
			{
			type: "candlestick",
			risingColor: "#F79B8E",
			dataPoints: [
				{x: new Date(bData),y:b}
				/*{x: new Date(2012,03,01),y:[5296, 5378, 5154, 5248]},
				{x: new Date(2012,04,01),y:[5254, 5279, 4788, 4924]},
				{x: new Date(2012,05,01),y:[4910, 5286, 4770, 5278]},
				{x: new Date(2012,06,01),y:[5283, 5348, 5032, 5229]},
				{x: new Date(2012,07,01),y:[5220, 5448, 5164, 5258]},
				{x: new Date(2012,08,01),y:[5276, 5735, 5215, 5703]},
				{x: new Date(2012,09,01),y:[5704, 5815, 4888, 5619]},
				{x: new Date(2012,10,01),y:[5609, 5885, 5548, 5879]},
				{x: new Date(2012,11,01),y:[5878, 5965, 5823, 5905]}*/
			],
			toolTipContent: "abertura: " + b[0] +"<br>alta: " + b[1] + "<br>baixa: " + b[2] + "<br>fechamento: " + b[3]
		}
		]
	});
	chart.render();
};