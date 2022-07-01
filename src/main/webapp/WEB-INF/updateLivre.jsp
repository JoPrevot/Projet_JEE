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
		<form method="post" action="<c:url value="/updateLivre" />"></br>

			<fieldset>
				<legend>Modifier un livre</legend>

				<label for="idAuteurLivre">Choississez l'auteur :</label>

				<select name="idAuteurLivre" id="idAuteurLivre">
				    <c:forEach items="${ auteurs }" var="auteur">
				    <option  ${ auteur.id == livre.auteur.id ? "selected" : "" } value="${auteur.id}"><c:out value="${auteur.prenom } ${auteur.nom }"/></option>
				    </c:forEach>
				</select>

				<label for="titreLivre">Titre</label>
				<input type="text" id="titreLivre" name="titreLivre" size="40" value="${livre.titre }"/>
				<br/>

				<label for="nbPagesLivre">Nombre de pages</label>
				<input type="number" id="nbPagesLivre" name="nbPagesLivre" size="10" value="${livre.nbPages }"/>
				<br/>

				<label for="categorieLivre">Catégorie</label>
				<input type="text" id="categorieLivre" name="categorieLivre" size="20" value="${livre.categorie }"/>
				<br/>
				
				<input type="hidden" id="idLivre" name="idLivre" value="${ livre.id }"/>

			</fieldset></br>

			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
</body>
</html>