<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

<c:url var="home" value="/" scope="request" />
<spring:url value="resources/css/style.css" var="coreCss" />
<spring:url value="resources/css/bootstrap.min.css" var="bootstrapCss" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="JSON API WS">
<meta name="author" content="Alex">

<title>JSON API WS</title>

<link href="${bootstrapCss}" rel="stylesheet">
<link href="${coreCss}" rel="stylesheet">
</head>

<body>

	<div class="container">

		<div class="central-block">
			
			<div id="feedback"></div>

			<form class="form-horizontal" id="search-form">
				<div class="form-group form-group-lg">
					<label class="col-sm-2 control-label">Expression</label>
					<div class="col-sm-10">
						<input type=text class="form-control" id="expression">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" id="bth-search"
							class="btn btn-primary btn-lg">Calculate</button>
					</div>
				</div>
			</form>
		</div>

	</div>

	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/script.js"></script>

	<script>
		jQuery(document).ready(function($) {

			$("#search-form").submit(function(event) {
				enableSearchButton(false);
				event.preventDefault();
				searchViaAjax();
			});

		});

		function searchViaAjax() {
			var expression = $("#expression").val();

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/JsonApiAndWebServiceSolution/rest/calculateExpression",
				data: expression,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					display(data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				},
				done : function(e) {
					console.log("DONE");
					enableSearchButton(true);
				}
			});

		}

		function enableSearchButton(flag) {
			$("#btn-search").prop("disabled", flag);
		}

		function display(data) {
			var json = "<h4>Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
			$('#feedback').html(json);
		}
	</script>

</body>
</html>