<!DOCTYPE html>
<html>
<head>
 <script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body>
<script type = "text/javascript" language = "javascript">
 
function callServer() {
    
	 $.ajax({
	        type: "POST",
	        url: "http://localhost:8080/lcs/servlet",
	        data: document.getElementById("inputJson").value,
	        contentType: "application/json",
	        dataType: "json",
			error: function(jqXHR) {
				        $('#info').html('');
						$('#info').append(jqXHR.status).append('  ').append(jqXHR.responseText);
					},
			success: function(data) {
						    $('#info').html('');
						  $('#info')
							 .append(JSON.stringify(data));
					}
	  })
	  
	 
	}
</script>
<form action="">
  Input String in Json Format:<br>
  <textarea id="inputJson" rows="10" cols="100" >
  </textarea>
  <br>
 
  <input type="button" id="action-button" value="Submit" onclick ="javascript:callServer()"/>
  
  <div id="info"></div>
  
</form>

</body>
</html>

