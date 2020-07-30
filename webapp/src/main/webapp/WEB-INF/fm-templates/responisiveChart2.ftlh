<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Hello, world!</title>
    
    <script type = "text/javascript" language="JavaScript">

        var arr = {	
            sum: function(array) {
		var num = 0;
		for (var i = 0, l = array.length; i <l; i++) num += array[i];
		return num;
	},
        
	
	mean: function(array) {
		return arr.sum(array) / array.length;}}
    
    </script>
  </head>
  <body class "bg-warning py-5">
      <div class="col-md-6 offset-md-3">
       <div class="card">
        <div class="card-body">
     
    <h1>Hello, world from JavaScript<button class="btn-btn-success" onclick="updateChart()">Update</button></h1>
    <button class="btn-btn-info" onclick="addValue()">+1</button>
        </div>
        <div class="card-body">
    <canvas id="myChart"></canvas>
     <div class="card-body">
     </div>
    </div>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

    <script>
    var oldestdata=[4,3,5,6,3,4,5];
    var newestData=[5,6,6,5,4,3,5];
    var ctx = document.getElementById('myChart').getContext('2d');
        var chart = new Chart(ctx, {
            
            type: 'bar',
        
            data: {
                labels: ["Kasia", "Agnieszka", "Bartek", "Ola", "Adam", "Barbara", "Michał"],
                datasets: [{
                    label: 'Mean',
                    backgroundColor: 'rgb(86, 191, 79)',
                    borderColor: 'rgb(255, 99, 132)',
                    data: oldestdata
                }]
            },
        
            
            options: {}
        });
        function updateChart(){
            chart.data.datasets[0].data=newestData;
            chart.update();
        }
        function addValue(){
            chart.data.datasets[0].data.push(4);
 chart.data.labels.push("Krzysiek");
 chart.update();

        }
        </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>