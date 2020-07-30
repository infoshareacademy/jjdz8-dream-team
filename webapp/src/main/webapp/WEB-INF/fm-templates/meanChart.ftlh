<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script src="Data/statystyka2.html"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script
  src="https://code.jquery.com/jquery-3.5.1.slim.js"
  integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM="
  crossorigin="anonymous"></script>
 <script sec="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
  <script type="text/javascript" src="data.json"></script>
<script type="text/javascript" src="javascrip.js"></script>
    <script
         src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>
    <title>Mean</title>
   
    <script type = "text/javascript" language="JavaScript">
var arr = {
    sum: function(array) {
		var num = 0;
		for (var i = 0, l = array.length; i < l; i++) num += array[i];
		return num;
	},
	
	mean: function(array) {
		return arr.sum(array) / array.length;
	},
    
	
	
}
    
</script>
        
       
    </head>
    
</head>
<body>

<canvas id="ocean-volume-bar-chart" width="400" height="400"></canvas>

<script>
   
  
    names1=[2,3,4,5,6];
    names2=[3,3,3,3,3];
    names3=[5,5,5,5,5];
    names4=[4,4,4,4,4];
    names5=[2,2,2,2,3];
    names6=[4,4,5,6,5];
    names7=[2,3,5,5,5];


    const labels = ["Kasia", "Agnieszka", "Bartek", "Ola", "Adam", "Barbara", "Michał"];
    const volumes = [arr.mean(names1), arr.mean(names2), arr.mean(names3),arr.mean(names4), arr.mean(names5), arr.mean(names6),arr.mean(names7)]; 

    const dataObj = {
        labels: labels,
        datasets: [
            {
                label: "Mean",
                data: volumes,
                borderWidth: 2,
                backgroundColor: "hsla(173, 79%, 50%, 0.61) ",
              
                borderColor:"hsla(0,100%,50%,1)"
            }
        ]
    }
    new Chart("ocean-volume-bar-chart",
            {
                type: "bar",
                data: dataObj,
                options: { // configure options here
                    responsive: false
                }
            });
</script>

</body>
</html>