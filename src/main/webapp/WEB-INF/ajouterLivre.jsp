<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter livre</title>
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	
	<div class="form">
		<form method="post" action="<c:url value="/ajouterLivre" />">

			<fieldset>
				<legend>Créer un livre</legend>
				
				<label for="idAuteurLivre">Choississez l'auteur :</label>

				<select name="idAuteurLivre" id="idAuteurLivre">
				    <c:forEach items="${ auteurs }" var="auteur">
				    <option value="${auteur.id}"><c:out value="${auteur.prenom } ${auteur.nom }"/></option>
				    </c:forEach>
				</select>

				<label for="titreLivre">Titre</label>
				<input type="text" id="titreLivre" name="titreLivre" size="20" />
				<br/>

				<label for="nbPagesLivre">Nombre de pages</label>
				<input type="number" id="nbPagesLivre" name="nbPagesLivre" size="10" />
				<br/>

				<label for="categorieLivre">Catégorie</label>
				<input type="text" id="categorieLivre" name="categorieLivre" size="60" />
				<br/>

			</fieldset>

			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
</body>
</html>