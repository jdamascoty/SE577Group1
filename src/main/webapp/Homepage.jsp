<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Train Ticket</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <base href="/"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>    
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.2.1/js.cookie.js"></script>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
	    $('.form-control').select2();
		});
		function toggler(val)
		{			
			if(val==1)
			{
				$("#return").hide();
				$("#returnDate").hide();
			}
			else
			{
				$("#return").show();
				$("#returnDate").show();
			}
		}
		
		
	function dateAdjuster(){
		var dtToday = new Date();
    
		var month = dtToday.getMonth() + 1;
		var day = dtToday.getDate();
		var year = dtToday.getFullYear();
		if(month < 10)
			month = '0' + month.toString();
		if(day < 10)
			day = '0' + day.toString();
		
		var maxDate = year + '-' + month + '-' + day;
		//alert(maxDate);
		$('#returnDate').attr('min', maxDate);
		$('#departure').attr('min', maxDate);
	}
	
		
	</script>
</head>
<body onload="dateAdjuster()">

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Train Ticket</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="ml-auto nav-item unauthenticated">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#signInModal">Sign In</a>
            </li>
            
            <li class="ml-auto nav-item authenticated">
                <a class="nav-link" href="/checkout">Checkout</a>
            </li>
            <li class="ml-auto nav-item authenticated dropdown">
                    <a class="nav-link" href="#" onclick="logout()">Sign Out</a>
            </li>
            
        </ul>
    </div>
</nav>



<main role="main">
	<div class="jumbotron">
        <div class="container">
		<form action="display">
           <table align="center">
			
			<tr>
				<td>
					<div class="custom-control custom-radios">
					<input type="radio" class="custom-control-input" id="defaultUnchecked" name="triptype" value="OneWay" onclick="toggler(1)">
					<label class="custom-control-label" for="defaultUnchecked">One-Way</label>
					</div>
				</td>
				<td>
					<div class="custom-control custom-radios">
					  <input type="radio" class="custom-control-input" id="defaultChecked" name="triptype" value="RoundTrip" checked onclick="toggler(0)">
					  <label class="custom-control-label" for="defaultChecked">RoundTrip</label>
					</div>
				</td>
			</tr>
			
			<tr>
			<td>From</td>
			<td>
				<input type="text" class="form-control" id="origin" placeholder="Origin" name="origin" list="listOfStops">
				<datalist id="listOfStops">
  					<c:forEach items="${listStopNames}" var="StopName">
					<option value="${StopName}">
					</c:forEach>
				</datalist>  
			</td>
			</tr>
			
			<tr>
			<td>To</td>
			<td>
				<input type="text" class="form-control" id="destination" placeholder="Destination" name="destination" list="listOfStops">
				<datalist id="listOfStops">
  					<c:forEach items="${listStopNames}" var="StopName">
					<option value="${StopName}">
					</c:forEach>
				</datalist>  
			</td>
			</tr>
			<tr>
				<td>
					<label id="" for="departure">Departure Date</label>
				</td>
				<td>
					<input type="date" class="form-control" id="departure" name="departure">
				</td>
			</tr>
			
			<tr>
				<td>
					<label id="return" for="departure">Return Date</label>
				</td>
				<td>
					<input type="date" class="form-control" id="returnDate" name="returnDate">
				</td>
			</tr>
			<tr>
			<td>
			<input class="btn btn-primary" type="submit" value="Search" onclick="printStops();">
			</td>
			</tr>
		   </table>
		   </form>
        </div>
    </div>

    <div class="container">
        
    </div>

    <div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" id="signInModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Sign In</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Get the most of our site by signing in with one of these supported services.</p>
                    <a class="btn btn-block btn-social btn-github" href="/oauth2/authorization/github" role="button">
                        <span class="fa fa-github"></span> Sign in with Github
                    </a>
                    <a class="btn btn-block btn-social btn-google" href="/oauth2/authorization/google" role="button">
                        <span class="fa fa-google"></span> Sign in with Google
                    </a>
                </div>
            </div>
        </div>
    </div>
</main>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.2.1/js.cookie.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>