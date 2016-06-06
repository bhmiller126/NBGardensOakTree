<html>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>

    <div id = "inputTable">
        <fieldset><legend>Check information:</legend>
            <table>
            <thead><h2>Check Input</h2></thead>
            <tbody>
            <tr><th>Parameter Name</th><th>Parameter Values</th></tr>
            <tr><td>Film Title</td><td>${param['title']}</td></tr>
            <tr><td>Film Director</td><td>${param['first']}</td></tr>
            <tr><td>Release Year</td><td>${param['last']}</td></tr>
            <tr><td>Film Certificate</td><td>${param['day']}</td></tr>
            <tr><td>Film Genre</td><td>${param['month']}</td></tr>
            <tr><td>Lead Actor</td><td>${param['year']}</td></tr>
            <tr><td>Lead Actor</td><td>${param['num']}</td></tr>
            <tr><td>Lead Actor</td><td>${param['email']}</td></tr>
            </tbody>
            </table>
            
            <form name = "product" action="web-order-3delivery" method = "post">
            <div id = "hiddenInputFields">
	            <input type="hidden" name="title" value="${param['title']}"/>
	            <input type="hidden" name="first" value="${param['first']}"/>
	            <input type="hidden" name="last" value="${param['last']}"/>
	            <input type="hidden" name="day" value="${param['day']}"/>
	            <input type="hidden" name="month" value="${param['month']}"/>
	            <input type="hidden" name="year" value="${param['year']}"/>
				<input type="hidden" name="num" value="${param['num']}"/>
				<input type="hidden" name="email" value="${param['email']}"/>
	            


	            <input type="submit" value="Submit"/>
            </div> <!-- End hiddenInputFields -->
            </form>
            </fieldset>
        </div> <!-- End InputTable -->

</body>
</html>