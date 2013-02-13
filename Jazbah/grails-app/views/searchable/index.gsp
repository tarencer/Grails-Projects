<html>
<head>
<meta name="layout" content="main">
</head>
<body>
	<table>
		<g:each var="person" in="${searchResult?.results}">
			<tr>
				<td>
					<div id="name">
						${person?.fullname}
					</div>
				</td>
				<td><g:link id="${person?.id}" action='follow'
						controller='status'>follow</g:link></td>
			</tr>
		</g:each>
	</table>
</body>

</html>