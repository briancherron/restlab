<html>
<head>
<title>REST API Lab</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<h2>REST API Lab</h2>
	<h3>Resource 1: Contacts</h3>
	<h4>URL Endpoints:</h4>
	<ul>
		<li>GET /restlab/contacts - gets all contacts</li>
		<li>GET /restlab/contacts/{contactId} - gets the contact with an
			ID of {contactId}</li>
		<li>POST /restlab/contacts - creates a new contact</li>
		<li>PUT /restlab/contacts/{contactId} - updates an existing
			contact with an ID of {contactId}</li>
		<li>DELETE /restlab/contacts/{contactId} - deletes an existing
			contact with an ID of {contactId}</li>
	</ul>
	<h4>Sample Requests</h4>
	<table class="table">
		<tr>
			<th>HTTP Method</th>
			<th>URL</th>
			<th>Request Body</th>
			<th>Response Code</th>
			<th>Response Body</th>
		</tr>
		<tr>
			<td>GET</td>
			<td>/restlab/contacts</td>
			<td>n/a</td>
			<td>200 OK</td>
			<td>JSON representation of all contacts</td>
		</tr>
		<tr>
			<td>GET</td>
			<td>/restlab/contacts/1</td>
			<td>n/a</td>
			<td>200 OK</td>
			<td>JSON representation of the contact with an id=1</td>
		</tr>
		<tr>
			<td>GET</td>
			<td>/restlab/contacts/4</td>
			<td>n/a</td>
			<td>404 Not Found</td>
			<td>A 'not found' message</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>/restlab/contacts/4</td>
			<td>{ "name": "Jim James", "phonenumber": "555-123-1234",
				"emailaddress": "jim.james@restlab.com"}</td>
			<td>405 Method Not Allowed</td>
			<td>n/a</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>/restlab/contacts</td>
			<td>{ "name": "Jim James", "phonenumber": "555-123-1234",
				"emailaddress": "jim.james@restlab.com"}</td>
			<td>400 Bad Request</td>
			<td>An error message explaining that the 'phonenumber' field is
				not recognized. The JSON submitted is invalid.</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>/restlab/contacts</td>
			<td>{ "name": "Jim James", "phone": "555-123-1234", "email":
				"jim.james@restlab.com"}</td>
			<td>201 Created</td>
			<td>A JSON representation of the newly created contact,
				including the contact id.</td>
		</tr>
		<tr>
			<td>PUT</td>
			<td>/restlab/contacts/4</td>
			<td>{ "id": "4", "name": "Yim Yames", "phone": "555-123-1234",
				"email": "yim.yames@restlab.com"}</td>
			<td>200 OK</td>
			<td>n/a</td>
		</tr>
		<tr>
			<td>DELETE</td>
			<td>/restlab/contacts/2</td>
			<td>n/a</td>
			<td>200 OK</td>
			<td>n/a</td>
		</tr>
	</table>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
