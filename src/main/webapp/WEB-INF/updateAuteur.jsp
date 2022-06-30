<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier auteur</title>
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	
	<div class="form">
		<form method="post" action="<c:url value="/updateAuteur" />">

			<fieldset>
				<legend>Modifier un auteur</legend>

				<label for="prenomAuteur">Prénom</label>
				<input type="text" id="prenomAuteur" name="prenomAuteur" size="20" value="${ auteur.prenom }"/>
				<br/>

				<label for="nomAuteur">Nom</label>
				<input type="text" id="nomAuteur" name="nomAuteur" size="20" value="${ auteur.nom }"/>
				<br/>

				<label for="telephoneAuteur">Téléphone</label>
				<input type="text" id="telephoneAuteur" name="telephoneAuteur" size="10" value="${ auteur.telephone }"/>
				<br/>

				<label for="emailAuteur">Email</label>
				<input type="email" id="emailAuteur" name="emailAuteur" size="60" value="${ auteur.email }"/>
				<br/>

			</fieldset>

			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
</body>
</html>