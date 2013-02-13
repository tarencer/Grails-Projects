<html>
<head>
<meta name="layout" content="main" />
<title>What are you doing?</title>
<g:javascript library="prototype" />
</head>
<body>
	<h1>Search people to follow</h1>
	<div class="searchForm">
		<g:form controller="searchable">
			<g:textField name="q"/>
		</g:form>
	</div>
	<h1>What are you doing</h1>
	<div id="updateStatusForm">
		<g:formRemote onSuccess="document.getElementById('message').value=''" url="[action: 'updateStatus']" update="messages"
			name="updateStatusForm">
			<g:textArea name="message" value="" />
			<br />
			<g:submitButton name="UpdateStatus" />
		</g:formRemote>
		<%--<g:remoteLink url="[action: 'getRandom']" onLoaded="alert('Done');"
			onLoading="alert('Loading');">Click</g:remoteLink>
	--%>
	</div>
	<div id="messages">
		<g:render template="messages" collection="${messages}" var="message" />
	</div>
</body>
</html>
