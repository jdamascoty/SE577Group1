<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ page import="java.util.List" %>
    <%@ page import="edu.drexel.TrainDemo.models.StopTimeResultSet"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css"/>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.2.1/js.cookie.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>

<div class="jumbotron">

	<div class="alert alert-primary" role="alert">
	<%=request.getParameter("triptype")%>
	<br>
	<%=request.getParameter("origin")%>--><%=request.getParameter("destination")%>
	<br>	
	</div>
	
	
</div>

</head>
	
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Train Ticket</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        
    </div>
</nav>

<p class="h3">Available Routes:</p>



<table class="table-dark" align="center">
<thead>
	<tr>
	
		<% 
			
			List<StopTimeResultSet> list = (List<StopTimeResultSet>)request.getAttribute("resultSet");
			if(list==null){
				out.print("<h5 align='center'>No Available routes</h5>");
			}
			else if(list.size()==0)
			{
				out.print("<h5 align='center'>No Available routes</h5>");
			}
			else{				
				out.print("<h3>To Trip:</h3>");
				out.print("<table class='table'>");
				out.print("<thead>");
				out.print("<tr>");
					out.print("<td>");
						out.print("StartStation");
					out.print("</td>");
					out.print("<td>");
						out.print("EndStation");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Trip ID");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Departure Time");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Arrival Time");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Stop Sequence");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Price");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Book Tickets");
					out.print("</td>");
				
				out.print("</thead>");
			}
			for(StopTimeResultSet str:list)
			{	
				out.print("<form action='next'>");
				out.print("<tr>");
				out.print("<td>");
					out.print("<span class='badge'>"+str.getStopId()+"</span>");					
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getToId()+"</span>");
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getTripId()+"</span>");
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getArrival_time()+"</span>");					
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getDeparture_time()+"</span>");
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getStopSequence()+"</span>");
				out.print("</td>");
				
				out.print("<td>");
					out.print("<span class='badge'>"+str.getStopSequence()*20+"$</span>");
				out.print("</td>");
				
				out.print("<td>");
					out.print("<input class='btn btn-primary' type='submit' value='Book'/>");
				out.print("</td>");
				
				out.print("</tr>");
				out.print("</form>");
			}			
			out.print("</table>");
			List<StopTimeResultSet> twowayResult = (List<StopTimeResultSet>)request.getAttribute("twowayResultSet");
			if(twowayResult==null){
				out.print("<h5 align='center'>No Available routes for Return Trip</h5>");
			}
			else if(twowayResult.size()==0){
				out.print("<h5 align='center'>No Available routes for Return Trip</h5>");
			}
			else{
				out.print("<h3>Return Trip:</h3>");
				out.print("<table class='table'>");
				
				out.print("<thead>");
				out.print("<tr>");
					out.print("<td>");
						out.print("StartStation");
					out.print("</td>");
					out.print("<td>");
						out.print("EndStation");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Trip ID");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Departure Time");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Arrival Time");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Stop Sequence");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Price");
					out.print("</td>");
					
					out.print("<td>");
						out.print("Book Tickets");
					out.print("</td>");
				
				for(StopTimeResultSet str:twowayResult)
				{	
					out.print("<form action='next'>");
					out.print("<tr>");
					out.print("<td>");
						out.print("<span class='badge'>"+str.getStopId()+"</span>");					
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getToId()+"</span>");
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getTripId()+"</span>");
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getArrival_time()+"</span>");					
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getDeparture_time()+"</span>");
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getStopSequence()+"</span>");
					out.print("</td>");
					
					out.print("<td>");
						out.print("<span class='badge'>"+str.getStopSequence()*20+"$</span>");
					out.print("</td>");
					
					out.print("<td>");
						out.print("<input class='btn btn-primary' type='submit' value='Book'/>");
					out.print("</td>");
					
					out.print("</tr>");
					out.print("</form>");
				}				
				out.print("</table>");
			}
			
			%>
		
	</tr>
</thead>

</table>


</body>
</html>